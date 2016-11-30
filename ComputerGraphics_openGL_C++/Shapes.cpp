#include <GL/glut.h>;
#include <cmath>

GLsizei wh = 500, ww = 500;
int rw = 30, rh = 20;
const float DEG2RAD = 3.14159 / 180;
float circle_c = 0.0;
float circle_dc = 1.0;
int timer_period_in_ms = 100;
static int tracking = 0;
static GLsizei startX = 0;
static GLsizei startY = 0;
static GLsizei currentX = 0;
static GLsizei currentY = 0;
double radiusS;

void drawRedRect(GLsizei x, GLsizei y)
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	y = wh - y;
	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_POLYGON);
	glVertex2f(x + rw, y + rh);
	glVertex2f(x - rw, y + rh);
	glVertex2f(x - rw, y - rh);
	glVertex2f(x + rw, y - rh);
	glEnd();
	glFlush();
	glutSwapBuffers();
}

void drawYellowRect(GLsizei x, GLsizei y)
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	y = wh - y;
	glColor3f(1.0, 1.0, 0.0);
	glBegin(GL_POLYGON);
	glVertex2f(x + rw, y + rh);
	glVertex2f(x - rw, y + rh);
	glVertex2f(x - rw, y - rh);
	glVertex2f(x + rw, y - rh);
	glEnd();
	glFlush();
	glutSwapBuffers();
}

void drawCircle(float x, float y, float radius)
{
	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < 360; i++)
	{
		float degInRad = i * DEG2RAD;
		glVertex2f(x + cos(degInRad)*radius, y + sin(degInRad)*radius);

	}
	glEnd();	
}
void idleCallBack()
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glColor3f(0.0, 0.0, 1.0);
	drawCircle(circle_c ,circle_c, 20);
	circle_c += circle_dc;
	if (circle_c > ww || circle_c > wh)
		circle_c = 0;

	glutPostRedisplay();
}

void rubberCircle(GLsizei x, GLsizei y, GLsizei radius)
{
	glClearColor(0.0, 0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glColor3f(1.0, 1.0, 1.0);

	glBegin(GL_POINTS);
	glVertex2f(startX, startY);
	glEnd();

	glBegin(GL_LINE_LOOP);
	for (int i = 0; i < 360; i++)
	{
		float degInRad = i * DEG2RAD;
		glVertex2f(x + cos(degInRad)*radius, y + sin(degInRad)*radius);
	}
	glEnd();
}

void mouseMotion(GLsizei x, GLsizei yn)
{
	int y;
	if (tracking)
	{
		y = wh - yn;
		currentX = x;
		currentY = y;
		double x0 = (currentX - startX)*(currentX - startX);
		double y0 = (currentY - startY)*(currentY - startY);
		radiusS = sqrt(x0 + y0);
		rubberCircle(startX, startY, radiusS);
	}
	glutPostRedisplay();
}

void startMotion(GLsizei x, GLsizei y)
{
	tracking = 1;
	startX = x;
	startY = y;
	currentX = x;
	currentY = y;
	glPointSize(5.0);

	glutPostRedisplay();
}

void stopMotion(GLsizei x, GLsizei y)
{
	tracking = 0;
	
	currentX = x;
	currentY = y;

	glClearColor(0.0, 0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glColor3f(0.0, 1.0, 0.0);

	glBegin(GL_POINTS);
	glVertex2f(startX, startY);
	glEnd();

	drawCircle(startX, startY, radiusS);

	glutPostRedisplay();
}

void mouseButton(int button, int state, GLsizei x, GLsizei yn)
{
	int y;
	y = wh - yn;

	if (button == GLUT_LEFT_BUTTON)
	{
		if (state == GLUT_DOWN) startMotion(x, y);
		if (state == GLUT_UP) stopMotion(x, y);
	}
}

void menu(int value)
{
	switch (value)
	{
	case 1:
		glutIdleFunc(NULL);
		glutMouseFunc(NULL);
		glutMotionFunc(NULL);
		glutPassiveMotionFunc(drawYellowRect);
		glutMotionFunc(drawRedRect);
		break;
	case 2:
		glutPassiveMotionFunc(NULL);
		glutMotionFunc(NULL);
		glutMouseFunc(NULL);
		glutIdleFunc(idleCallBack);
		break;
	case 3:
		glutIdleFunc(NULL);
		glutPassiveMotionFunc(NULL);
		glutMotionFunc(NULL);
		glutMouseFunc(mouseButton);
		glutMotionFunc(mouseMotion);
		break;
	}
}

void mydisplay()
{
	glutSwapBuffers();
}

void exit(unsigned char key, int x, int y)
{
	switch (key)
	{
	case 27:
		exit(0);
		break;
	}
}

int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(wh, ww);
	glutInitWindowPosition(0, 0);
	glutCreateWindow("Project 1");

	glClearColor(0.0, 0.0, 0.0, 1.0);
	glColor3f(1.0, 1.0, 1.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0.0, (GLdouble)ww, 0.0, (GLdouble)wh, -1.0, 1.0);

	//menu creation
	glutCreateMenu(menu);
	glutAddMenuEntry("RectangleWithMouse", 1);
	glutAddMenuEntry("AutoMovingCircle", 2);
	glutAddMenuEntry("RubberbandingCircle", 3);
	glutAttachMenu(GLUT_RIGHT_BUTTON);

	glutKeyboardFunc(exit);
	glutDisplayFunc(mydisplay);
	glutMainLoop();
}

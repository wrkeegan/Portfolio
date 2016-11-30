using UnityEngine;
using System.Collections;

public class GhostMove : MonoBehaviour
{
    public PacmanMove pacman;
    public bool dead = false;

    string prevMove;
    Vector2 m = Vector2.zero;
    bool up = false;
    bool down = false;
    bool right = false;
    bool left = false;

    bool testUp = false;
    bool testDown = false;
    bool testRight = false;
    bool testLeft = false;

    void FixedUpdate ()
    {
        if (dead)
            Invoke("respawn", 15.0f);
        if (pacman.poweredUp == true && dead == false)
        {
            GetComponent<Animator>().SetFloat("DirX", 0);
            GetComponent<Animator>().SetFloat("DirY", 0);
            GetComponent<Animator>().SetBool("IsWeak", true);
        }
        else if (pacman.poweredUp == false && dead == false)
            GetComponent<Animator>().SetBool("IsWeak", false);

        //alive movement
        if (left && pacman.dead == false && pacman.gameOver == false)
        {
            m = Vector2.MoveTowards(transform.position, transform.position + Vector3.left, 8 * Time.deltaTime);
            GetComponent<Rigidbody2D>().MovePosition(m);
        }

        else if (right && pacman.dead == false && pacman.gameOver == false)
        {
            m = Vector2.MoveTowards(transform.position, transform.position + Vector3.right, 8 * Time.deltaTime);
            GetComponent<Rigidbody2D>().MovePosition(m);
        }

        else if (down && pacman.dead == false && pacman.gameOver == false)
        {
            m = Vector2.MoveTowards(transform.position, transform.position + Vector3.down, 8 * Time.deltaTime);
            GetComponent<Rigidbody2D>().MovePosition(m);
        }

        else if (up && pacman.dead == false && pacman.gameOver == false)
        {
            m = Vector2.MoveTowards(transform.position, transform.position + Vector3.up, 8 * Time.deltaTime);
            GetComponent<Rigidbody2D>().MovePosition(m);
        }
     
        Vector2 dir = m - (Vector2)transform.position;
        if (pacman.poweredUp == false && dead == false)
        {
            GetComponent<Animator>().SetFloat("DirX", dir.x);
            GetComponent<Animator>().SetFloat("DirY", dir.y);
        }

        if(dead == true)
        {
            GetComponent<Animator>().SetFloat("DDirX", dir.x);
            GetComponent<Animator>().SetFloat("DDirY", dir.y);
        }
	}

    void respawn()
    {
        dead = false;
        CancelInvoke();
    }

    void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.tag == "Pacman" && pacman.poweredUp == true)
        {
            GetComponent<Animator>().SetTrigger("Dead");
            GetComponent<Animator>().SetBool("IsWeak", false);
            dead = true;
        }

        if (collision.tag == "Pacman" && pacman.poweredUp == false && dead == false)
        {
            pacman.GetComponent<Animator>().SetTrigger("Dead");
            pacman.GetComponent<Animator>().SetBool("Moving", true);
            --pacman.lives;
            if(pacman.lives == 0)
                pacman.dead = true;
        }

        if(collision.tag == "Waypoint")
        {
            testUp = collision.GetComponent<Waypoint>().up;
            testDown = collision.GetComponent<Waypoint>().down;
            testLeft = collision.GetComponent<Waypoint>().left;
            testRight = collision.GetComponent<Waypoint>().right;

            if (!pacman.poweredUp && dead == false)
            {
                GetComponent<Animator>().SetBool("IsWeak", false);
                if (pacman.pacmanPos().x < transform.position.x && testLeft == true && prevMove != "right")
                {
                    up = false;
                    right = false;
                    down = false;
                    left = true;
                    prevMove = "left";
                }
                else if (pacman.pacmanPos().x > transform.position.x && testRight == true && prevMove != "left")
                {
                    up = false;
                    left = false;
                    down = false;
                    right = true;
                    prevMove = "right";
                }
                else if (pacman.pacmanPos().y < transform.position.y && testDown == true && prevMove != "up")
                {
                    up = false;
                    right = false;
                    left = false;
                    down = true;
                    prevMove = "down";
                }
                else if (pacman.pacmanPos().y > transform.position.y && testUp == true && prevMove != "down")
                {
                    right = false;
                    left = false;
                    down = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testRight)
                {
                    left = false;
                    down = false;
                    up = false;
                    right = true;
                    prevMove = "right";
                }
                else if (testUp)
                {
                    left = false;
                    down = false;
                    right = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testLeft)
                {
                    right = false;
                    down = false;
                    up = false;
                    left = true;
                    prevMove = "left";
                }
                else if (testDown)
                {
                    left = false;
                    right = false;
                    up = false;
                    down = true;
                    prevMove = "down";
                }
            }
            if (pacman.poweredUp && dead == false)
            {
                GetComponent<Animator>().SetBool("IsWeak", true);
                if (pacman.pacmanPos().x > transform.position.x && testLeft == true && prevMove != "right")
                {
                    up = false;
                    right = false;
                    down = false;
                    left = true;
                    prevMove = "left";
                }
                else if (pacman.pacmanPos().x < transform.position.x && testRight == true && prevMove != "left")
                {
                    up = false;
                    left = false;
                    down = false;
                    right = true;
                    prevMove = "right";
                }
                else if (pacman.pacmanPos().y > transform.position.y && testDown == true && prevMove != "up")
                {
                    up = false;
                    right = false;
                    left = false;
                    down = true;
                    prevMove = "down";
                }
                else if (pacman.pacmanPos().y < transform.position.y && testUp == true && prevMove != "down")
                {
                    right = false;
                    left = false;
                    down = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testRight)
                {
                    left = false;
                    down = false;
                    up = false;
                    right = true;
                    prevMove = "right";
                }
                else if (testUp)
                {
                    left = false;
                    down = false;
                    right = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testLeft)
                {
                    right = false;
                    down = false;
                    up = false;
                    left = true;
                    prevMove = "left";
                }
                else if (testDown)
                {
                    left = false;
                    right = false;
                    up = false;
                    down = true;
                    prevMove = "down";
                }
            }

            if (dead == true)
            {
                if (14.5 < transform.position.x && testLeft == true && prevMove != "right")
                {
                    up = false;
                    right = false;
                    down = false;
                    left = true;
                    prevMove = "left";
                }
                else if (14.5 > transform.position.x && testRight == true && prevMove != "left")
                {
                    up = false;
                    left = false;
                    down = false;
                    right = true;
                    prevMove = "right";
                }
                else if (17 < transform.position.y && testDown == true && prevMove != "up")
                {
                    up = false;
                    right = false;
                    left = false;
                    down = true;
                    prevMove = "down";
                }
                else if (17 > transform.position.y && testUp == true && prevMove != "down")
                {
                    right = false;
                    left = false;
                    down = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testRight)
                {
                    left = false;
                    down = false;
                    up = false;
                    right = true;
                    prevMove = "right";
                }
                else if (testUp)
                {
                    left = false;
                    down = false;
                    right = false;
                    up = true;
                    prevMove = "up";
                }
                else if (testLeft)
                {
                    right = false;
                    down = false;
                    up = false;
                    left = true;
                    prevMove = "left";
                }
                else if (testDown)
                {
                    left = false;
                    right = false;
                    up = false;
                    down = true;
                    prevMove = "down";
                }
            }
        }
    }
}

using UnityEngine;
using System.Collections;

public class PacmanMove : MonoBehaviour
{

    public bool poweredUp = false;
    public float speed = 0.4f;
    public GhostMove ghost;
    Vector2 pos = Vector2.zero;
    public bool dead = false;
    public int pacdotPoints = 10;
    public int score = 0;
    public int ghostPoints = 20;
    public int ghostsEaten = 0;
    public bool gameOver = false;
    public int lives = 3;
    public int dotsEaten = 0;
    public PowerUpSpawner spawner;

	void Start ()
    {
        pos = transform.position;
	}
	

	void FixedUpdate ()
    {
        Vector2 move = Vector2.MoveTowards(transform.position, pos, speed);
        GetComponent<Rigidbody2D>().MovePosition(move);

        if((Vector2)transform.position == pos && dead == false)
        {
            if (Input.GetKey(KeyCode.RightArrow) && valid(Vector2.right))
                pos = (Vector2)transform.position + Vector2.right;
            if (Input.GetKey(KeyCode.LeftArrow) && valid(Vector2.left))
                pos = (Vector2)transform.position + Vector2.left;
            if (Input.GetKey(KeyCode.UpArrow) && valid(Vector2.up))
                pos = (Vector2)transform.position + Vector2.up;
            if (Input.GetKey(KeyCode.DownArrow) && valid(Vector2.down))
                pos = (Vector2)transform.position + Vector2.down;
        }

        Vector2 dir = pos - (Vector2)transform.position;
        GetComponent<Animator>().SetFloat("DirX", dir.x);
        GetComponent<Animator>().SetFloat("DirY", dir.y);
	}

    void OnTriggerEnter2D(Collider2D collision)
    {
        if(collision.tag == "Power Up")
        {
            poweredUp = true;
            spawner.setFree(collision.GetComponent<Transform>());
            Invoke("timesUp", 5.0f);
        }

        if(collision.tag == "PacDot")
        {
            score = score + pacdotPoints;
            ++dotsEaten;
        }
        
        if(collision.tag == "Ghost" && poweredUp == true)
        {
            if (ghostsEaten == 0 && collision.GetComponent<GhostMove>().dead == false)
            {
                score = score + ghostPoints;
                ++ghostsEaten;
            }
            else if(ghostsEaten == 1 && collision.GetComponent<GhostMove>().dead == false)
            {
                score = score + (ghostPoints * 2);
                ++ghostsEaten;
            }
            else if (ghostsEaten == 2 && collision.GetComponent<GhostMove>().dead == false)
            {
                score = score + (ghostPoints * 4);
                ++ghostsEaten;
            }
            else if (ghostsEaten == 3 && collision.GetComponent<GhostMove>().dead == false)
            {
                score = score + (ghostPoints * 8);
            }
        }
        if (collision.tag == "Ghost" && poweredUp == false)
        {
            if (collision.GetComponent<GhostMove>().dead == false)
            {
                transform.position = new Vector3(14, 14, 0);
                pos = transform.position;
            }
        }
    }

    void timesUp()
    {
        poweredUp = false;
        ghostsEaten = 0;
        CancelInvoke("timesUp");
    }

    public Vector2 pacmanPos()
    {
        return pos;
    }

    bool valid(Vector2 dir)
    {
        Vector2 dest = transform.position;
        RaycastHit2D hit = Physics2D.Linecast(dest + dir, dest);
        return (hit.collider == GetComponent<Collider2D>());
    }
}

using UnityEngine;
using System.Collections;

public class EnemyMovement : MonoBehaviour
{
    public float powerUpTimer = 5.0f;
    public bool follow = true;

    PlayerMovement playerMovement;
    Transform player;
    PlayerHealth playerHealth;
    EnemyHealth enemyHealth;
    NavMeshAgent nav;

    void Awake ()
    {
        player = GameObject.FindGameObjectWithTag ("Player").transform;
        playerHealth = player.GetComponent <PlayerHealth> ();
        playerMovement = player.GetComponent<PlayerMovement>();
        enemyHealth = GetComponent <EnemyHealth> ();
        nav = GetComponent <NavMeshAgent> ();
    }


    void Update ()
    {
        if (playerMovement.poweredUp)
        {
            run();
            Invoke("chase", powerUpTimer);
        }
        if(enemyHealth.currentHealth > 0 && playerHealth.currentHealth > 0)
        {
        if (follow == true)
            nav.SetDestination(player.position);
        else if (follow == false)
        {
            transform.rotation = Quaternion.LookRotation(transform.position - player.position);
            Vector3 runTo = transform.position + transform.forward * 10;
            NavMeshHit hit;
            NavMesh.SamplePosition(runTo, out hit, 5, 1 << NavMesh.GetAreaFromName("Walkable"));
            nav.SetDestination(hit.position);
        }
        }
        else
        {
            nav.enabled = false;
        }
    }

    public void chase()
    {
        if (follow == false)
            follow = true;
        CancelInvoke("chase");
    }

    public void run()
    {
        if (follow == true)
            follow = false;
    }

    public bool checkFollow()
    {
        return follow;
    }
}

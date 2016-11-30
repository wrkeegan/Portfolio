using UnityEngine;
using System.Collections;

public class SpawnManager : MonoBehaviour {

    public PlayerHealth playerHealth;
    public GameObject newObject;
    public GameObject billboard;
    public BillBoardFollow billboardfollow;

    private float spawnTime;
    private int tracker = 0;
    private Vector3[] spawnPoints;
    private int spawnPointIndex = 0;

    void Start()
    {
        spawnTime = Random.Range(5.0f, 15.0f);
        spawnPoints = new Vector3[400];
        for (float i = -10.0f; i < 10.0f; i++)
        {
            for (float y = -10.0f; y < 10.0f; y++)
            {
                spawnPoints[spawnPointIndex] = new Vector3(i, .5f, y);
                ++spawnPointIndex;
            }
        }

        InvokeRepeating("Spawn", spawnTime, spawnTime);
    }

    void Spawn()
    {
        if (playerHealth.currentHealth <= 0f)
        {
            return;
        }

        tracker = 0;
        while (tracker == 0)
        {
            spawnPointIndex = Random.Range(0, spawnPoints.Length);

            if (Physics.CheckSphere(spawnPoints[spawnPointIndex], 0.45f) == false)
            {
                GameObject passer = Instantiate(newObject, spawnPoints[spawnPointIndex], Quaternion.identity) as GameObject;
                if (newObject.tag == "Zombear" || newObject.tag == "Zombunny" || newObject.tag == "Hellephant")
                {
                    billboardfollow.findBunny(passer);
                    billboard.transform.position = new Vector3(spawnPoints[spawnPointIndex].x, 2.8f, spawnPoints[spawnPointIndex].z);
                    Instantiate(billboard, billboard.transform.position, Quaternion.identity);
                }
                tracker = 1;
            }
        }
    }
}

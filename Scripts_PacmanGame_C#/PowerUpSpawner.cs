using UnityEngine;
using System.Collections;

public class PowerUpSpawner : MonoBehaviour {

    public GameObject powerup;
    public bool[] canPlace;

    Vector3[] locations;

	void Start ()
    {
        canPlace = new bool[6];
        for(int i = 0; i < 5; i++)
            canPlace[i] = true;

        locations = new Vector3[6];
        locations[0] = new Vector3(2, 17, 0);
        locations[1] = new Vector3(27, 17, 0);
        locations[2] = new Vector3(2, 30, 0);
        locations[3] = new Vector3(27, 2, 0);
        locations[4] = new Vector3(2, 2, 0);
        locations[5] = new Vector3(27, 30, 0);
        InvokeRepeating("spawn", 10.0f, 10.0f);
	}

    public void setFree(Transform freed)
    {
        if(freed.position.x == 27)
        {
            if (freed.position.y == 17)
            {
                canPlace[1] = true;
            }
            if (freed.position.y == 2)
            {
                canPlace[3] = true;
            }
            if (freed.position.x == 30)
            {
                canPlace[5] = true;
            }
        }

        if (freed.position.x == 2)
        {
            if (freed.position.y == 17)
            {
                canPlace[0] = true;
            }
            if (freed.position.y == 30)
            {
                canPlace[2] = true;
            }
            if (freed.position.y == 2)
            {
                canPlace[4] = true;
            }
        }
    }

    void spawn()
    {
        int t = 0;
        int attempts = 0;
        while (t == 0)
        {
            ++attempts;
            if (attempts == 5)
                t = 1;

            int loc = Random.Range(0, 5);

            if (canPlace[loc])
            {
                Instantiate(powerup, locations[loc], powerup.transform.rotation);
                canPlace[loc] = false;
                t = 1;
            }
        }
    }
}

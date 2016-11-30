using UnityEngine;
using UnityEngine.UI;
using System.Collections.Generic;

public class PlayerController : MonoBehaviour
{

    public float speed;
    public Text countText;
    public Text winText;
    public Text buffText;
    public Text superText;
    public Material redMaterial;
    public Material greenMaterial;
    List<GameObject> superPickUps = new List<GameObject>();
    public GameObject superPrefab;

    private float buffTimer;
    private float spawnTracker;
    private Vector3 spawnLocation;
    private bool collectable;
    private float buffsApplied;
    private Rigidbody rb;
    private int count;
    private int superCount;

    void Start()
    {
        rb = GetComponent<Rigidbody>();
        count = 0;
        superCount = 0;
        buffTimer = 0.0f;
        buffsApplied = 0.0f;
        SetCountText();
        winText.text = "";
        buffText.text = "";
        spawnTracker = 1.0f;
        collectable = false;
        spawnLocation = new Vector3(0.0f, 0.0f, 0.0f);
        //initilize list
        superPickUps.AddRange(GameObject.FindGameObjectsWithTag("Super Pick Up"));
    }

    void Update()
    {
        if (buffTimer > 0)
        {
            //displays buff timer
            buffText.text = "Duration: " + buffTimer.ToString("F1");
            //decrements buff timer by 1 per second
            buffTimer -= Time.deltaTime;
        }
        else
        {
            //change material of all super picks ups to red
            foreach (GameObject super in superPickUps)
            {
                super.GetComponent<Renderer>().material = redMaterial;
                super.GetComponent<BoxCollider>().isTrigger = false;
            }
            collectable = false;
        }
    }

    void FixedUpdate()
    {
        float moveHorizontal = Input.GetAxis("Horizontal");
        float moveVertical = Input.GetAxis("Vertical");

        Vector3 movement = new Vector3(moveHorizontal, 0.0f, moveVertical);

        rb.AddForce(movement * speed);
    }

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Pick Up"))
        {
            other.gameObject.SetActive(false);
            //increments buffsApplied only if duration expired from last buff
            if (buffTimer <= 0.0f && buffsApplied <= 10)
            {
                ++buffsApplied;
            }
            //applies modifier to buff timer
            buffTimer = 11.0f - buffsApplied;

            //change material of all superPickUps to green and allow pickup
            foreach (GameObject super in superPickUps)
            {
                super.GetComponent<Renderer>().material = greenMaterial;
                super.GetComponent<BoxCollider>().isTrigger = true;
            }
            collectable = true;

            ++count;
            SetCountText();
        }
        else if (other.gameObject.CompareTag("Super Pick Up"))
        {
            if (collectable == true)
            {
                //deactivates super cube if collectable
                other.gameObject.SetActive(false);
                ++superCount;
                SetCountText();
            }
        }
    }

    void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.CompareTag("Super Pick Up"))
        {
            if (collectable == false)
            {
                spawnTracker = 1.0f;
                while (spawnTracker == 1.0f)
                {
                    //sets spawn location to random position on map
                    spawnLocation = new Vector3(Random.Range(-10.0f, 10.0f), 0.5f, Random.Range(-10.0f, 10.0f));
                    //check to see if there is space
                    if (Physics.CheckSphere(spawnLocation, 0.45f) == false)
                    {
                        //spawn object
                        GameObject newCube = Instantiate(superPrefab, spawnLocation, Quaternion.identity) as GameObject;
                        superPickUps.Add(newCube);
                        spawnTracker = 0.0f;
                    }
                }
            }

        }
    }

    void SetCountText()
    {
        superText.text = "Super Cubes: " + superCount.ToString();
        countText.text = "Cubes: " + count.ToString();
        if (count >= 12)
        {
            winText.text = "You Win!";
        }
    }
}

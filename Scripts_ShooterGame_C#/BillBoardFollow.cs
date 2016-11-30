using UnityEngine;
using System.Collections;

public class BillBoardFollow : MonoBehaviour {

    public Camera m_Camera;
    public GameObject bunny;
    public EnemyMovement enemy;
    public Material Chase;
    public Material Flee;

    void Awake()
    {
        m_Camera = Camera.main;
        enemy = bunny.GetComponent<EnemyMovement>();
    }

	void Update ()
    {
        if (bunny != null)
        {
            transform.LookAt(transform.position + m_Camera.transform.rotation * Vector3.forward, m_Camera.transform.rotation * Vector3.up);
            transform.position = new Vector3(bunny.transform.position.x, transform.position.y, bunny.transform.position.z);

            if (enemy.checkFollow())
                GetComponent<Renderer>().material = Chase;
            else if (!enemy.checkFollow())
                GetComponent<Renderer>().material = Flee;
        }
        else if (bunny == null)
            Destroy(gameObject);
	}

    public void findBunny(GameObject newBunny)
    {
        bunny = newBunny;
    }
}

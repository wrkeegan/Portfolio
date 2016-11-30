using UnityEngine;
using System.Collections;

public class Pacdot : MonoBehaviour
{
    void OnTriggerEnter2D(Collider2D colision)
    {
        if (colision.name == "Pacman")
            Destroy(gameObject);
    }
}

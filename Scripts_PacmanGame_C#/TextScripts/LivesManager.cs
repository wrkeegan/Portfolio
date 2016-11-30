using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class LivesManager : MonoBehaviour
{
    public PacmanMove pacman;

    Text text;

    void Awake()
    {
        text = GetComponent<Text>();
    }

    void Update()
    {
        text.text = "Lives: " + pacman.lives;
    }
}

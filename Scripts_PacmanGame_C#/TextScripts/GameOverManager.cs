using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class GameOverManager : MonoBehaviour
{
    public PacmanMove pacman;
    public GameObject gameover;

    void Update()
    {
        if (pacman.dead == true)
            gameover.SetActive(true);
    }
}

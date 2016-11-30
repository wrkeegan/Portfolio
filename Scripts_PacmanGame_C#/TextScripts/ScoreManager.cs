using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class ScoreManager : MonoBehaviour
{
    public PacmanMove pacman;
    public GameObject finalScore;

    Text text;
    Text finalText;

    void Awake()
    {
        text = GetComponent<Text>();
        finalText = finalScore.GetComponent<Text>();
    }

    void Update()
    {
        text.text = "Score: " + pacman.score;

        if (pacman.dotsEaten == 321)
        {
            pacman.gameOver = true;
            finalText.text = "YOU WIN!" + "\n" + "Final Score: " + pacman.score;
            finalScore.SetActive(true);
        }

    }
}

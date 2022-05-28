package com.company.Models;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard
{
    private int _localScore = 0;
    private final ArrayList _scoreList = new ArrayList();


    public void AddScore(int value)
    {
        this._localScore += value;
        this._scoreList.add(value);
    }

    public ArrayList<Integer> GetHistory()
    {
        return this._scoreList;
    }

    public int GetCurrentScore()
    {
        return this._localScore;
    }

}

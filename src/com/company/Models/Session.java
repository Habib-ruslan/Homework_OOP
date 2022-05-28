package com.company.Models;

public class Session {
    private int _score;

    public void setScore(int value)
    {
        this._score = value;
    }

    public int getScore()
    {
        return this._score;
    }

    public void addScore(int value)
    {
        this._score += value;
    }
}

package com.company.Models;

import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard {
    private final ArrayList<Integer> _scoreList = new ArrayList<>();


    public void AddScore(int value) {
        this._scoreList.add(value);
    }

    public ArrayList<Integer> GetScoreboardList() {
        Collections.sort(this._scoreList);
        Collections.reverse(this._scoreList);
        return this._scoreList;
    }


}

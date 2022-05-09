package com.company;

import java.util.HashMap;

public class Model
{
    private int _budget = 0;
    private final HashMap<String, Integer> _history = new HashMap<>();


    public void AddIncome(String description, int value)
    {
        this._budget += value;
        this._history.put(description, value);
    }

    public void AddExpense(String description, int value)
    {
        this._budget -= value;
        this._history.put(description, - value);
    }

    public HashMap<String, Integer> GetHistory()
    {
        return this._history;
    }

    public int GetBudget()
    {
        return this._budget;
    }

}

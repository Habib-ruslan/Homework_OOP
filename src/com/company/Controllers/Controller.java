package com.company.Controllers;

import com.company.Models.Scoreboard;
import com.company.Services.SimonGameService;
import com.company.Views.*;

public class Controller {
    private static Controller instance;
    private Scoreboard scoreboard;

    public static Controller GetInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void SetModel(Scoreboard model) {
        this.scoreboard = model;
    }

    public void GetScoreboardAction() {
        var history = this.scoreboard.GetScoreboardList();
        var view = ScoreboardView.GetInstance();
        view.Open();
        view.UpdateHistory(history);
    }

    public void IndexAction() {
        var view = IndexView.GetInstance();
        view.Open();
    }

    public void PlayAction() throws InterruptedException {
        var service = new SimonGameService();
        service.Play();
    }

    public void AddScoreAction(int score) {
        this.scoreboard.AddScore(score);
    }

}

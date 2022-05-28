package com.company.Controllers;

import com.company.Models.Scoreboard;
import com.company.Services.SimonGameService;
import com.company.Views.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public void GetHistoryAction() {
        var history = this.scoreboard.GetHistory();
        var view = ScoreboardView.GetInstance();
        view.Open();
        view.UpdateHistory(history);
    }

    public void PrintCheckAction() {
        var data = ScoreboardView.History(this.scoreboard.GetHistory()).toString();
        this.WriteToFile(data);
    }

    private void WriteToFile(String data) {
        try {
            this.TryWriteToFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void TryWriteToFile(String data) throws IOException {
        var file = new File("./check.txt");
        if ((!file.createNewFile() && !file.exists()) || !file.canWrite()) {
            return;
        }
        var writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
    }

    public void IndexAction() {
        var view = IndexView.GetInstance();
        view.Open();
    }

    public void PlayAction() throws InterruptedException {
        var service = new SimonGameService();
        service.Play();
    }

    public void GetScoreboardAction() {
        var view = ScoreboardView.GetInstance();
        view.Open();
    }

}

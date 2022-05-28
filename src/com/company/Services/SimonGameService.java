package com.company.Services;

import com.company.Helpers.DelayHelper;
import com.company.Models.Session;
import com.company.Views.PlayView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SimonGameService {
    private PlayView view;
    private Timer timer;
    private int expectedButtonIndex;
    private int currentIndex = 0;
    private ArrayList<Integer> sequence;
    private Session session;

    private final static int SCORE_FOR_SUCCESS = 10;

    public SimonGameService() {
        this.Init();
    }

    public void Init() {
        this.view = PlayView.GetInstance();
        this.view.SetService(this);
    }

    public Timer GetTimer() {
        return this.timer;
    }

    public ArrayList<Integer> GetSequence()
    {
        return this.sequence;
    }

    public void Start() {
        this.view.ClearMessage();
        this.sequence = this.GenerateSequence();
        var view = this.view;
        var self = this;
        var listener = new ActionListener() {
            private int index = 0;

            public void actionPerformed(ActionEvent event) {
                view.HighlightButton(self.GetSequence().get(index));

                if (index == self.GetSequence().size() - 1) {
                    var timer = self.GetTimer();
                    timer.stop();
                }
                index++;
            }
        };
        this.timer = DelayHelper.CreateAndStartTimer(1000, listener, true);

        this.currentIndex = 0;
        this.expectedButtonIndex = sequence.get(this.currentIndex);
    }

    public void Play() {
        this.view.Open();
        this.view.PrintReady();
        this.CreateNewSession();
        var self = this;
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                self.Start();
            }
        };
        DelayHelper.CreateAndStartTimer(1000, listener);
    }

    private void CreateNewSession()
    {
        this.session = new Session();
    }

    private ArrayList<Integer> GenerateSequence() {
        var result = new ArrayList<Integer>();
        var date = new Date();
        var random = new Random(date.getTime());
        int length = (int) (4 + random.nextDouble() * 3);
        System.out.println(length + "\n");
        for (var i = 0; i < length; i++) {
            var index = (int) (random.nextDouble() * 4);
            result.add(index);
            System.out.println(index);
        }
        return result;
    }

    public void SendButtonInput(int buttonNumber) {
        if (buttonNumber != this.expectedButtonIndex) {
            this.Fail();
            return;
        }
        if (this.currentIndex == this.sequence.size() - 1) {
            this.Success();
            return;
        }
        this.currentIndex++;
        this.expectedButtonIndex = this.sequence.get(currentIndex);
    }

    public void Fail()
    {
        this.view.PrintFail();
        System.out.println(this.session.getScore());
    }

    public void Success()
    {
        this.view.PrintSuccess();
        this.session.addScore(SCORE_FOR_SUCCESS);
        this.view.UpdateScore(this.session.getScore());
        var self = this;
        var view = this.view;
        var readyListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                view.PrintReady();
            }
        };
        DelayHelper.CreateAndStartTimer(500, readyListener);
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                self.Start();
            }
        };
        DelayHelper.CreateAndStartTimer(1000, listener);
    }

}

package com.company.Services;

import com.company.Helpers.DelayHelper;
import com.company.Views.PlayView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SimonGameService {
    private PlayView view;
    private Timer timer;

    public SimonGameService() {
        this.Init();
    }

    public void Init() {
        this.view = PlayView.GetInstance();
    }

    public Timer GetTimer()
    {
        return this.timer;
    }

    public void Start() {
        var sequence = this.GenerateSequence();
        var view = this.view;
        var self = this;
        var listener = new ActionListener() {
            private int index = 0;

            public void actionPerformed(ActionEvent event) {
                view.HighlightButton(sequence.get(index));

                if (index == sequence.size() - 1) {
                    var timer = self.GetTimer();
                    timer.stop();
                }
                index++;
            }
        };
        this.timer = DelayHelper.CreateAndStartTimer(1000, listener, true);
    }

    public void Play() {
        this.view.Open();
        var self = this;
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                self.Start();
            }
        };
        DelayHelper.CreateAndStartTimer(1000, listener);
    }

    private ArrayList<Integer> GenerateSequence() {
        var result = new ArrayList<Integer>();
        var date = new Date();
        var random = new Random(date.getTime());
        int length = (int) (5 + random.nextDouble() * 11);
        System.out.println(length);
        for (var i = 0; i < length; i++) {
            var index = (int) (random.nextDouble() * 4);
            result.add(index);
            System.out.println(index);
        }
        return result;
    }

}

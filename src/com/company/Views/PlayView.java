package com.company.Views;

import com.company.ButtonClickListener;
import com.company.Helpers.DelayHelper;
import com.company.Helpers.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayView {
    private final static Color RED_BUTTON_COLOR = Color.RED;
    private final static Color GREEN_BUTTON_COLOR = Color.GREEN;
    private final static Color BLUE_BUTTON_COLOR = Color.BLUE;
    private final static Color YELLOW_BUTTON_COLOR = Color.YELLOW;

    private final static int RED_BUTTON_INDEX = 0;
    private final static int GREEN_BUTTON_INDEX = 1;
    private final static int BLUE_BUTTON_INDEX = 2;
    private final static int YELLOW_BUTTON_INDEX = 3;

    private final static Color RED_BUTTON_HIGHLIGHT_COLOR = new Color(255, 73, 73);
    private final static Color GREEN_BUTTON_HIGHLIGHT_COLOR = new Color(166, 253, 84);
    private final static Color BLUE_BUTTON_HIGHLIGHT_COLOR = new Color(105, 189, 255);
    private final static Color YELLOW_BUTTON_HIGHLIGHT_COLOR = new Color(255, 228, 114);

    private JFrame frame;
    private JLabel score;
    private JLabel message;

    private final ArrayList<JButton> buttons = new ArrayList<>();

    private static PlayView instance;

    public static PlayView GetInstance() {
        if (instance == null) {
            instance = new PlayView();
        }
        return instance;
    }

    private PlayView() {
        this.Init();
    }

    public void Init() {
        this.frame = new JFrame("Simon the game");
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(4, 2));

        var redButton = ViewHelper.CreateButton("Red button", "");
        redButton.setPreferredSize(new Dimension(150, 150));
        redButton.setBackground(Color.RED);

        var greenButton = ViewHelper.CreateButton("Green button", "");
        greenButton.setPreferredSize(new Dimension(150, 150));
        greenButton.setBackground(Color.GREEN);

        var blueButton = ViewHelper.CreateButton("Blue button", "");
        blueButton.setPreferredSize(new Dimension(150, 150));
        blueButton.setBackground(Color.BLUE);

        var yellowButton = ViewHelper.CreateButton("Yellow button", "");
        yellowButton.setPreferredSize(new Dimension(150, 150));
        yellowButton.setBackground(Color.YELLOW);

        this.buttons.add(redButton);
        this.buttons.add(greenButton);
        this.buttons.add(blueButton);
        this.buttons.add(yellowButton);

        this.score = new JLabel("score: 0");
        this.score.setHorizontalAlignment(0);
        this.score.setPreferredSize(new Dimension(400, 20));

        this.message = new JLabel();
        this.message.setHorizontalAlignment(0);
        this.message.setPreferredSize(new Dimension(400, 20));

        this.frame.add(redButton);
        this.frame.add(greenButton);
        this.frame.add(blueButton);
        this.frame.add(yellowButton);
        this.frame.setLayout(new FlowLayout());
        this.frame.add(score);
        this.frame.add(message);
        this.frame.setVisible(false);
    }

    public void PrintSuccess() {
        this.message.setText("Правильно!");
        this.message.setForeground(Color.GREEN);
    }

    public void PrintFail() {
        this.message.setText("Неудача :(");
        this.message.setForeground(Color.RED);
    }

    public void UpdateScore(int newScore) {
        this.score.setText("score:" + newScore);
    }

    public void HighlightButton(int buttonNumber) {
        var button = this.buttons.get(buttonNumber);
        switch (buttonNumber) {
            case RED_BUTTON_INDEX -> button.setBackground(RED_BUTTON_HIGHLIGHT_COLOR);
            case GREEN_BUTTON_INDEX -> button.setBackground(GREEN_BUTTON_HIGHLIGHT_COLOR);
            case BLUE_BUTTON_INDEX -> button.setBackground(BLUE_BUTTON_HIGHLIGHT_COLOR);
            case YELLOW_BUTTON_INDEX -> button.setBackground(YELLOW_BUTTON_HIGHLIGHT_COLOR);
        }

        var self = this;
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                self.DisableHighlightForButton(buttonNumber);
            }
        };
        DelayHelper.CreateAndStartTimer(500, listener);
    }

    public void DisableHighlightForButton(int buttonNumber) {
        var button = this.buttons.get(buttonNumber);
        switch (buttonNumber) {
            case RED_BUTTON_INDEX -> button.setBackground(RED_BUTTON_COLOR);
            case GREEN_BUTTON_INDEX -> button.setBackground(GREEN_BUTTON_COLOR);
            case BLUE_BUTTON_INDEX -> button.setBackground(BLUE_BUTTON_COLOR);
            case YELLOW_BUTTON_INDEX -> button.setBackground(YELLOW_BUTTON_COLOR);
        }
    }

    public void Close() {
        this.frame.setVisible(false);
    }

    public void Open() {
        this.frame.setVisible(true);
    }
}
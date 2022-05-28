package com.company.Views;

import com.company.ButtonClickListener;
import com.company.Helpers.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IndexView {
    private JFrame frame;
    private static IndexView instance;

    public static IndexView GetInstance() {
        if (instance == null) {
            instance = new IndexView();
        }
        return instance;
    }

    private IndexView() {
        this.Init();
    }

    public void Init() {
        this.frame = new JFrame("Simon the game");
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(2, 1));

        var headerLabel = new JLabel("", JLabel.CENTER);
        var statusLabel = new JLabel("", JLabel.CENTER);
        var button = ViewHelper.CreateButton("Button 1", "Play");
        button.setPreferredSize(new Dimension(400, 50));
        button.setBackground(new Color(236, 197, 68));
        ViewHelper.AddCommandForButton(button, ButtonClickListener.PLAY_ACTION);

        var button2 = ViewHelper.CreateButton("Button 2", "Scoreboard");
        button2.setPreferredSize(new Dimension(400, 50));
        button2.setBackground(new Color(88, 212, 0));
        ViewHelper.AddCommandForButton(button2, ButtonClickListener.GET_SCOREBOARD_ACTION);

        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        this.frame.add(headerLabel);
        this.frame.add(controlPanel);
        this.frame.add(statusLabel);
        this.frame.add(button);
        this.frame.add(button2);
        this.frame.setVisible(false);
        this.frame.setLayout(new FlowLayout());
    }

    public void Open() {
        this.frame.setVisible(true);
    }

}

package com.company.Views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ScoreboardView {
    private static final int DESCRIPTION_LENGTH = 150;

    private JFrame historyFrame;
    private JTextArea historyInfo;

    private static ScoreboardView instance;

    public static ScoreboardView GetInstance() {
        if (instance == null) {
            instance = new ScoreboardView();
        }
        return instance;
    }

    private ScoreboardView() {
        this.Init();
    }

    public void Init() {
        this.historyFrame = new JFrame("Scoreboard");
        this.historyFrame.setSize(900, 400);
        this.historyFrame.setLayout(new GridLayout(3, 1));
        this.historyInfo = new JTextArea();
        this.historyFrame.add(this.historyInfo);
        this.historyFrame.setLayout(new FlowLayout());
        this.historyFrame.setVisible(false);
    }

    public void UpdateHistory(ArrayList<Integer> history) {
        this.historyInfo.setText((History(history).toString()));
    }

    public static StringBuilder History(ArrayList<Integer> history) {
        StringBuilder str = new StringBuilder();
        if (history.size() == 0) {
            System.out.println("Таблица рекордов пуста...");
            return new StringBuilder();
        }
        for (var i = 0; i < history.size(); i++) {
            str.append(FormatCell(String.valueOf(i))).append(" | ").append((history.get(i))).append(" |\n");
        }
        System.out.println(str);
        return str;
    }

    private static String FormatCell(String cell) {
        if (cell.length() < DESCRIPTION_LENGTH) {
            var newCell = new StringBuilder();
            var tabLeft = (DESCRIPTION_LENGTH - cell.length()) / 2;
            var tabRight = tabLeft + (DESCRIPTION_LENGTH - cell.length()) % 2;
            newCell.append(" ".repeat(tabLeft));
            newCell.append(cell);
            newCell.append(" ".repeat(tabRight));

            return newCell.toString();
        }
        return cell.substring(0, DESCRIPTION_LENGTH);
    }

    public void Open() {
        this.historyFrame.setVisible(true);
    }
}

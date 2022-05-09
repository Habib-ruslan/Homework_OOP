package com.company.Views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class HistoryView {
    private static final int DESCRIPTION_LENGTH = 150;

    private JFrame historyFrame;
    private JTextArea historyInfo;

    private static HistoryView instance;

    public static HistoryView GetInstance() {
        if (instance == null) {
            instance = new HistoryView();
        }
        return instance;
    }

    private HistoryView() {
        this.Init();
    }

    public void Init() {
        this.historyFrame = new JFrame("История");
        this.historyFrame.setSize(900, 400);
        this.historyFrame.setLayout(new GridLayout(3, 1));
        this.historyInfo = new JTextArea();
        this.historyFrame.add(this.historyInfo);
        this.historyFrame.setLayout(new FlowLayout());
        this.historyFrame.setVisible(false);
    }

    public void UpdateHistory(HashMap<String, Integer> history) {
        this.historyInfo.setText((History(history).toString()));
    }

    public static StringBuilder History(HashMap<String, Integer> history) {
        StringBuilder str = new StringBuilder();
        if (history.size() == 0) {
            System.out.println("История операций пуста...");
            return new StringBuilder();
        }
        for (var entry : history.entrySet()) {
            str.append(FormatCell(entry.getKey())).append(" | ").append(entry.getValue()).append(" |\n");
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

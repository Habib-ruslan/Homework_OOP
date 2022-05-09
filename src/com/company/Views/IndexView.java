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

    private JTextArea budgetInfo;

    public static IndexView GetInstance()
    {
        if (instance == null) {
            instance = new IndexView();
        }
        return instance;
    }

    private IndexView()
    {
        this.Init();
    }
    public void Init() {
        this.frame = new JFrame("Main menu");
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(3, 1));

        JLabel headerLabel = new JLabel("", JLabel.CENTER);
        JLabel statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        var button = ViewHelper.CreateButton("Button1", "Добавить доход");
        ViewHelper.AddCommandForButton(button, ButtonClickListener.ADD_INCOME_INDEX_ACTION);

        var button2 = ViewHelper.CreateButton("Button 2", "Добавить расход");
        ViewHelper.AddCommandForButton(button2, ButtonClickListener.ADD_EXPENDITURE_INDEX_ACTION);

        var button3 = ViewHelper.CreateButton("Button 3", "Посмотреть историю операций");
        ViewHelper.AddCommandForButton(button3, ButtonClickListener.HISTORY_INDEX_ACTION);

        var button4 = ViewHelper.CreateButton("Button 4", "Распечатать чек");
        ViewHelper.AddCommandForButton(button4, ButtonClickListener.PRINT_CHECK_INDEX_ACTION);

        this.budgetInfo = new JTextArea();
        this.UpdateBudget(0);

        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        this.frame.add(this.budgetInfo);
        this.frame.add(headerLabel);
        this.frame.add(controlPanel);
        this.frame.add(statusLabel);
        this.frame.add(button);
        this.frame.add(button2);
        this.frame.add(button3);
        this.frame.add(button4);
        this.frame.setVisible(false);
        this.frame.setLayout(new FlowLayout());
    }

    public void UpdateBudget(int budget) {
        this.budgetInfo.setText(
                """
                                     Добро пожаловать!
                Текущий бюджет:""" + " " + budget + "\n" + """
                                      Выберете действие:
                                                                                """);
    }

    public void Open()
    {
        this.frame.setVisible(true);
    }

}

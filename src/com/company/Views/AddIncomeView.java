package com.company.Views;

import com.company.ButtonClickListener;
import com.company.Helpers.ViewHelper;

import javax.swing.*;
import java.awt.*;

public class AddIncomeView {
    private JFrame frame;
    private JSpinner incomeComponent;
    private JTextField incomeDescriptionComponent;

    private static AddIncomeView instance;

    public static AddIncomeView GetInstance()
    {
        if (instance == null) {
            instance = new AddIncomeView();
        }
        return instance;
    }

    private AddIncomeView()
    {
        this.Init();
    }

    public void Init() {
        this.frame = new JFrame("Добавить доход");
        this.frame.setSize(400, 400);
        this.frame.setLayout(new GridLayout(3, 1));

        var enterSumLabel = new JLabel("Введите сумму: ", JLabel.LEFT);
        this.incomeComponent = new JSpinner();
        var enterDescriptionLabel = new JLabel("Введите описание: ", JLabel.LEFT);
        this.incomeDescriptionComponent = new JTextField();
        this.incomeComponent.getEditor().setPreferredSize(new Dimension(200, 20));
        this.incomeDescriptionComponent.setPreferredSize(new Dimension(200, 30));
        var button = ViewHelper.CreateButton("Submit Button", "Добавить");
        ViewHelper.AddCommandForButton(button, ButtonClickListener.ADD_INCOME_CREATE_ACTION);

        this.frame.add(enterSumLabel);
        this.frame.add(this.incomeComponent);
        this.frame.add(enterDescriptionLabel);
        this.frame.add(this.incomeDescriptionComponent);
        this.frame.add(button);
        this.frame.setLayout(new FlowLayout());
        this.frame.setVisible(false);
    }

    public void Close() {
        this.frame.setVisible(false);
    }

    public void Open() {
        this.incomeComponent.setValue(0);
        this.incomeDescriptionComponent.setText("");
        this.frame.setVisible(true);
    }

    public int GetIncomeValue() {
        return (int) this.incomeComponent.getValue();
    }

    public String GetIncomeDescription() {
        return this.incomeDescriptionComponent.getText();
    }
}

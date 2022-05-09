package com.company.Views;

import com.company.ButtonClickListener;
import com.company.Helpers.ViewHelper;

import javax.swing.*;
import java.awt.*;

public class AddExpenditureView {
    private JSpinner expenditureComponent;
    private JTextField expenditureDescriptionComponent;
    private JFrame addExpenditureFrame;
    private static AddExpenditureView instance;

    public static AddExpenditureView GetInstance()
    {
        if (instance == null) {
            instance = new AddExpenditureView();
        }
        return instance;
    }

    private AddExpenditureView()
    {
        this.Init();
    }

    public void Init() {
        this.addExpenditureFrame = new JFrame("Добавить расход");
        this.addExpenditureFrame.setSize(400, 400);
        this.addExpenditureFrame.setLayout(new GridLayout(3, 1));

        var enterSumLabel = new JLabel("Введите сумму: ", JLabel.LEFT);
        this.expenditureComponent = new JSpinner();
        var enterDescriptionLabel = new JLabel("Введите описание: ", JLabel.LEFT);
        this.expenditureDescriptionComponent = new JTextField();
        this.expenditureComponent.getEditor().setPreferredSize(new Dimension(200, 20));
        this.expenditureDescriptionComponent.setPreferredSize(new Dimension(200, 30));
        var button = ViewHelper.CreateButton("Submit Button", "Добавить");
        ViewHelper.AddCommandForButton(button, ButtonClickListener.ADD_EXPENDITURE_CREATE_ACTION);

        this.addExpenditureFrame.add(enterSumLabel);
        this.addExpenditureFrame.add(this.expenditureComponent);
        this.addExpenditureFrame.add(enterDescriptionLabel);
        this.addExpenditureFrame.add(this.expenditureDescriptionComponent);
        this.addExpenditureFrame.add(button);
        this.addExpenditureFrame.setLayout(new FlowLayout());
        this.addExpenditureFrame.setVisible(false);
    }

    public int GetExpenditureValue() {
        return (int) this.expenditureComponent.getValue();
    }

    public String GetExpenditureDescription() {
        return this.expenditureDescriptionComponent.getText();
    }

    public void Open() {

        this.addExpenditureFrame.setVisible(true);
        this.expenditureComponent.setValue(0);
        this.expenditureDescriptionComponent.setText("");
    }

    public void CloseExpenditureAction()
    {
        this.addExpenditureFrame.setVisible(false);
    }
}

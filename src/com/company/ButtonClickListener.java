package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final Controller _controller;
    public ButtonClickListener(Controller controller)
    {
        this._controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "addIncome": this._controller.AddIncomeIndexAction(); break;
            case "addExpenditure": this._controller.AddExpenditureIndexAction(); break;
            case "submitAddIncome": this._controller.AddIncomeCreateAction(); break;
            case "submitAddExpenditure": this._controller.AddExpenditureCreateAction(); break;
            case "getHistory": this._controller.GetHistoryAction(); break;
            case "printCheck": this._controller.PrintCheckAction(); break;
        }
    }
}
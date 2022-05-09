package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    public static final String ADD_INCOME_INDEX_ACTION = "addIncome";
    public static final String ADD_INCOME_CREATE_ACTION = "submitAddIncome";
    public static final String ADD_EXPENDITURE_INDEX_ACTION = "addExpenditure";
    public static final String ADD_EXPENDITURE_CREATE_ACTION = "submitAddExpenditure";
    public static final String HISTORY_INDEX_ACTION = "getHistory";
    public static final String PRINT_CHECK_INDEX_ACTION = "printCheck";

    @Override
    public void actionPerformed(ActionEvent e) {
        var controller = Controller.GetInstance();

        var command = e.getActionCommand();
        switch (command) {
            case ADD_INCOME_INDEX_ACTION -> controller.AddIncomeIndexAction();
            case ADD_INCOME_CREATE_ACTION -> controller.AddIncomeCreateAction();
            case ADD_EXPENDITURE_INDEX_ACTION -> controller.AddExpenditureIndexAction();
            case ADD_EXPENDITURE_CREATE_ACTION -> controller.AddExpenditureCreateAction();
            case HISTORY_INDEX_ACTION -> controller.GetHistoryAction();
            case PRINT_CHECK_INDEX_ACTION -> controller.PrintCheckAction();
        }
    }
}
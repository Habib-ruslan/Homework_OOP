package com.company.Views;

import com.company.ButtonClickListener;
import com.company.Controller;
import com.company.Helpers.ViewHelper;
import com.company.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class View {
    private static final int DESCRIPTION_LENGTH = 150;

    private JFrame mainFrame;
    private JFrame addActionFrame;
    private JFrame addExpenditureFrame;

    private JFrame historyFrame;

    private final Controller _controller;
    private final Model _model;

    private JSpinner IncomeComponent;
    private JSpinner ExpenditureComponent;
    private JTextField IncomeDescriptionComponent;
    private JTextField ExpenditureDescriptionComponent;

    private JTextArea HistoryInfo;

    private JTextArea BudgetInfo;

    public View(Controller controller, Model model) {
        this._controller = controller;
        this._model = model;
        this.RenderMainFrame();
        this.RenderAddActionFrame();
        this.RenderAddExpenditureFrame();
        this.RenderHistoryFrame();
    }

    public void RenderMainFrame() {
        this.mainFrame = new JFrame("Main menu");
        this.mainFrame.setSize(400, 400);
        this.mainFrame.setLayout(new GridLayout(3, 1));

        JLabel headerLabel = new JLabel("", JLabel.CENTER);
        JLabel statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        var button = ViewHelper.CreateButton("Button1", "Добавить доход");
        ViewHelper.AddCommandForButton(button, "addIncome", this._controller);

        var button2 = ViewHelper.CreateButton("Button 2", "Добавить расход");
        ViewHelper.AddCommandForButton(button2, "addExpenditure", this._controller);

        var button3 = ViewHelper.CreateButton("Button 3", "Посмотреть историю операций");
        ViewHelper.AddCommandForButton(button3, "getHistory", this._controller);

        var button4 = ViewHelper.CreateButton("Button 4", "Распечатать чек");
        ViewHelper.AddCommandForButton(button4, "printCheck", this._controller);

        this.BudgetInfo = new JTextArea();
        this.UpdateBudget();

        this.mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        this.mainFrame.add(this.BudgetInfo);
        this.mainFrame.add(headerLabel);
        this.mainFrame.add(controlPanel);
        this.mainFrame.add(statusLabel);
        this.mainFrame.add(button);
        this.mainFrame.add(button2);
        this.mainFrame.add(button3);
        this.mainFrame.add(button4);
        this.mainFrame.setVisible(true);
        this.mainFrame.setLayout(new FlowLayout());
    }

    public void RenderAddExpenditureFrame() {
        this.addExpenditureFrame = new JFrame("Добавить расход");
        this.addExpenditureFrame.setSize(400, 400);
        this.addExpenditureFrame.setLayout(new GridLayout(3, 1));

        var enterSumLabel = new JLabel("Введите сумму: ", JLabel.LEFT);
        this.ExpenditureComponent = new JSpinner();
        var enterDescriptionLabel = new JLabel("Введите описание: ", JLabel.LEFT);
        this.ExpenditureDescriptionComponent = new JTextField();
        this.ExpenditureComponent.getEditor().setPreferredSize(new Dimension(200, 20));
        this.ExpenditureDescriptionComponent.setPreferredSize(new Dimension(200, 30));
        var button = ViewHelper.CreateButton("Submit Button", "Добавить");
        ViewHelper.AddCommandForButton(button, "submitAddExpenditure", this._controller);

        this.addExpenditureFrame.add(enterSumLabel);
        this.addExpenditureFrame.add(this.ExpenditureComponent);
        this.addExpenditureFrame.add(enterDescriptionLabel);
        this.addExpenditureFrame.add(this.ExpenditureDescriptionComponent);
        this.addExpenditureFrame.add(button);
        this.addExpenditureFrame.setLayout(new FlowLayout());
        this.addExpenditureFrame.setVisible(false);
    }

    public void RenderAddActionFrame() {
        this.addActionFrame = new JFrame("Добавить доход");
        this.addActionFrame.setSize(400, 400);
        this.addActionFrame.setLayout(new GridLayout(3, 1));

        var enterSumLabel = new JLabel("Введите сумму: ", JLabel.LEFT);
        this.IncomeComponent = new JSpinner();
        var enterDescriptionLabel = new JLabel("Введите описание: ", JLabel.LEFT);
        this.IncomeDescriptionComponent = new JTextField();
        this.IncomeComponent.getEditor().setPreferredSize(new Dimension(200, 20));
        this.IncomeDescriptionComponent.setPreferredSize(new Dimension(200, 30));
        var button = ViewHelper.CreateButton("Submit Button", "Добавить");
        ViewHelper.AddCommandForButton(button, "submitAddIncome", this._controller);

        this.addActionFrame.add(enterSumLabel);
        this.addActionFrame.add(this.IncomeComponent);
        this.addActionFrame.add(enterDescriptionLabel);
        this.addActionFrame.add(this.IncomeDescriptionComponent);
        this.addActionFrame.add(button);
        this.addActionFrame.setLayout(new FlowLayout());
        this.addActionFrame.setVisible(false);
    }

    public void RenderHistoryFrame()
    {
        this.historyFrame = new JFrame("История");
        this.historyFrame.setSize(900, 400);
        this.historyFrame.setLayout(new GridLayout(3, 1));

        this.HistoryInfo = new JTextArea();
        this.historyFrame.add(this.HistoryInfo);
        this.historyFrame.setLayout(new FlowLayout());
        this.historyFrame.setVisible(false);
    }

    public void UpdateHistory(HashMap<String, Integer> history)
    {
        this.HistoryInfo.setText((History(history).toString()));
    }

    public int GetIncomeValue() {
        return (int) this.IncomeComponent.getValue();
    }

    public String GetIncomeDescription() {
        return this.IncomeDescriptionComponent.getText();
    }

    public int GetExpenditureValue() {
        return (int) this.ExpenditureComponent.getValue();
    }

    public String GetExpenditureDescription() {
        return this.ExpenditureDescriptionComponent.getText();
    }

    public void UpdateBudget() {
        this.BudgetInfo.setText(
                """
                                     Добро пожаловать!
                Текущий бюджет:""" + " " + this._model.GetBudget() + "\n" + """
                                      Выберете действие:
                                                                                """);
    }

    public void OpenAddExpenditure() {

        this.addExpenditureFrame.setVisible(true);
        this.ExpenditureComponent.setValue(0);
        this.ExpenditureDescriptionComponent.setText("");
    }

    public void OpenAddAction() {
        this.addActionFrame.setVisible(true);
        this.IncomeComponent.setValue(0);
        this.IncomeDescriptionComponent.setText("");
    }

    public void OpenHistoryFrame()
    {
        this.historyFrame.setVisible(true);
    }
    public void CloseAddAction() {
        this.addActionFrame.setVisible(false);
    }

    public void CloseExpenditureAction()
    {
        this.addExpenditureFrame.setVisible(false);
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

}

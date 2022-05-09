package com.company;

import com.company.Views.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private Model _model;
    private View _view;

    public void SetModel(Model model) {
        this._model = model;
    }

    public void SetView(View view) {
        this._view = view;
    }

    public void GetHistoryAction() {
        var history = this._model.GetHistory();
        this._view.OpenHistoryFrame();
        this._view.UpdateHistory(history);
    }

    public void PrintCheckAction() {
        var data = View.History(this._model.GetHistory()).toString();
        this.WriteToFile(data);
    }

    private void WriteToFile(String data) {
        try {
            this.TryWriteToFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void TryWriteToFile(String data) throws IOException {
        var file = new File("./check.txt");
        if ((!file.createNewFile() && !file.exists()) || !file.canWrite()) {
            return;
        }
        var writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
    }

    public void AddIncomeIndexAction() {
        this._view.OpenAddAction();
    }

    public void AddExpenditureIndexAction() {
        this._view.OpenAddExpenditure();
    }

    public void AddIncomeCreateAction() {
        this._model.AddIncome(this._view.GetIncomeDescription(), this._view.GetIncomeValue());
        this._view.CloseAddAction();
        this._view.UpdateBudget();
    }

    public void AddExpenditureCreateAction() {
        this._model.AddExpense(this._view.GetExpenditureDescription(), this._view.GetExpenditureValue());
        this._view.CloseExpenditureAction();
        this._view.UpdateBudget();
    }

}

package com.company;

import com.company.Views.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private static Controller instance;
    private Model _model;

    public static Controller GetInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void SetModel(Model model) {
        this._model = model;
    }

    public void GetHistoryAction() {
        var history = this._model.GetHistory();
        var view = HistoryView.GetInstance();
        view.Open();
        view.UpdateHistory(history);
    }

    public void PrintCheckAction() {
        var data = HistoryView.History(this._model.GetHistory()).toString();
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

    public void IndexAction() {
        var view = IndexView.GetInstance();
        view.Open();
    }

    public void AddIncomeIndexAction() {
        var view = AddIncomeView.GetInstance();
        view.Open();
    }

    public void AddExpenditureIndexAction() {
        var view = AddExpenditureView.GetInstance();
        view.Open();
    }

    public void AddIncomeCreateAction() {
        var view = AddIncomeView.GetInstance();
        this._model.AddIncome(view.GetIncomeDescription(), view.GetIncomeValue());
        view.Close();
        var mainView = IndexView.GetInstance();
        mainView.UpdateBudget(this._model.GetBudget());
    }

    public void AddExpenditureCreateAction() {
        var view = AddExpenditureView.GetInstance();
        this._model.AddExpense(view.GetExpenditureDescription(), view.GetExpenditureValue());
        view.CloseExpenditureAction();
        var mainView = IndexView.GetInstance();
        mainView.UpdateBudget(this._model.GetBudget());
    }

}

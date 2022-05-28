package com.company;

import com.company.Controllers.Controller;
import com.company.Models.Scoreboard;

public class Main {

    public static void main(String[] args) {
        var controller = Controller.GetInstance();
        controller.SetModel(new Scoreboard());

        controller.IndexAction();
    }
}

package com.company;

import com.company.Views.View;

public class Main {

    public static void main(String[] args)
    {
        var controller = new Controller();
        var model = new Model();
        controller.SetModel(model);
        var view = new View(controller, model);
        controller.SetView(view);
    }
}

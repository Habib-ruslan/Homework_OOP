package com.company;

public class Main {

    public static void main(String[] args)
    {
        var controller = Controller.GetInstance();
        controller.SetModel(new Model());

        controller.IndexAction();
    }
}

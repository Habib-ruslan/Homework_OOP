package com.company.Helpers;

import com.company.ButtonClickListener;
import com.company.Controller;

import javax.swing.*;

public class ViewHelper {
    public static JButton CreateButton(String name, String text)
    {
        var button = new JButton();
        button.setName(name);
        button.setSize(50, 50);
        button.setBounds(5, 10, 50, 50);
        button.setText(text);
        return button;
    }

    public static void AddCommandForButton(JButton button, String command, Controller controller)
    {
        button.addActionListener(new ButtonClickListener(controller));
        button.setActionCommand(command);
    }
}

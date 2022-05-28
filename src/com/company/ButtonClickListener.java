package com.company;

import com.company.Controllers.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    public static final String PLAY_ACTION = "play";
    public static final String GET_SCOREBOARD_ACTION = "scoreboard";

    @Override
    public void actionPerformed(ActionEvent e) {
        var controller = Controller.GetInstance();

        var command = e.getActionCommand();
        switch (command) {
            case PLAY_ACTION -> {
                try {
                    controller.PlayAction();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case GET_SCOREBOARD_ACTION -> controller.GetScoreboardAction();
        }
    }
}
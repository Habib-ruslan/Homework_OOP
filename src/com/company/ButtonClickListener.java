package com.company;

import com.company.Controllers.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    public static final String PLAY_ACTION = "play";
    public static final String GET_SCOREBOARD_ACTION = "scoreboard";
    public static final String HISTORY_INDEX_ACTION = "getHistory";
    public static final String PRINT_CHECK_INDEX_ACTION = "printCheck";

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
            case HISTORY_INDEX_ACTION -> controller.GetHistoryAction();
            case PRINT_CHECK_INDEX_ACTION -> controller.PrintCheckAction();
        }
    }
}
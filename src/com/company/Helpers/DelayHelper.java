package com.company.Helpers;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DelayHelper {
    public static Timer CreateAndStartTimer(int delay, ActionListener listener, boolean repeats) {
        Timer timer = new Timer(delay, listener);
        timer.setRepeats(repeats);
        timer.start();
        return timer;
    }

    public static void CreateAndStartTimer(int delay, ActionListener listener) {
        CreateAndStartTimer(delay, listener, false);
    }
}

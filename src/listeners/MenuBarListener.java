package listeners;

import models.Samotnik;
import util.GameVersion;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;

public class MenuBarListener implements ActionListener {

    private final Samotnik samotnik;
    private Color color;

    public MenuBarListener() {
        this.samotnik = Samotnik.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source) {
            case "NEW_GAME":
                samotnik.newGame();
                break;
            case "GAME_OVER":
                samotnik.close();
                break;
            case "ABOUT_GAME": {
                String text = Util.getResourceBundle().getString("modal.about_game.text");
                String title = Util.getResourceBundle().getString("modal.about_game.title");
                JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            case "ABOUT_APPLICATION": {
                String title = Util.getResourceBundle().getString("modal.about_application.title");
                String author = Util.getResourceBundle().getString("modal.about_application.author");
                String authorValue = Util.getResourceBundle().getString("modal.about_application.author.value");
                String version = Util.getResourceBundle().getString("modal.about_application.version");
                String versionValue = Util.getResourceBundle().getString("modal.about_application.version.value");
                String releaseDate = Util.getResourceBundle().getString("modal.about_application.releaseDate");
                String releaseDateValue = Util.getResourceBundle().getString("modal.about_application.releaseDate.value");

                Formatter formatter = new Formatter();
                formatter.format("%-25s %s %n%-23s %s %n%-17s %s", author, authorValue, version, versionValue, releaseDate, releaseDateValue);

                JOptionPane.showMessageDialog(null, formatter.toString(), title, JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            case "BACKGROUND_COLOR": {
                String title = Util.getResourceBundle().getString("modal.background_color.title");
                color = samotnik.getBackgroundColor();
                color = JColorChooser.showDialog(null, title, color);
                samotnik.setBackgroundColor(color);
                break;
            }
            case "COUNTER_COLOR": {
                String title = Util.getResourceBundle().getString("modal.counter_color.title");
                color = JColorChooser.showDialog(null, title, samotnik.getCounterColor());
                samotnik.setCounterColor(color);
                break;
            }
            case "POINT_COLOR": {
                String title = Util.getResourceBundle().getString("modal.selection_color.title");
                String text = Util.getResourceBundle().getString("modal.selection_color.text");
                String[] colors = {"YELLOW", "GREEN", "GRAY"};
                String selection = (String) JOptionPane.showInputDialog(null, text, title, JOptionPane.WARNING_MESSAGE, null, colors, colors[0]);
                switch (selection) {
                    case "YELLOW":
                        samotnik.setPointColor(Color.YELLOW);
                        break;
                    case "GREEN":
                        samotnik.setPointColor(Color.GREEN);
                        break;
                    case "GRAY":
                        samotnik.setPointColor(Color.GRAY);
                        break;
                }
                break;
            }
            case "RED":
                samotnik.setSelectionColor(Color.RED);
                break;
            case "BLUE":
                samotnik.setSelectionColor(Color.BLUE);
                break;
            case "BRITISH":
                samotnik.setVersion(GameVersion.BRITISH);
                break;
            case "EUROPEAN":
                samotnik.setVersion(GameVersion.EUROPEAN);
                break;
        }
        samotnik.update();
    }
}

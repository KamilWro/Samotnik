package listeners;

import models.Samotnik;
import util.GameVersion;

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
            case "ABOUT_GAME":
                String s = "Najprawdopodobniej samotnik, to gra wymyślona w XII wieku we Francji przez więźnia \n"
                        + "przebywającego w Bastylii, który uprzyjemniał sobie czas spędzony w odosobnieniu. \n"
                        + "Samotnik, jest prostą grą logiczną dla jednej osoby.Pole do gry ma kształt krzyża z \n"
                        + "jednym pustym polem w środku oraz 32 polami zapełnionymi. W grze jedynym dozwolonym \n"
                        + "ruchem jest przeskoczenie pionka innym pionkiem w pionie lub w poziomie, co powoduje zbicie \n"
                        + "przeskoczonego pionka. Celem gry jest pozostawienie na planszy jednego pionka, \n"
                        + "najlepiej jeśli będzie to pionek w centrum.";
                JOptionPane.showMessageDialog(null, s, "O Grze", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ABOUT_AUTHOR":
                Formatter formatter = new Formatter();
                formatter.format("%-25s %s %n%-23s %s %n%-17s %s", "Autor:", "Kamil Breczko", "Wersja:", "1.1", "Data wydania:", "09 12 2016");

                JOptionPane.showMessageDialog(null, formatter.toString(), "O Aplikacji", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "BACKGROUND_COLOR":
                color = samotnik.getBackgroundColor();
                color = JColorChooser.showDialog(null, "Wybierz kolor tla planszy", color);
                samotnik.setBackgroundColor(color);
                break;
            case "COUNTER_COLOR":
                color = JColorChooser.showDialog(null, "Wybierz kolor Pionka", samotnik.getCounterColor());
                samotnik.setCounterColor(color);
                break;
            case "POINT_COLOR": {
                String[] colors = {"YELLOW", "GREEN", "GRAY"};
                String selection;
                selection = (String) JOptionPane.showInputDialog(null, "Wybierz kolor zaznaczenia pionka:", "Wybor koloru:", JOptionPane.WARNING_MESSAGE, null, colors, colors[0]);
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

package views;

import listeners.MouseListener;
import models.Board;
import models.Samotnik;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa prezentująca interfejs graficzny gry Samotnik
 *
 * @author kamil
 */
public class Window extends JFrame {
    private final MenuBar menu;
    private final Panel panel;
    private final JLabel label;
    private final Board board;

    public Window(Board board) {
        super("Samotnik");
        this.board = board;
        panel = new Panel(board);
        menu = new MenuBar(board);
        label = new JLabel("STAN GRY");
        add();
        settings();
    }

    private void settings() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(80, 80);
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
        getContentPane().setBackground(Samotnik.getInstance().getBackgroundColor());
    }

    private void add() {
        setLayout(new BorderLayout());
        setJMenuBar(menu);
        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        addMouseListener(new MouseListener(this, board));
    }

    /**
     * Aktualizuje podgląd gry
     */
    public void update() {
        if (Samotnik.getInstance().isEnd()) {
            label.setText("Gra skonczona, pozostalo: " + board.getNumberOfCounters() + " pionkow");
            menu.update(true);
            panel.repaint();
        } else {
            label.setText("Gra trwa, pozostalo: " + board.getNumberOfCounters() + " pionkow");
            getContentPane().setBackground(Samotnik.getInstance().getBackgroundColor());
            panel.repaint();
            menu.update(false);
        }
    }


}
            


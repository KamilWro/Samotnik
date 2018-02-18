package views;

import listeners.MouseListener;
import models.Board;
import models.Samotnik;
import util.Util;

import javax.swing.*;
import java.awt.*;

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
        label = new JLabel(Util.getResourceBundle().getString("game.state"));
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

    public void update() {
        if (Samotnik.getInstance().isEnd()) {
            label.setText(Util.getResourceBundle().getString("game.state.over") + board.getNumberOfCounters());
            menu.update(true);
            panel.repaint();
        } else {
            label.setText(Util.getResourceBundle().getString("game.state.continues") + board.getNumberOfCounters());
            getContentPane().setBackground(Samotnik.getInstance().getBackgroundColor());
            panel.repaint();
            menu.update(false);
        }
    }


}
            


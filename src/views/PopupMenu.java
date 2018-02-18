package views;

import listeners.KeyListener;
import models.Board;
import util.Util;

import javax.swing.*;

public class PopupMenu extends JPopupMenu {

    private final JMenuItem mRight, mLeft, mUp, mDown;

    {
        mRight = new JMenuItem(Util.getResourceBundle().getString("movement.right"));
        mDown = new JMenuItem(Util.getResourceBundle().getString("movement.down"));
        mUp = new JMenuItem(Util.getResourceBundle().getString("movement.up"));
        mLeft = new JMenuItem(Util.getResourceBundle().getString("movement.left"));
    }

    public PopupMenu(Board board) {
        add();
        setCommand();
        addListeners(board);
    }

    private void add() {
        add(mRight);
        add(mDown);
        add(mUp);
        add(mLeft);
    }

    private void setCommand() {
        mRight.setActionCommand("RIGHT");
        mDown.setActionCommand("DOWN");
        mLeft.setActionCommand("LEFT");
        mUp.setActionCommand("UP");
    }

    private void addListeners(Board board) {
        mRight.addActionListener(new KeyListener(board));
        mDown.addActionListener(new KeyListener(board));
        mLeft.addActionListener(new KeyListener(board));
        mUp.addActionListener(new KeyListener(board));
    }
}
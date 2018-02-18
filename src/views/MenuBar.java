package views;

import listeners.KeyListener;
import listeners.MenuBarListener;
import models.Board;
import util.Util;

import javax.swing.*;


public class MenuBar extends JMenuBar {
    private final JMenu gameMenu, moveMenu, settingsMenu, helpMenu, colorSelectionMenu;
    private final JMenuItem mNewGame, mEnd, mSelect, mLeft, mRight, mUp, mDown, mIGame, mIApplication, mBackgroundColor, mCounterColor, mPointColor, mRed, mBlue;
    private final JRadioButtonMenuItem rBritish, rEuropean;
    private final ButtonGroup bgVersion;

    {
        gameMenu = new JMenu(Util.getResourceBundle().getString("menu.game"));
        mNewGame = new JMenuItem(Util.getResourceBundle().getString("menu.game.new"), 'N');
        mEnd = new JMenuItem(Util.getResourceBundle().getString("menu.game.end"), 'K');

        moveMenu = new JMenu(Util.getResourceBundle().getString("menu.movement"));
        mSelect = new JMenuItem(Util.getResourceBundle().getString("movement.select"));
        mLeft = new JMenuItem(Util.getResourceBundle().getString("movement.left"));
        mRight = new JMenuItem(Util.getResourceBundle().getString("movement.right"));
        mUp = new JMenuItem(Util.getResourceBundle().getString("movement.up"));
        mDown = new JMenuItem(Util.getResourceBundle().getString("movement.down"));

        settingsMenu = new JMenu(Util.getResourceBundle().getString("menu.settings"));

        rBritish = new JRadioButtonMenuItem(Util.getResourceBundle().getString("menu.settings.version.british"));
        rEuropean = new JRadioButtonMenuItem(Util.getResourceBundle().getString("menu.settings.version.european"));
        bgVersion = new ButtonGroup();

        mBackgroundColor = new JMenuItem(Util.getResourceBundle().getString("menu.settings.color.background"));
        mCounterColor = new JMenuItem(Util.getResourceBundle().getString("menu.settings.color.counter"));
        mPointColor = new JMenuItem(Util.getResourceBundle().getString("menu.settings.color.point"));
        colorSelectionMenu = new JMenu(Util.getResourceBundle().getString("menu.settings.color.selection"));

        mRed = new JMenuItem(Util.getResourceBundle().getString("menu.settings.colors.red"));
        mBlue = new JMenuItem(Util.getResourceBundle().getString("menu.settings.colors.blue"));

        helpMenu = new JMenu(Util.getResourceBundle().getString("menu.help"));
        mIGame = new JMenuItem(Util.getResourceBundle().getString("menu.help.game"));
        mIApplication = new JMenuItem(Util.getResourceBundle().getString("menu.help.application"));
    }


    public MenuBar(Board board) {
        add();
        setAccelerator();
        setCommand();
        addListener(board);
        update(true);
    }

    private void add() {
        add(gameMenu);
        gameMenu.add(mNewGame);
        gameMenu.addSeparator();
        gameMenu.add(mEnd);

        add(moveMenu);
        moveMenu.add(mSelect);
        moveMenu.addSeparator();
        moveMenu.add(mLeft);
        moveMenu.add(mRight);
        moveMenu.add(mUp);
        moveMenu.add(mDown);

        add(settingsMenu);
        bgVersion.add(rBritish);
        bgVersion.add(rEuropean);
        settingsMenu.add(rBritish);
        settingsMenu.add(rEuropean);
        settingsMenu.add(mBackgroundColor);
        settingsMenu.add(mCounterColor);
        settingsMenu.add(mPointColor);

        colorSelectionMenu.add(mRed);
        colorSelectionMenu.add(mBlue);
        settingsMenu.add(colorSelectionMenu);

        add(Box.createGlue());

        add(helpMenu);
        helpMenu.add(mIGame);
        helpMenu.add(mIApplication);
    }

    private void setAccelerator() {
        mSelect.setAccelerator(KeyStroke.getKeyStroke("SPACE"));
        mLeft.setAccelerator(KeyStroke.getKeyStroke("LEFT"));
        mRight.setAccelerator(KeyStroke.getKeyStroke("RIGHT"));
        mUp.setAccelerator(KeyStroke.getKeyStroke("UP"));
        mDown.setAccelerator(KeyStroke.getKeyStroke("DOWN"));
    }

    private void setCommand() {
        mNewGame.setActionCommand("NEW_GAME");
        mEnd.setActionCommand("GAME_OVER");
        mSelect.setActionCommand("SELECT");
        mLeft.setActionCommand("LEFT");
        mRight.setActionCommand("RIGHT");
        mUp.setActionCommand("UP");
        mDown.setActionCommand("DOWN");
        mIApplication.setActionCommand("ABOUT_APPLICATION");
        mIGame.setActionCommand("ABOUT_GAME");
        mBackgroundColor.setActionCommand("BACKGROUND_COLOR");
        mCounterColor.setActionCommand("COUNTER_COLOR");
        mPointColor.setActionCommand("POINT_COLOR");
        rBritish.setActionCommand("BRITISH");
        rEuropean.setActionCommand("EUROPEAN");
        mRed.setActionCommand("RED");
        mBlue.setActionCommand("BLUE");
    }

    private void addListener(Board board) {
        mNewGame.addActionListener(new MenuBarListener());
        mEnd.addActionListener(new MenuBarListener());
        mSelect.addActionListener(new KeyListener(board));
        mLeft.addActionListener(new KeyListener(board));
        mRight.addActionListener(new KeyListener(board));
        mUp.addActionListener(new KeyListener(board));
        mDown.addActionListener(new KeyListener(board));
        mIApplication.addActionListener(new MenuBarListener());
        mIGame.addActionListener(new MenuBarListener());
        mBackgroundColor.addActionListener(new MenuBarListener());
        mCounterColor.addActionListener(new MenuBarListener());
        mPointColor.addActionListener(new MenuBarListener());
        rBritish.addActionListener(new MenuBarListener());
        rEuropean.addActionListener(new MenuBarListener());
        mRed.addActionListener(new MenuBarListener());
        mBlue.addActionListener(new MenuBarListener());
    }

    public void update(boolean enable) {
        rEuropean.setEnabled(enable);
        rBritish.setEnabled(enable);
        mNewGame.setEnabled(enable);
    }

}


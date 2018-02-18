package views;

import listeners.KeyListener;
import listeners.MenuBarListener;
import models.Board;

import javax.swing.*;


public class MenuBar extends JMenuBar {
    private final JMenu gameMenu, moveMenu, settingsMenu, helpMenu, colorSelectMenu;
    private final JMenuItem mNewGame, mEnd, mSelect, mLeft, mRight, mUp, mDown, mIGame, mIAuthor, mBackgroundColor, mCounterColor, mPointColor, mRed, mBlue;
    private final JRadioButtonMenuItem rBritish, rEuropean;
    private final ButtonGroup bgVersion;

    {
        gameMenu = new JMenu("Gra");
        mNewGame = new JMenuItem("Nowa Gra", 'N');
        mEnd = new JMenuItem("Koniec Gry", 'K');

        moveMenu = new JMenu("Ruchy");
        mSelect = new JMenuItem("Zaznacz");
        mLeft = new JMenuItem("Ruch w lewo");
        mRight = new JMenuItem("Ruch w prawo");
        mUp = new JMenuItem("Ruch w gore");
        mDown = new JMenuItem("Ruch w dol");

        settingsMenu = new JMenu("Ustawienia");

        rBritish = new JRadioButtonMenuItem("Wersja Brytyjska");
        rEuropean = new JRadioButtonMenuItem("Wersja Europejska");
        bgVersion = new ButtonGroup();

        mBackgroundColor = new JMenuItem("Zmien kolor tla");
        mCounterColor = new JMenuItem("Zmien kolor pionkow");
        mPointColor = new JMenuItem("Zmien kolor wskaznika");
        colorSelectMenu = new JMenu("Zmien kolor wybranego pionka");

        mRed = new JMenuItem("Czerowny");
        mBlue = new JMenuItem("Niebieski");

        helpMenu = new JMenu("Pomoc");
        mIGame = new JMenuItem("O Grze");
        mIAuthor = new JMenuItem("O Aplikacji");
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

        colorSelectMenu.add(mRed);
        colorSelectMenu.add(mBlue);
        settingsMenu.add(colorSelectMenu);

        add(Box.createGlue());

        add(helpMenu);
        helpMenu.add(mIGame);
        helpMenu.add(mIAuthor);
    }

    private void setAccelerator() {
        mSelect.setAccelerator(KeyStroke.getKeyStroke("SPACE"));
        mLeft.setAccelerator(KeyStroke.getKeyStroke("LEFT"));
        mRight.setAccelerator(KeyStroke.getKeyStroke("RIGHT"));
        mUp.setAccelerator(KeyStroke.getKeyStroke("UP"));
        mDown.setAccelerator(KeyStroke.getKeyStroke("DOWN"));
    }

    private void setCommand() {
        mNewGame.setActionCommand("NowaGra");
        mEnd.setActionCommand("KoniecGry");
        mSelect.setActionCommand("Zaznacz");
        mLeft.setActionCommand("Lewo");
        mRight.setActionCommand("Prawo");
        mUp.setActionCommand("Gora");
        mDown.setActionCommand("Dol");
        mIAuthor.setActionCommand("OApk");
        mIGame.setActionCommand("OGrze");
        mBackgroundColor.setActionCommand("KolorTlo");
        mCounterColor.setActionCommand("KolorPi");
        mPointColor.setActionCommand("KolorWyp");
        rBritish.setActionCommand("Bryt");
        rEuropean.setActionCommand("Euro");
        mRed.setActionCommand("Czerwony");
        mBlue.setActionCommand("Niebieski");
    }

    private void addListener(Board board) {
        mNewGame.addActionListener(new MenuBarListener());
        mEnd.addActionListener(new MenuBarListener());
        mSelect.addActionListener(new KeyListener(board));
        mLeft.addActionListener(new KeyListener(board));
        mRight.addActionListener(new KeyListener(board));
        mUp.addActionListener(new KeyListener(board));
        mDown.addActionListener(new KeyListener(board));
        mIAuthor.addActionListener(new MenuBarListener());
        mIGame.addActionListener(new MenuBarListener());
        mBackgroundColor.addActionListener(new MenuBarListener());
        mCounterColor.addActionListener(new MenuBarListener());
        mPointColor.addActionListener(new MenuBarListener());
        rBritish.addActionListener(new MenuBarListener());
        rEuropean.addActionListener(new MenuBarListener());
        mRed.addActionListener(new MenuBarListener());
        mBlue.addActionListener(new MenuBarListener());
    }

    /**
     * Aktualizacja Menu
     *
     * @param enable
     */
    public void update(boolean enable) {
        rEuropean.setEnabled(enable);
        rBritish.setEnabled(enable);
        mNewGame.setEnabled(enable);
    }

}


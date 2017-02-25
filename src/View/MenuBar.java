package View;


import Controller.KeyListener;
import Controller.MenuBarListener;
import Model.Board;
import javax.swing.*;
/**
 * Klasa reprezentująca Menu główne Okienka gry
 * @author kamil
 */
public class MenuBar extends JMenuBar{
    private final JMenu menuGame, menuMove, menuSettings, menuHelp, menuColorSelect;
    private final JMenuItem mNewGame, mEnd, mSelect, mLeft, mRight, mUp, mDown, mIGame, mIAuthor, mColorBack, mColorCounter, mColorPoint, mRed, mBlue ;
    private final JRadioButtonMenuItem  rBritish, rEuropean;
    private final ButtonGroup bgVersion;
    {
        menuGame = new JMenu("Gra");
        mNewGame = new JMenuItem("Nowa Gra", 'N');
        mEnd = new JMenuItem("Koniec Gry", 'K');

        menuMove = new JMenu("Ruchy");
        mSelect = new JMenuItem("Zaznacz");
        mLeft = new JMenuItem("Ruch w lewo");
        mRight = new JMenuItem("Ruch w prawo");
        mUp = new JMenuItem("Ruch w gore");
        mDown = new JMenuItem("Ruch w dol");

        menuSettings = new JMenu("Ustawienia");

        rBritish = new JRadioButtonMenuItem("Wersja Brytyjska");
        rEuropean = new JRadioButtonMenuItem("Wersja Europejska");
        bgVersion = new ButtonGroup();

        mColorBack = new JMenuItem("Zmien kolor tla");
        mColorCounter = new JMenuItem("Zmien kolor pionkow");
        mColorPoint = new JMenuItem("Zmien kolor wskaznika");
        menuColorSelect= new JMenu("Zmien kolor wybranego pionka");
        
        mRed = new JMenuItem("Czerowny");
        mBlue = new JMenuItem("Niebieski");
        
        menuHelp = new JMenu("Pomoc");
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

        add(menuGame);
        menuGame.add(mNewGame);
        menuGame.addSeparator();
        menuGame.add(mEnd);

        add(menuMove);
        menuMove.add(mSelect);
        menuMove.addSeparator();
        menuMove.add(mLeft);
        menuMove.add(mRight);
        menuMove.add(mUp);
        menuMove.add(mDown);

        add(menuSettings);
        bgVersion.add(rBritish);
        bgVersion.add(rEuropean);
        menuSettings.add(rBritish);
        menuSettings.add(rEuropean);
        menuSettings.add(mColorBack);
        menuSettings.add(mColorCounter);
        menuSettings.add(mColorPoint);
        
        menuColorSelect.add(mRed);
        menuColorSelect.add(mBlue);
        menuSettings.add(menuColorSelect);
        
        add(Box.createGlue());

        add(menuHelp);
        menuHelp.add(mIGame);
        menuHelp.add(mIAuthor);

    }

    private void setAccelerator() {

        mSelect.setAccelerator(KeyStroke.getKeyStroke("SPACE"));
        mLeft.setAccelerator(KeyStroke.getKeyStroke("LEFT"));
        mRight.setAccelerator(KeyStroke.getKeyStroke("RIGHT"));
        mUp.setAccelerator(KeyStroke.getKeyStroke("UP"));
        mDown.setAccelerator(KeyStroke.getKeyStroke("DOWN"));

    }
    
    private void setCommand(){
        mNewGame.setActionCommand("NowaGra");
        mEnd.setActionCommand("KoniecGry");
        mSelect.setActionCommand("Zaznacz");
        mLeft.setActionCommand("Lewo");
        mRight.setActionCommand("Prawo");
        mUp.setActionCommand("Gora");
        mDown.setActionCommand("Dol");
        mIAuthor.setActionCommand("OApk");
        mIGame.setActionCommand("OGrze");
        mColorBack.setActionCommand("KolorTlo");
        mColorCounter.setActionCommand("KolorPi");
        mColorPoint.setActionCommand("KolorWyp");
        rBritish.setActionCommand("Bryt");
        rEuropean.setActionCommand("Euro");
        mRed.setActionCommand("Czerwony");
        mBlue.setActionCommand("Niebieski");
    }
    
    private void addListener(Board board){
        mNewGame.addActionListener(new MenuBarListener());
        mEnd.addActionListener(new MenuBarListener());
        mSelect.addActionListener(new KeyListener(board));
        mLeft.addActionListener(new KeyListener(board));
        mRight.addActionListener(new KeyListener(board));
        mUp.addActionListener(new KeyListener(board));
        mDown.addActionListener(new KeyListener(board));
        mIAuthor.addActionListener(new MenuBarListener());
        mIGame.addActionListener(new MenuBarListener());
        mColorBack.addActionListener(new MenuBarListener());
        mColorCounter.addActionListener(new MenuBarListener());
        mColorPoint.addActionListener(new MenuBarListener());
        rBritish.addActionListener(new MenuBarListener());
        rEuropean.addActionListener(new MenuBarListener());
        mRed.addActionListener(new MenuBarListener());
        mBlue.addActionListener(new MenuBarListener());
    }
    /**
     * Aktualizacja Menu
     * @param enable 
     */
    public void update(boolean enable) {
        rEuropean.setEnabled(enable);
        rBritish.setEnabled(enable);
        mNewGame.setEnabled(enable);
    }
   
}


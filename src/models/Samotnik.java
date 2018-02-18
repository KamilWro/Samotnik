package models;


import views.Window;

import java.awt.*;

/**
 * Klasa opakowująca narzedzia do poprawnej rozgrywki
 *
 * @author kamil
 */
public class Samotnik {

    private static Samotnik INSTANCE;
    private Color counterColor, backgroundColor, pointColor, selectionColor;
    private Window window;
    private Board board;
    private boolean versionE;

    private Samotnik() {
        counterColor = Color.DARK_GRAY;
        backgroundColor = Color.ORANGE;
        pointColor = Color.LIGHT_GRAY;
        selectionColor = Color.RED;
    }

    public static Samotnik getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Samotnik();
        }
        return INSTANCE;
    }

    public void init() {
        board = new Board(versionE);
        window = new Window(board);
    }

    public void newGame() {
        board.reset(versionE);
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color newColor) {
        backgroundColor = newColor;
    }

    public Color getKolorPoint() {
        return pointColor;
    }

    public void setPointColor(Color kolorWypelnienia) {
        this.pointColor = kolorWypelnienia;
    }

    public Color getCounterColor() {
        return counterColor;
    }

    public void setCounterColor(Color newColor) {
        this.counterColor = newColor;
    }

    public Color getSelectionColor() {
        return selectionColor;
    }

    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
    }

    /**
     * Czy gra się zakończyła?
     *
     * @return Koniec gry
     */
    public boolean isEnd() {
        return !board.isPossibleMove();
    }

    /**
     * Określa wersje gry
     *
     * @return
     */
    public boolean isVersionE() {
        return versionE;
    }

    public void setVersionE(boolean versionE) {
        this.versionE = versionE;
    }

    public void update() {
        window.update();
    }

    public void close() {
        window.dispose();
    }

}

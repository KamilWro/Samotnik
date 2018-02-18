package models;


import util.GameVersion;
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
    private GameVersion version;

    private Samotnik() {
        counterColor = Color.DARK_GRAY;
        backgroundColor = Color.ORANGE;
        pointColor = Color.LIGHT_GRAY;
        selectionColor = Color.RED;
        version = GameVersion.British;
    }

    public static Samotnik getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Samotnik();
        }
        return INSTANCE;
    }

    public void init() {
        board = new Board(version);
        window = new Window(board);
    }

    public void newGame() {
        board.reset(version);
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

    public boolean isEnd() {
        return !board.isPossibleMove();
    }

    public GameVersion getVersion() {
        return version;
    }

    public void setVersion(GameVersion version) {
        this.version = version;
    }

    public void update() {
        window.update();
    }

    public void close() {
        window.dispose();
    }

}

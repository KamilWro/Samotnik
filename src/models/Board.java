package models;

import util.GameVersion;
import util.Turn;

public class Board {
    private GameVersion version;
    private boolean[][] available;
    private boolean[][] filled;
    private int numberOfCounters;
    private Turn turn;
    private int selectedX;
    private int selectedY;

    public Board(GameVersion version) {
        reset(version);
    }

    public void reset(GameVersion version) {
        this.version = version;
        filled = version.getBoard();
        available = version.getBoard();
        numberOfCounters = version.getNumberOfCounter();

        filled[version.getStartX()][version.getStartY()] = false;
        turn = Turn.MOVEMENT;
        selectedX = version.getStartX();
        selectedY = version.getStartY();
    }

    /**
     * Metoda wykonująca się przy próbie wybrania pionka
     */
    public void select() {
        if (turn == Turn.SELECTION) {
            turn = Turn.MOVEMENT;
        } else if (isFilled(selectedX, selectedY)) {
            turn = Turn.SELECTION;
        } else {
            turn = Turn.MOVEMENT;
        }
    }

    /**
     * Metoda służąca do poruszania się po planszy oraz przesuwania pionków
     *
     * @param x        współrzedna X aktualnego pionka
     * @param y        współrzedna Y aktualnego pionka
     * @param keyboard Czy metoda została wywołana poprzez klawisze klawiatury
     */
    public void move(int x, int y, boolean keyboard) {
        switch (turn) {
            case MOVEMENT:
                if (isAvailable(x, y)) {
                    selectedY = y;
                    selectedX = x;
                }
                break;
            case SELECTION:
                if (keyboard) {
                    x = x + (x - selectedX);
                    y = y + (y - selectedY);
                }
                if ((Math.abs(x - selectedX) == 2 && y == selectedY || Math.abs(y - selectedY) == 2 && x == selectedX) && isFree(x, y) && isFilled((x + selectedX) / 2, (y + selectedY) / 2) && isFilled(selectedX, selectedY)) {
                    filled[(selectedX + x) / 2][(selectedY + y) / 2] = false;
                    filled[x][y] = true;
                    filled[selectedX][selectedY] = false;
                    numberOfCounters--;
                    selectedY = y;
                    selectedX = x;
                }
                turn = Turn.MOVEMENT;
                break;
        }
    }

    public void moveMouse(int y, int x) {
        switch (turn) {
            case MOVEMENT:
                move(x, y, false);
                select();
                break;
            case SELECTION:
                move(x, y, false);
                break;
        }
    }

    public boolean isPossibleMove() {
        for (int i = 0; i < version.getMaxRow(); i++)
            for (int j = 0; j < version.getStartY(); j++) {
                if (isPossibleMoveDown(i, j) || isPossibleMoveUp(i, j) || isPossibleMoveRight(i, j) || isPossibleMoveLeft(i, j))
                    return true;
            }
        return false;
    }

    private boolean isPossibleMoveLeft(int x, int y) {
        return isFree(x, y) && isFilled(x, y + 1) && isFilled(x, y + 2);
    }

    private boolean isPossibleMoveRight(int x, int y) {
        return isFilled(x, y) && isFilled(x, y + 1) && isFree(x, y + 2);
    }

    private boolean isPossibleMoveUp(int x, int y) {
        return isFree(x, y) && isFilled(x + 1, y) && isFilled(x + 2, y);
    }

    private boolean isPossibleMoveDown(int x, int y) {
        return isFilled(x, y) && isFilled(x + 1, y) && isFree(x + 2, y);
    }

    public int getNumberOfCounters() {
        return numberOfCounters;
    }

    public boolean isAvailable(int x, int y) {
        return 0 <= x && x < version.getMaxRow() && 0 <= y && y < version.getMaxColumn() && available[x][y];
    }

    public boolean isFilled(int x, int y) {
        return isAvailable(x, y) && filled[x][y];
    }

    private boolean isFree(int x, int y) {
        return isAvailable(x, y) && !filled[x][y];
    }

    public int getSelectedY() {
        return selectedY;
    }

    public int getSelectedX() {
        return selectedX;
    }

    public boolean isSelected() {
        return turn == Turn.SELECTION;
    }
}

package listeners;

import models.Board;
import models.Samotnik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyListener implements ActionListener {
    private final Board board;
    private int x, y;

    public KeyListener(Board board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source) {
            case "Zaznacz": {
                board.select();
                break;
            }
            case "Lewo": {
                nextCounter("W");
                board.move(x, y, true);
                break;
            }
            case "Prawo": {
                nextCounter("E");
                board.move(x, y, true);
                break;
            }
            case "Gora": {
                nextCounter("N");
                board.move(x, y, true);
                break;
            }
            case "Dol": {
                nextCounter("S");
                board.move(x, y, true);
                break;
            }
        }
        Samotnik.getInstance().update();
    }
    
    private void nextCounter(String direction) {
        x = board.getSelectedX();
        y = board.getSelectedY();
        switch (direction) {
            case "N": {
                for (int i = y; i >= 0; i--) {
                    for (int j = (y == i) ? x - 1 : 6; j >= 0; j--) {
                        if (board.isFilled(j, i)) {
                            x = j;
                            y = i;
                            return;
                        }
                    }
                }
                break;
            }
            case "S": {
                for (int i = y; i < 7; i++) {
                    for (int j = (y == i) ? x + 1 : 0; j < 7; j++) {
                        if (board.isFilled(j, i)) {
                            x = j;
                            y = i;
                            return;
                        }
                    }
                }
                break;
            }
            case "W": {
                for (int i = x; i >= 0; i--) {
                    for (int j = (x == i) ? y - 1 : 6; j >= 0; j--) {
                        if (board.isFilled(i, j)) {
                            x = i;
                            y = j;
                            return;
                        }
                    }
                }
                break;
            }
            case "E": {
                for (int i = x; i < 7; i++) {
                    for (int j = (x == i) ? y + 1 : 0; j < 7; j++) {
                        if (board.isFilled(i, j)) {
                            x = i;
                            y = j;
                            return;
                        }
                    }
                }
                break;
            }
        }

    }


}

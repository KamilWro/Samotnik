package listeners;

import models.Board;
import models.Samotnik;
import views.PopupMenu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Nasłuchująca myszke, wywołana po kliknięciu na plansze
 *
 * @author kamil
 */
public class MouseListener extends MouseAdapter {

    private final Samotnik samotnik;
    private final Window window;
    private final Board board;
    private PopupMenu menu;

    public MouseListener(Window window, Board board) {
        this.window = window;
        this.samotnik = Samotnik.getInstance();
        this.board = board;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point position = toArray(e.getPoint());
            board.moveMouse(position.x, position.y);
            samotnik.update();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            menu = new PopupMenu(board);
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }


    private Point toArray(Point last) {
        int x = window.getWidth() / 9;
        int y = window.getHeight() / 9;
        return new Point((last.x / x) - 1, (last.y / y) - 1);
    }

}

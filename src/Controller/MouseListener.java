package Controller;

import Model.Board;
import Model.Samotnik;
import View.PopupMenu;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Nasłuchująca myszke, wywołana po kliknięciu na plansze 
 * @author kamil
 */
public class MouseListener extends MouseAdapter {
        
        private final Samotnik samotnik;
        private PopupMenu menu;
        private final Window window;
        private final Board board;
        
        public MouseListener(Window window, Board board){
                this.window=window;
                this.samotnik=Samotnik.getInstance();
                this.board=board;
        }

        
        @Override
        public void mouseClicked(MouseEvent e) { 
            if (e.getButton() == MouseEvent.BUTTON1) {
                Point pozycja = toArray(e.getPoint());
                board.moveMouse(pozycja.x, pozycja.y);
                samotnik.update();
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                menu=new PopupMenu(board);
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    
        
    private Point toArray(Point last) {
        int X = window.getWidth()/9;
        int Y = window.getHeight()/9;
        return new Point((last.x / X)-1, (last.y / Y)-1);
    }
    
}

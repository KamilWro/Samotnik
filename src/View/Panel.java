package View;

import Model.Board;
import Model.Samotnik;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 * Klasa prezentująca stan gry (rozmieszczenie pionków na planszy)
 * @author kamil
 */
public class Panel extends JPanel {
    private final Samotnik samotnik=Samotnik.getInstance();
    private final Board board;
    public Panel(Board board) {
        this.board=board;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int Width = getWidth()/9;
        int Height = getHeight()/9;
        int y = board.getPointY();
        int x = board.getPointX();
        
        Color color;
        color=samotnik.getColorCounter();
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                Ellipse2D ellipse = new Ellipse2D.Double((j+1)*Width, (i+1)*Height ,Width, Height);
                if(board.getCounter(i, j)){
                        if(x==i && y==j) {
                            g2d.setPaint(samotnik.getKolorPoint());
                            if(board.isSelected())
                                g2d.setPaint(samotnik.getColorSelect());
                            g2d.fill(ellipse);
                            
                        }else{
                            g2d.setPaint(color);
                            g2d.fill(ellipse);
                        }
                }
                if(board.avaiable(i, j)){
                        g2d.setPaint(Color.BLACK);
                        g2d.draw(ellipse);
                }
            }
            this.setBackground(samotnik.getColorBack());
    }
}

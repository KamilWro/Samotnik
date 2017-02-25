package Controller;

import Model.Board;
import Model.Samotnik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Obsługuje wciśnięte klawisze podczas gry
 * @author kamil
 */
public class KeyListener implements ActionListener{
    private final Board board;    
    private int x,y;
    
    public KeyListener(Board board){
        this.board=board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source=e.getActionCommand();
        switch (source){
                    case "Zaznacz":{
                        board.select();
                        break;
                    }
                    case "Lewo":{
                        next("W");
                        board.Move(x,y,true);
                        break;
                    }
                    case "Prawo":{
                        next("E");
                        board.Move(x,y,true);
                        break;
                    }
                    case "Gora":{
                        next("N");
                        board.Move(x,y,true);
                        break;
                    }
                    case "Dol":{
                        next("S");
                        board.Move(x,y,true);
                        break;
                    }
        }
        Samotnik.getInstance().update();
    }
     /**
     * Wybiera następny pionek po wybraniu kierunku
     * @param direction 
     */
    private void next(String direction){
                        x=board.getPointX();
                        y=board.getPointY();
                        switch (direction){
                            case "N":{    
                                int x_=x-1;
                                int i,j=6;
                                for (i=y;i>=0;i--){
                                    if (y==i) 
                                            j=x_; 
                                    else
                                        j=6;
                                    for (;j>=0;j--){
                                        if(board.full(j, i)){
                                            x=j;
                                            y=i;
                                            return;
                                        }
                                    }
                                }
                                break;
                            }
                            case "S":{
                                int x_=x+1;
                                int i,j=0;
                                for (i=y;i<7;i++){
                                    if (y==i) 
                                        j=x_;
                                    else
                                        j=0;
                                    for (;j<7;j++){ 
                                        if(board.full(j, i)){
                                            x=j;
                                            y=i;
                                            return;
                                        }
                                    }
                                }
                                break;
                            }
                            case "W":{
                                int y_=y-1;
                                int i,j=6;
                                for (i=x;i>=0;i--){
                                    if (x==i) 
                                        j=y_;
                                    else
                                        j=6;
                                    for (;j>=0;j--){
                                        if(board.full(i, j)){
                                            x=i;
                                            y=j;
                                            return;
                                        }
                                    }
                                }
                                break;
                            }
                            case "E":{
                                int y_=y+1;
                                int i,j=0;
                                for (i=x;i<7;i++){
                                    if (x==i) 
                                            j=y_;
                                    else
                                        j=0;
                                    for (;j<7;j++){ 
                                        if(board.full(i, j)){
                                            x=i;
                                            y=j;
                                            return;
                                        }
                                    }                             
                                }
                                break;
                            }
                        }

    }


}

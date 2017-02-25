package Model;

/**
 * Tablica z pionkami
 * @author kamil
 */
public class Board {
    
    private final boolean[][] avaiable;
    private final boolean[][] counter;
    private int rest, turn;
    private boolean selected;
    private int pointY, pointX;
    
    public Board(boolean versionE){
        avaiable = new boolean[7][7];
        counter= new boolean[7][7];
        for (int i = 2; i < 5; i++)
            for (int j = 0; j < 7; j++) {
                avaiable[i][j] = true;
                avaiable[j][i] = true;
                counter[i][j]=true;
                counter[j][i]=true;
            }
        rest = 32;
        if (versionE) {
            for (int i = 1; i < 6; i++)
                for (int j = 1; j < 6; j++) {
                    avaiable[i][j] = true;
                    counter[i][j]=true;
                }
            rest+=4;
        }
        counter[3][3]=false;
        selected=false;
        turn=1;
        pointX=3;
        pointY=3;
    }
    
    
     /**
     * Metoda wykonująca się przy próbie wybrania pionka
     */
    public void select() {
                if(turn==2){
                        turn=1;
                        selected=false;
                }
                else if (full(pointX, pointY)) {
                    turn = 2;
                    selected=true;
                }
                else {
                    turn = 1;
                    selected=false;
                }
    }
    /**
     * Metoda służąca do poruszania się po planszy oraz przesuwania pionków
     * @param x_ współrzedna X aktualnego pionka
     * @param y_ współrzedna Y aktualnego pionka
     * @param keyboard Czy metoda została wywołana poprzez klawisze klawiatury
     */
    public void Move(int x_, int y_, boolean keyboard) {
        switch (turn) {
            case 1:
                if (avaiable(x_,y_)) {
                    pointY=y_;
                    pointX=x_;    
                }
                break;
            case 2:
                if (keyboard) {
                    x_ = x_+(x_-pointX);
                    y_ = y_+(y_-pointY);
                }
                if (free(x_, y_) && full((x_+pointX)/2, (y_+pointY)/2)&& full(pointX, pointY)&& (Math.abs(x_-pointX)==2 && y_==pointY || Math.abs(y_-pointY)==2 && x_==pointX)) {
                    setCounter((pointX+x_)/2,(pointY+y_)/2, false);
                    setCounter(x_,y_,true);
                    setCounter(pointX,pointY,false);
                    downRest();
                    pointY=y_;
                    pointX=x_;
                }
                turn = 1;
                selected=false;
                break;
        }
    }

    /**
     * Metoda pomocnicza służąca do poruszania się po planszy za pomocą myszki
     * @param y Wspolrzedne Y wybranego pionka
     * @param x Wspolrzedne X wybranwgo pionka
     */
    public void moveMouse(int y, int x) {
        switch (turn) {
            case 1:
                Move(x,y,false);
                select();
                break;
            case 2:
                Move(x,y,false);
                break;
        }
    }
    
    
    /**
     * Zwraca reszte pionków
     * @return pozostałe pionki
     */
    public int getRest() {
        return rest;
    }
    /**
     * Zmniejsza ilosć pionków na planszy
     */
    public void downRest(){
        rest--;
    }
    
    /**
     * Sprawdza czy jest możliwość postawienia w podanym miejscu pionka
     * @param x Wspolrzedna X
     * @param y Wspolrzedna Y
     * @return Wyjscie poza plansze
     */
    public boolean avaiable(int x, int y) {
        return 0<=x&&x<=6&&0<=y&&y<=6 && avaiable[x][y];
    }

    /**
     * Czy na podanym miejscu stoi pionek
     * @param x
     * @param y
     * @return 
     */
    public boolean full(int x, int y) {
        return avaiable(x, y) && counter[x][y];
    }
    /**
     * Sprawdza czy podane miejsce jest zajete 
     * @param x
     * @param y
     * @return 
     */
    public boolean free(int x, int y) {
        return avaiable(x, y) && !counter[x][y];
    }
    
    /**
     * Sprawdza czy jest możliwy jeszcze ruch na planszy
     * @return 
     */
    public boolean possibleMove() {
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++) {
                if (full(i,j)&&full(i+1,j)&&free(i+2,j) || free(i,j)&&full(i+1,j)&&full(i+2,j) || full(i,j)&&full(i,j+1)&&free(i,j+2) || free(i,j)&&full(i,j+1)&&full(i,j+2))
                    return true;
            }
        return false;
    }
    
    /**
     * Zwraca pionek na podanych współrzednych
     * @param x
     * @param y
     * @return 
     */
    public boolean getCounter(int x,int y) {
        return counter[x][y];
    }
   /**
    * Zdejmuje lub ustawia pionek na podanych współrzędnych
    * @param x
    * @param y
    * @param flag 
    */
    public void setCounter(int x, int y, boolean flag) {
        counter[x][y]=flag;
    }

    public int getPointY() {
        return pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public boolean isSelected() {
        return selected;
    }
    
    
    /**
     * Resetuje tablice z pionkami
     * @param versionE 
     */
    public void reset(boolean versionE){
        for (int i = 2; i < 5; i++)
            for (int j = 0; j < 7; j++) {
                avaiable[i][j] = true;
                avaiable[j][i] = true;
                counter[i][j]=true;
                counter[j][i]=true;
            }
        rest = 32;
        if (versionE) {
            for (int i = 1; i < 6; i++)
                for (int j = 1; j < 6; j++) {
                    avaiable[i][j] = true;
                    counter[i][j]=true;
                }
            rest+=4;
        }
        counter[3][3]=false;
        selected=false;
        turn=1;
        pointX=3;
        pointY=3;
    }
}

package Model;


import View.Window;
import java.awt.Color;
/**
 * Klasa opakowująca narzedzia do poprawnej rozgrywki
 * @author kamil
 */
public class Samotnik {

    private Color colorCounter, colorBack, colorPoint, colorSelect;
    private Window window;
    private Board board;
    private boolean versionE;
    private static Samotnik INSTANCE;
     
    {
        colorCounter = Color.DARK_GRAY;
        colorBack = Color.ORANGE;
        colorPoint=Color.LIGHT_GRAY;
        colorSelect=Color.RED;
    }
    private Samotnik(){}
 
    public static Samotnik getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Samotnik();
        }
        return INSTANCE;
    }
    
    public void init(){
        board= new Board(versionE);
        window=new Window(board);
    }

    public void newGame() {        
        board.reset(versionE);
    }
   
    public Color getColorBack() {
        return colorBack;
    }

    public void setColorBack(Color newColor) {
        colorBack = newColor;
    }
    
    public Color getKolorPoint() {
        return colorPoint;
    }
    public void setColorPoint(Color kolorWypelnienia) {
        this.colorPoint = kolorWypelnienia;
    }
    
    public void setColorSelect(Color colorSelect) {
        this.colorSelect = colorSelect;
    }
    public Color getColorCounter() {
        return colorCounter;
    }

    public void setColorCounter(Color newColor) {
        this.colorCounter = newColor;
    }
    public Color getColorSelect() {
        return colorSelect;
    }
    
    /**
     * Czy gra się zakończyła?
     * @return Koniec gry
     */
    public boolean isEnd() {
        return !board.possibleMove();
    }
    /**
     * Określa wersje gry
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
    
    public void close(){
        window.dispose();
    }
    
}

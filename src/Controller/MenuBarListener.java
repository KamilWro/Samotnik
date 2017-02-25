package Controller;


import Model.Samotnik;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
/**
 * Klasa nasłuchująca zdarzenia z menu
 * @author kamil
 */
public class MenuBarListener  implements ActionListener {
            
            private final Samotnik samotnik;
            private Color color;
            public MenuBarListener(){
                this.samotnik=Samotnik.getInstance();
            }
            
            /**
             * Słuchacz okienkowy (metoda jest wywołana po naciśnięciu przycisku na planszy)
             * @param e 
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String source=e.getActionCommand();
                switch(source){
                    case "NowaGra":{
                        samotnik.newGame();
                        break;
                    }
                    case "KoniecGry":{
                        samotnik.close();
                        break;
                    }
                    case "OGrze":{
                        String s="Najprawdopodobniej samotnik, to gra wymyślona w XII wieku we Francji przez więźnia \n"
                                + "przebywającego w Bastylii, który uprzyjemniał sobie czas spędzony w odosobnieniu. \n"
                                + "Samotnik, jest prostą grą logiczną dla jednej osoby.Pole do gry ma kształt krzyża z \n"
                                + "jednym pustym polem w środku oraz 32 polami zapełnionymi. W grze jedynym dozwolonym \n"
                                + "ruchem jest przeskoczenie pionka innym pionkiem w pionie lub w poziomie, co powoduje zbicie \n"
                                + "przeskoczonego pionka. Celem gry jest pozostawienie na planszy jednego pionka, \n"
                                + "najlepiej jeśli będzie to pionek w centrum.";
                        JOptionPane.showMessageDialog(null, s, "O Grze", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }                                    
                    case "OApk":{
                        JOptionPane.showMessageDialog(null, "Autor:                 Kamil Breczko\nWersja:              1.0+\nData wydania:  09 12 2016", "O Aplikacji", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }                    
                    case "KolorTlo":{
                        color=samotnik.getColorBack();
                        color=JColorChooser.showDialog(null, "Wybierz kolor tla planszy", color);
                        samotnik.setColorBack(color);
                        break;
                    }    
                    case "KolorPi":{
                        color = JColorChooser.showDialog(null, "Wybierz kolor Pionka",samotnik.getColorCounter());
                        samotnik.setColorCounter(color);
                        break;
                    }
                    case "KolorWyp":{                
                        String[] mozliwosci = {"Zolty", "Zielony", "Szary"};
                        String wybor;
                        wybor = (String)JOptionPane.showInputDialog(null, "Wybierz kolor zaznaczenia pionka:", "Wybor koloru:",JOptionPane.WARNING_MESSAGE, null,mozliwosci, mozliwosci[0]);
                        switch(wybor){
                            case "Zolty":{
                                samotnik.setColorPoint(Color.YELLOW);
                                break;
                            }
                            case "Zielony":
                                samotnik.setColorPoint(Color.GREEN);
                                break;
                            case "Szary":
                                samotnik.setColorPoint(Color.GRAY);
                                break;
                        }
                        break;
                    } 
                    case "Czerwony":{
                        samotnik.setColorSelect(Color.RED);
                        break;
                    }
                    case "Niebieski":{
                        samotnik.setColorSelect(Color.BLUE);
                        break;
                    }
                    case "Bryt":{
                        samotnik.setVersionE(false);
                        break;
                    } 
                    case "Euro":{
                        samotnik.setVersionE(true);
                        break;
                    } 
                }
                samotnik.update();
            }                        
}

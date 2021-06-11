/**
 * 
 * @author Benjamin Giraud-Renard
 **/

import javax.swing.*;
import view.*;
import model.*;

/*
* run the app
*/
public class LauncherMain {
    public static void main(String[] args) {

        InitColis liste = new InitColis();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Fenetre();
            }
        });
    }
}
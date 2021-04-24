/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStage;

import java.util.Scanner;

/**
 *
 * @author notda
 */
public class Main {
    public static void main(String[] args) {
        GameStage gameStage = new GameStage(); //use this
        System.out.print("type play : ");
        Scanner input_ = new Scanner(System.in);
        String input = input_.nextLine();
        if("play".equals(input))
        {
            gameStage.main(args); //use this for run GameStage
        }
        
    }
}

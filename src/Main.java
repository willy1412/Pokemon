/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Willy1412
 */
public class Main {
    public static void main(String[] args){
        PokemonSim pokemonSim = new PokemonSim();
        Scanner sc = new Scanner(System.in);
        String userChoice;
        
        do{
            pokemonSim.init();
        
            pokemonSim.input();
        
            pokemonSim.play();
        
            
            System.out.println("Do you want to play again? (Y/N)");
            userChoice = sc.nextLine();
            
        }while(userChoice.equals("Y") || userChoice.equals("y"));
    }
}

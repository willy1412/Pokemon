/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Willy1412
 */
public class PokemonSim {
    
    private Pokemon collections;
    private String playerName;
    private Pokemon chosenPokemon;
    private int userChoice;
    private double damage;
    private double stageArr[] = {2/8, 2/7, 2/6, 2/5, 2/4, 2/3, 2/2, 3/2, 4/2, 5/2, 6/2, 7/2, 8/2};
    private int stageDefense = 7;
    private int stageAttack = 7;
    
    
    Scanner sc = new Scanner(System.in);
    
    private double modifier(){
        double min = 0.85;
        double max = 1.00;
        double modifier;
        Random n = new Random();
        modifier = min + (max-min) * n.nextDouble();
        return modifier;
    }
    
    private double inflictDamage(Pokemon chosenPokemon, Pokemon collections){
        damage = (((2 * chosenPokemon.getLevel() + 10 ) / 250)
                * ((chosenPokemon.getAttack() * stageArr[stageAttack]) / (collections.getDefense() * stageArr[stageDefense])) * 40 + 2) * modifier();
        return damage;
    }
    
    private void increaseStageDefense(int number){
        stageDefense += number;
    }
    
    private void decreaseStageDefense(int number){
        stageDefense -= number;
    }
    
    private void increaseStageAttack(int number){
        stageAttack += number;
    }
    
    private void decreaseStageAttack(int number){
        stageAttack -= number;
    }
    
    public void init(){
        System.out.println("POKEMON SIMULATION");
        System.out.println("By: Wuilly Praditya");
        System.out.println("-----------------------------------------------");
    }
    
    public void input(){
      
        //USER INPUT NAME
        System.out.print("Your Name:  ");
        playerName = sc.nextLine();
        //USER INPUT POKEMON CHOICE
        boolean YNChoice = true;
        
        do{
            System.out.println("Choose a Pokemon    :");
            System.out.println("1)  CHIMCHAR");
            System.out.println("2)  PIPLUP");
            System.out.println("3)  TURTWIG");
            System.out.print("Choice  :");
            userChoice = sc.nextInt();
            String userInput;
                
                //Choosing CHIMCHAR
                if(userChoice == 1){
                    System.out.print("Are you sure you want to choose CHIMCHAR? (Y/N) ");
                    userInput = sc.next();
                    if(userInput.equals("Y") || userInput.equals("y")){
                        chosenPokemon = new Chimchar();
                        YNChoice = false;
                    }else{
                        YNChoice = true;
                    }
                //Choosing PIPLUP    
                }else if(userChoice == 2){
                    System.out.print("Are you sure you want to choose Piplup? (Y/N) ");
                    userInput = sc.next();
                    if(userInput.equals("Y") || userInput.equals("y")){
                        chosenPokemon = new Piplup();
                        YNChoice = false;
                    }else{
                        YNChoice = true;
                    }
                //Choosing TURTWIG    
                }else if(userChoice == 3){
                    System.out.print("Are you sure you want to choose Turtwig? (Y/N) ");
                    userInput = sc.next();
                    if(userInput.equals("Y") || userInput.equals("y")){
                        chosenPokemon = new Turtwig();
                        YNChoice = false;
                    }else{
                        YNChoice = true;
                    }
                }
        }while(YNChoice);    
    }
    
    public void play(){
        System.out.println("WALKING...");
        
        Random rand = new Random();
        int n = rand.nextInt(2);
        switch(n){
            case 0: collections = new Starly();
                System.out.println("Whoa! A wild STARLY appeared!");
                break;
            case 1: collections = new Trashdove();
                System.out.println("Whoa! A wild TRASH DOVE appeared!");
                break;
        }
        
        System.out.println("Go! " + chosenPokemon.getPokemonName() + "!");
        
        //BATTLE LOOP
        int attackChoice;
        int myHP = chosenPokemon.getHealthPoint();
        int enemyHP = collections.getHealthPoint();
        
        do{
            System.out.println("================");
            System.out.println("Status:");
            System.out.println(collections.getPokemonName() + " Lv " + collections.getLevel()
                            + ", HP = " + enemyHP + "/" + collections.getHealthPoint());
            System.out.println(chosenPokemon.getPokemonName() + " Lv " + chosenPokemon.getLevel()
                            + ", HP = " + myHP + "/" + chosenPokemon.getHealthPoint());
            System.out.println("================");
            
            if(myHP <= 0 || enemyHP <=0)
                break;
            
            //IF OUR POKEMON HAS HIGHER SPEED
            if(chosenPokemon.getSpeed() > collections.getSpeed()){
                System.out.println("What will " + chosenPokemon.getPokemonName() + " do?");
                chosenPokemon.move();
                System.out.print("Choice  :");
                attackChoice = sc.nextInt();  
                if(attackChoice == 1){
                    System.out.println(chosenPokemon.getPokemonName() + " use " + chosenPokemon.getAttackMove() + "!");
                    enemyHP -= inflictDamage(chosenPokemon, collections);
                }else if(attackChoice == 2){
                    System.out.println(chosenPokemon.getPokemonName() + " use " + chosenPokemon.getDefenseMove() + "!");
                    if(chosenPokemon.getPokemonName().equals("CHIMCHAR")){
                        decreaseStageDefense(1); 
                    }else if(chosenPokemon.getPokemonName().equals("PIPLUP")){
                        decreaseStageAttack(1);
                    }else if(chosenPokemon.getPokemonName().equals("TURTWIG")){
                        increaseStageDefense(1);
                    }
                }
                
                System.out.println("================");
                System.out.println("Status:");
                System.out.println(collections.getPokemonName() + " Lv " + collections.getLevel()
                            + ", HP = " + enemyHP + "/" + collections.getHealthPoint());
                System.out.println(chosenPokemon.getPokemonName() + " Lv " + chosenPokemon.getLevel()
                            + ", HP = " + myHP + "/" + chosenPokemon.getHealthPoint());
                System.out.println("================");
                
                if(myHP <= 0 || enemyHP <=0)
                    break;

                if(collections.getPokemonName().equals("TRASH DOVE")){
                    Random randAtt = new Random();
                    int m = randAtt.nextInt(2);
                    switch(m){
                        case 0: collections.getAttackMove();
                                System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getAttackMove() + "!"); 
                                myHP -= inflictDamage(collections, chosenPokemon);
                                break;
                        case 1: collections.getDefenseMove();
                                System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getDefenseMove() + "!");   
                                break;
                    }
                
                }else if(collections.getPokemonName().equals("STARLY")){
                    System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getAttackMove() + "!"); 
                    myHP -= inflictDamage(collections, chosenPokemon);
                }
                
            //IF ENEMY POKEMON HAS HIGHER SPEED
            }else if(chosenPokemon.getSpeed() < collections.getSpeed()){
                
                if(collections.getPokemonName().equals("TRASH DOVE")){
                    Random randAtt = new Random();
                    int m = randAtt.nextInt(2);    
                    switch(m){
                    case 0: collections.getAttackMove();
                            System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getAttackMove() + "!"); 
                            myHP -= inflictDamage(collections, chosenPokemon);
                            break;
                    case 1: collections.getDefenseMove();
                            System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getDefenseMove() + "!");   
                            break;
                            }
                }else if(collections.getPokemonName().equals("STARLY")){
                    System.out.println("The wild " + collections.getPokemonName() + " use " + collections.getAttackMove() + "!"); 
                    myHP -= inflictDamage(collections, chosenPokemon);
                }
                
                System.out.println("================");
                System.out.println("Status:");
                System.out.println(collections.getPokemonName() + " Lv " + collections.getLevel()
                            + ", HP = " + enemyHP + "/" + collections.getHealthPoint());
                System.out.println(chosenPokemon.getPokemonName() + " Lv " + chosenPokemon.getLevel()
                            + ", HP = " + myHP + "/" + chosenPokemon.getHealthPoint());
                
                if(myHP <= 0 || enemyHP <=0)
                    break;
                
                System.out.println("What will " + chosenPokemon.getPokemonName() + " do?");
                chosenPokemon.move();
                System.out.print("Choice  :");
                attackChoice = sc.nextInt();  
                if(attackChoice == 1){
                    System.out.println(chosenPokemon.getPokemonName() + " use " + chosenPokemon.getAttackMove() + "!");
                    enemyHP -= inflictDamage(chosenPokemon, collections);
                }else if(attackChoice == 2){
                    System.out.println(chosenPokemon.getPokemonName() + " use " + chosenPokemon.getDefenseMove() + "!");
                    if(chosenPokemon.getPokemonName().equals("CHIMCHAR")){
                        decreaseStageDefense(1); 
                    }else if(chosenPokemon.getPokemonName().equals("PIPLUP")){
                        decreaseStageAttack(1);
                    }else if(chosenPokemon.getPokemonName().equals("TURTWIG")){
                        increaseStageDefense(1);
                    }
                }
            }    
        }while(enemyHP > 0 || myHP > 0);
        
        if(myHP <= 0){
            System.out.println(chosenPokemon.getPokemonName() + " fainted");
            System.out.println("YOU LOSE !!!");
        }else if(enemyHP <= 0){
            System.out.println(collections.getPokemonName() + " fainted");
            System.out.println("YOU WIN !!!");
        }
    }   
}

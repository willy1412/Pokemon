/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willy1412
 */
public class Pokemon {
    protected String pokemonName;
    protected int level;
    protected int healthPoint;
    protected double attack;
    protected double defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;
    protected String attackMove;
    protected String defenseMove;

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move(){
        
    }
    
    public String getAttackMove() {
        return attackMove;
    }

    public void setAttackMove(String attackMove) {
        this.attackMove = attackMove;
    }

    public String getDefenseMove() {
        return defenseMove;
    }

    public void setDefenseMove(String defenseMove) {
        this.defenseMove = defenseMove;
    }
    
}

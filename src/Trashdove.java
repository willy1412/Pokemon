
public class Trashdove extends Pokemon{

    public Trashdove(){
        pokemonName = "TRASH DOVE";
        level = 6;
        healthPoint = 25;
        attack = 3.0;
        defense = 15.0;
        specialAttack = 5;
        specialDefense = 20;
        speed = 8;
        attackMove = "Peck";
        defenseMove = "Head Banging";
    }
    
    public void move(){
        System.out.println("1.  " + getAttackMove());
        System.out.println("2.  " + getDefenseMove());
    }

}

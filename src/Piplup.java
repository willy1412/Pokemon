
public class Piplup extends Pokemon{

    public Piplup(){
        pokemonName = "PIPLUP";
        level = 5;
        healthPoint = 21;
        attack = 11.0;
        defense = 11.0;
        specialAttack = 12;
        specialDefense = 12;
        speed = 10;
        attackMove = "Pound";
        defenseMove = "Growl";
    }
    
    public void move(){
        System.out.println("1.  " + getAttackMove());
        System.out.println("2.  " + getDefenseMove());
    }

}
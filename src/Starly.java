
public class Starly extends Pokemon {

    public Starly(){
        pokemonName = "STARLY";
        level = 5;
        healthPoint = 14;
        attack = 7.0;
        defense = 6.0;
        specialAttack = 6;
        specialDefense = 6;
        speed = 8;
        attackMove = "Tackle";
    }

    public void move(){
        System.out.println("1.  " + getAttackMove());
    }

}

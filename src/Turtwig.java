
public class Turtwig extends Pokemon {

    public Turtwig(){
        pokemonName = "TURTWWIG";
        level = 5;
        healthPoint = 22;
        attack = 13.0;
        defense = 15.0;
        specialAttack = 11;
        specialDefense = 12;
        speed = 9;
        attackMove = "Scratch";
        defenseMove = "Withdraw";
    }
    
    public void move(){
        System.out.println("1.  " + getAttackMove());
        System.out.println("2.  " + getDefenseMove());
    }

}

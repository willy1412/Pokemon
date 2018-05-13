
public class Chimchar extends Pokemon{

    public Chimchar(){
        pokemonName = "CHIMCHAR";
        level = 5;
        healthPoint = 20;
        attack = 12.0;
        defense = 10.0;
        specialAttack = 12;
        specialDefense = 10;
        speed = 12;
        attackMove = "Scratch";
        defenseMove = "Leer";
    }
    
    public void move(){
        System.out.println("1.  " + getAttackMove());
        System.out.println("2.  " + getDefenseMove());
    }

}

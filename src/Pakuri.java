public class Pakuri {

    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species){
        //sets stats and species to appropriate values
        this.species = species;
        attack = (species.length()*7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public String getSpecies(){return species;}

    public int getAttack(){return attack;}

    public int getDefense(){return defense;}

    public int getSpeed(){ return speed;}

    public void setAttack(int newAttack){
        this.attack = newAttack;
    }

    public void evolve(){
        //changes stats appropriately when evolving
       this.attack = this.attack * 2;
        this.defense = this.defense * 4;
        this.speed = this.speed * 3;
    }

}

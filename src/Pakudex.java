import java.util.Arrays;

public class Pakudex {
    public int capacity;
    public int size =0;
    public Pakuri[] pakuriArray;
    public static boolean speciesInPakudex = false;

    public Pakudex(){
        this.capacity = 20;
        pakuriArray = new Pakuri[this.capacity];
    }

    public Pakudex(int capacity)
    {
        this.capacity = capacity;
        pakuriArray = new Pakuri[this.capacity];
    }


    public int getSize(){
        return size;
    }

    public int getCapacity(){return capacity;}

    public String[] getSpeciesArray(){
        //gets species of all Pakuri in pakuriArray,
        // creates and returns a String array of them,
        String[] speciesName = new String[size];
        if(size > 0){
        for (int i = 0; i < size; i++){
            speciesName[i] = pakuriArray[i].getSpecies();
        }

        return speciesName;}
        //if no species have been added, returns null
        else{return null;}
    }

    public int[] getStats(String species){
        //finds Pakuri specified by user in pakuriArray[] and
        // adds values in a created int array (stats[]) which is returned after messages with all of the Pakuri's
        // stats and species have been printed
        Pakuri designatedPakuri = new Pakuri(species);
        boolean pakuriExists = false;
        for(int i =0; i < size; i++){
            if(species.equals(pakuriArray[i].getSpecies())){
                designatedPakuri = pakuriArray[i];
                pakuriExists = true;
                int[] stats = new int[3];
                stats[0]= designatedPakuri.getAttack();
                stats[1]= designatedPakuri.getDefense();
                stats[2]= designatedPakuri.getSpeed();
                System.out.println("Species: " + designatedPakuri.getSpecies());
                System.out.println("Attack: " + designatedPakuri.getAttack());
                System.out.println("Defense: " + designatedPakuri.getDefense());
                System.out.println("Speed: " + designatedPakuri.getSpeed());
                return stats;
            }
        }
        //if above for loop has not found a Pakuri, prints error message and returns null
        if(pakuriExists == false){
            System.out.println("Error: No such Pakuri!");
        }
    return null;
    }





    public void sortPakuri(){
        //insertion sort for Pakuri in pakuriArray
        String temp;
        Pakuri tempPakuri;
        //if pakuriiArray[j+1] is less than pakuriArray[i] switch both using a temporary Pakuri and String,
        // keep looping through until all Pakuri have been sorted and print a success message
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (pakuriArray[i].getSpecies().compareTo(pakuriArray[j].getSpecies())>0)
                {
                    temp = getSpeciesArray()[i];
                    getSpeciesArray()[i] = getSpeciesArray()[j];
                    getSpeciesArray()[j] = temp;
                    tempPakuri = pakuriArray[i];
                    pakuriArray[i] = pakuriArray[j];
                    pakuriArray[j] = tempPakuri;
                }
            }
        }
        System.out.println("Pakuri have been sorted!");
    }

    public boolean addPakuri(String species){
        //checks if a Pakuri with species exists, if so prints error message and returns false
        for(int i=0; i< size; i++){
            Pakuri temp = new Pakuri(species);
            if (pakuriArray[i].getSpecies().equals(temp.getSpecies())){
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
        }
        //checks if Pakudex is full, if so prints error message and returns false
        if(size == capacity){System.out.println("Error: Pakudex is full!");
            PakuriProgram.openMenu();
            return false;}
        //adds Pakuri to first unfilled array, increases size and prints appropriate message
        else if (size < capacity){
            Pakuri temp = new Pakuri(species);
            pakuriArray[size] = temp;
            size++;
            speciesInPakudex =true;
            System.out.print("Pakuri species "+ species +" successfully added!");
            return true;
        }
        System.out.println("Error: Pakudex is full!");
        return false;
    }

    public boolean evolveSpecies(String species){
        //looks for Pakuri in pakuriArray[] and calls it's evolve function when found , returns true
        for(int i =0;i<size;i++){
            if(species.equals(pakuriArray[i].getSpecies())){
                pakuriArray[i].evolve();
                System.out.println(pakuriArray[i].getSpecies() + " has evolved!");
                return true;
            }
        }
        //if Pakuri isn't found, print error message and return false
        System.out.println("Error: No such Pakuri!");
        return false;
    }


}

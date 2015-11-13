package people;

import java.util.Random;

public class PersonCreator extends Person {

    
    public  static void personcreator(){
        
        double temp;
        int temp1;
        
        Random dice = new Random();
        
        intelect = dice.nextInt(10) + 1;
        
        workinghours = dice.nextInt(11);
        
        
    }
}

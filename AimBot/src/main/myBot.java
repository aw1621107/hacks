package main;

import java.awt.*;
import java.awt.event.*;

public class myBot{
  public static void main(String[] args)throws AWTException{
    Robot myRobot = new Robot();
    for(int i  = 0; i<1000; i++){
    
        myRobot.delay(10);
        myRobot.mouseMove(1005,i);
    }
    
  }

}
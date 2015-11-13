package People;

import buildings.buidingsmap;

public class Person {

    // person man = new person();
    // private PersonCreator create = new PersonCreator();

    static buidingsmap map = new buidingsmap();

    private static boolean first = true;

    private static int happy = 40;
    private static int hungry = 100;

    public static int intelect;
    public static int workinghours;

    private static int hoursworked;

    public static boolean nhappy = false;
    public static boolean nfood;
    public static boolean working = false;

    private int xloc;
    private int yloc;
    public static int nextxloc;
    public static int nextyloc;

    public static void firststep(int x, int y) {
        if (first = true) {

            PersonCreator.personcreator();
        } else {
            System.out.println("check adding perople code");
        }
    }

    public static void needschck() {
        System.out.println("checkng needs");
        if (happy <= 50) {
            nhappy = true;
            System.out.println("need happy");
        }

        if (hungry <= 50) {
            nfood = true;
            System.out.println("need food");
        }

        if (hoursworked == workinghours) {
            working = false;
            System.out.println("going home");
        }

    }

    public static void movelocation() {
        String temp;
        int xmove;
        int ymove;
        if (working = false) {
            temp = map.home();
            temp = temp.substring(2, temp.length());
            ymove = Integer.parseInt(temp);
            temp = map.home();
            temp = temp.substring(0, 1);
            xmove = Integer.parseInt(temp);
            System.out.print("moving towards");
            System.out.println(xmove + "," + ymove);

        }
        /*
         * if (nfood = true) { temp = map.cantten(); temp = temp.substring(2,
         * temp.length()); ymove = Integer.parseInt(temp); temp = map.cantten();
         * temp = temp.substring(0, 1); xmove = Integer.parseInt(temp);
         * System.out.print("moving towards"); System.out.println(xmove + "," +
         * ymove); nfood = false; }
         */
        if (nhappy = true) {

            temp = map.mine();
            temp = temp.substring(2, temp.length());
            ymove = Integer.parseInt(temp);
            temp = map.mine();
            temp = temp.substring(0, 1);
            xmove = Integer.parseInt(temp);
            System.out.print("moving towards");
            System.out.println(xmove + "," + ymove);
            nhappy = false;
        }
    }
}


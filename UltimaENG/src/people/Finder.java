package people;

public class Finder implements Runnable {

    static Person man = new Person();
    static PersonCreator create = new PersonCreator();

    private static boolean running = true;

    public void run() {
        System.out.println("running");
        personref();
    }

    public static void main(String[] args) {

        PersonCreator.personcreator();

        while (running = true) {
            (new Thread(new Finder())).start();
        }
    }

    private static void personref() {
        Person.needschck();
        Person.movelocation();
    }
}

package Step.Week7;

public class CategoryCAssignment {
    public static void runProblem1() {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth());
        c.heal(50);
        System.out.println("Health after 50 heal (capped): " + c.getHealth());
        c.takeDamage(150);
        System.out.println("Health after 150 damage (floored): " + c.getHealth());
    }

    public static void runProblem2() {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("First song in playlist: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }

    public static void runProblem3() {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("abcd strength: " + pc1.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij strength: " + pc2.getStrength());
    }

    public static void runProblem4() {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }

    public static void runProblem5() {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + (int) cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }

    public static void main(String[] args) {
        runProblem1();
        runProblem2();
        runProblem3();
        runProblem4();
        runProblem5();
    }
}

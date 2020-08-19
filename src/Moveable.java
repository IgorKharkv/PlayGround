public interface Moveable {
    final int a = 10;
    default void display()
    {
        System.out.println("hello");
    }
    static void display2()
    {
        System.out.println("hello");
    }
}

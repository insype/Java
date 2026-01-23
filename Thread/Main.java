class A extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("prasiddha");
        }

    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello");
        }

    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();

    }
}
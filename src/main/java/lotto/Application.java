package lotto;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new Controller().start();
        } catch (IllegalArgumentError e) {
            System.out.println(e.getMessage());
        }

    }
}

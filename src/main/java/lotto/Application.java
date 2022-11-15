package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new Store().entry();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

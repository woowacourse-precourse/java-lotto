package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            UI Lotto = new UI();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

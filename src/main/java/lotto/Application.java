package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            new Process();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

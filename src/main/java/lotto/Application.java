package lotto;


public class Application {
    public static void main(String[] args) {
        try {
            // reset for prize status is required for multiple gradlew test
            Prize.prizeReset();
            InOutput ui = new InOutput();
            ui.printAll();
        } catch (IllegalArgumentException msg) {
            System.out.println(msg);
        }
    }
}


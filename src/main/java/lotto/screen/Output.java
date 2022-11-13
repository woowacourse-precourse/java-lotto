package lotto.screen;

import java.util.function.Supplier;

public class Output {
    private static Output output = new Output();

    private Output() {
    }

    public static Output getInstance() {
        return output;
    }
    public void printMessage(String message, Object... object) {
        System.out.printf(message, object);
    }

    public void output(Supplier<String> supplier) {
        System.out.print(supplier.get());
    }

    public void printError(String errorMessage) {
        System.err.println("[ERROR] " + errorMessage);
    }
}

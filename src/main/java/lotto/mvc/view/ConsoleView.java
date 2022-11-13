package lotto.mvc.view;

public final class ConsoleView {

    private ConsoleView() {
    }

    public static void render(String message) {
        System.out.println(message);
    }
}

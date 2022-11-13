package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getLottoCount(String input) {
        if (!input.matches("[0-9]+")) return -1;

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) return -1;

        return money / 1000;
    }
}

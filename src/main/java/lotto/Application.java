package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getLottoCount(String input) {
        if (!input.matches("[0-9]+")) throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다.");

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위로 입력해야 합니다.");

        return money / 1000;
    }
}

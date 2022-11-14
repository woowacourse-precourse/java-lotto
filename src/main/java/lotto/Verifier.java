package lotto;

public class Verifier {
    public static boolean isValidMoney(String input) {
        if (!input.matches("[+]?\\d+")) {
            return false;
        }
        int money = Integer.parseInt(input);
        if (money < Lotto.PRICE) {
            return false;
        }
        if ((money % Lotto.PRICE) != 0) {
            return false;
        }
        return true;
    }
}

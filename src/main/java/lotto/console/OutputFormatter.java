package lotto.console;

class OutputFormatter {

    static String formatMoney(int money) {
        return String.format(String.valueOf(money), "%,.2f", money);
    }
}

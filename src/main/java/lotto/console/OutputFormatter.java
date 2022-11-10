package lotto.console;

class OutputFormatter {

    static String formatMoney(int money) {
        return String.format(String.valueOf(money), "%,.2f", money);
    }

    static String formatPercent(float number) {
        return String.format(String.valueOf(number), ".1f%%", number*100f);
    }
}

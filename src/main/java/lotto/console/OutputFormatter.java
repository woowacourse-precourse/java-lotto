package lotto.console;

class OutputFormatter {

    static String formatMoney(int money) {
        return String.format("%,d", money);
    }

    static String formatPercent(float number) {
        return String.format("%.1f%%", number * 100f);
    }
}

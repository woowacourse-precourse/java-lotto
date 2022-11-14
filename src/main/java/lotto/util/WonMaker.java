package lotto.util;

public class WonMaker {
    private static final char DELIMITER = ',';

    public static String makeWon(long money) {
        StringBuffer won = new StringBuffer();
        addNumberWon(money, won);
        won.reverse();
        won.append("원");
        return won.toString();
    }

    private static void addNumberWon(long money, StringBuffer won) {
        do {
            if (won.length() % 4 == 3 && won.length() != 0) {
                won.append(DELIMITER);
            }
            won.append(money % 10);
            money /= 10;
        } while (money != 0);
    }
}

package lotto.utils;

public enum Winning {
    FIRST("first", "6개 일치", 2000000000),
    SECOND("second", "5개 일치, 보너스 볼 일치", 30000000),
    THIRD("third", "5개 일치", 1500000),
    FOURTH("fourth", "4개 일치", 50000),
    FIFTH("fifth", "3개 일치", 5000);

    private final String label;
    private final String count;
    private final int prize;

    Winning(String label, String count, int prize) {
        this.label = label;
        this.count = count;
        this.prize = prize;
    }

    public static String getCountByLabel(String label) {
        String count = null;
        for (Winning win : Winning.values()) {
            if(win.label.equals(label)) {
                count = win.count;
                break;
            }
        }
        return count;
    }

    public static int getPrizeByLabel(String label) {
        int prize =0;
        for (Winning win : Winning.values()) {
            if(win.label.equals(label)) {
                prize = win.prize;
                break;
            }
        }
        return prize;
    }
}

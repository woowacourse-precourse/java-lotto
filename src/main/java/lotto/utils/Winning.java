package lotto.utils;

public enum Winning {
    FIRST("first", "6�� ��ġ", 2000000000),
    SECOND("second", "5�� ��ġ, ���ʽ� �� ��ġ", 30000000),
    THIRD("third", "5�� ��ġ", 1500000),
    FOURTH("fourth", "4�� ��ġ", 50000),
    FIFTH("fifth", "3�� ��ġ", 5000);

    private final String label;
    private final String count;
    private final int prize;

    Winning(String label, String count, int prize) {
        this.label = label;
        this.count = count;
        this.prize = prize;
    }

    public String getLabel() {
        return label;
    }

    public static String getCountByLabel(String label) {
        String count = null;
        for (Winning win : Winning.values()) {
            if (win.label.equals(label)) {
                count = win.count;
                break;
            }
        }
        return count;
    }

    public static int getPrizeByLabel(String label) {
        int prize = 0;
        for (Winning win : Winning.values()) {
            if (win.label.equals(label)) {
                prize = win.prize;
                break;
            }
        }
        return prize;
    }
}
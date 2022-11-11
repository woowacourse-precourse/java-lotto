package lotto;

public enum Prize {
    FIFTH ("3개 일치 ", 5000L, 0),
    FOURTH ("4개 일치 ", 50000L, 0),
    THIRD ("5개 일치 ", 1500000L, 0),
    SECOND ("5개 일치, 보너스 볼 일치 ", 30000000L, 0),
    FIRST ("6개 일치 ", 2000000000L, 0);

    private String msg;
    private Long prize;
    private int count;

    Prize(String msg, Long prize, int count) {
        this.msg = msg;
        this.prize = prize;
        this.count = count;
    }

    public static void prizeReset() {
        for (Prize p: Prize.values())
            p.count = 0;
    }

    public void incrementCount() {count++;}

    private String prizeToString() {
        return String.format("(%,d원)", prize);
    }

    public void print() {
        System.out.format("%s%s - %d개\n", msg, prizeToString(), count);
    }

    public Long earn() {
        return prize * count;
    }
}
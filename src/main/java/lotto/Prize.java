package lotto;

public enum Prize {
    prize_0(0,"1등", 2000000000),
    prize_1(0,"2등", 30000000),
    prize_2(0,"3등", 1500000),
    prize_3(0,"4등", 50000),
    prize_4(0,"5등", 5000),
    prize_5(0,"none",0),
    prize_6(0,"none",0),
    prize_7(0,"none",0);

    private int count;
    private final String name;

    private final int prize;

    private Prize(int count, String name, int prize) {
        this.count = count;
        this.name = name;
        this.prize = prize;
    }

    public void addWinLotteryCount(){
        this.count++;
    }

    public Integer getWinLotteryPrize(){
        return this.prize;
    }

    public Integer getWinLotteryCount(){
        return this.count;
    }




}

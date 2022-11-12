package lotto;

public enum Prize {
    first(0,"1등", 2000000000),
    second(0,"2등", 30000000),
    third(0,"3등", 1500000),
    fourth(0,"4등", 50000),
    fifth(0,"5등", 5000),
    nocount(0,"아무것도아님",0);

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

    public String getWinLotteryName(){
        return this.name;
    }

    public Integer getWinLotteryPrize(){
        return this.prize;
    }

    public Integer getWinLotteryCount(){
        return this.count;
    }




}

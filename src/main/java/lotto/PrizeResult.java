package lotto;

public enum PrizeResult {
    success3(5000),
    success4(50000),
    success5(1500000),
    success5AndBonus(30000000),
    success6(2000000000);

    private int prize;

    PrizeResult(int prize) {
        this.prize = prize;
    }

    public int getResults(){

        return 0;
    }



}

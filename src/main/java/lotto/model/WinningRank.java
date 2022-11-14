package lotto.model;

public enum WinningRank {
    one(2_000_000_000,0),
    two(30_000_000,1),
    three(1_500_000,2),
    four(50_000,3),
    five(5_000,4),
    notThing(0, -1),
    ;

    private int prize;
    private int numberArrayIndex;

    WinningRank(int prize, int numberArrayIndex) {
        this.prize = prize;
        this.numberArrayIndex = numberArrayIndex;
    }

    public long calculateTotalMoneyByTheNumber(int theNumber) {
        return (long) (theNumber*prize);
    }

    public int getPrize() {
        return prize;
    }

    public int getNumberArrayIndex(){
        return numberArrayIndex;
    };

}

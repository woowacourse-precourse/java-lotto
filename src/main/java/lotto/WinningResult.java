package lotto;

public enum WinningResult {
    FIFTH         ("3개 일치", 5_000L, 0),
    FOURTH        ("4개 일치", 50_000L, 0),
    SECOND        ("5개 일치, 보너스 볼 일치", 30_000_000L, 0),
    THIRD         ("5개 일치", 1_500_000L, 0),
    FIRST         ("6개 일치", 2_000_000_000L, 0);

    private String message;
    private Long winnings;
    private int numOfWins;

    WinningResult(String message, Long winnings, int numOfWins){
        this.message = message;
        this.winnings = winnings;
        this.numOfWins = numOfWins;
    }

    public void increaseNumOfWins(){
        ++numOfWins;
    }

    public long earning() {
        return (long) numOfWins*winnings;
    }

    public void print(){
        System.out.println(
            message + " "
            + String.format("(%,d원)",winnings) + " - "
            + numOfWins + "개");
    }
}

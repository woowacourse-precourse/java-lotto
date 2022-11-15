package lotto.domain;

public enum WinningRank {
    THREE("5,000원"),
    FOUR("50,000원"),
    FIVE("1,500,000원"),
    BONUS("30,000,000원"),
    SIX("2,000,000,000원");

    private final String amount;
    WinningRank(String amount){
        this.amount = amount;
    }

    public String getAmount(){
        return amount;
    }
}

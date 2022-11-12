package lotto.model;

public class Buyer {
    private static final int AMOUNT_UNIT=1000;
    private int purchaseAmount;
    private int ticketAmount;

    public Buyer(int purchaseAmount){
        this.purchaseAmount=purchaseAmount;
    }

}
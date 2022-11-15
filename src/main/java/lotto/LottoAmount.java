package lotto;



public class LottoAmount {
    private static final int MIN_AMOUNT = 1000;
    private static final String MINIMUM_AMOUNT_ERROR = "[ERROR] " + MIN_AMOUNT + "이상 구매하셔야 합니다." ;
    private static final String AMOUNT_UNIT_ERROR = "[ERROR] " + MIN_AMOUNT + "원 단위로 구매하셔야 합니다." ;


    private final int purchaseAmount;

    public LottoAmount(int purchaseAmount) {
        validateAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }

    public int countTickets() {
        return (purchaseAmount / MIN_AMOUNT);
    }

    private void validateAmount(int purchaseAmount) {
        validateMinAmount(purchaseAmount);
        validateAmountUnit(purchaseAmount);
    }

    private void validateMinAmount(int purchaseAmount) {
        if(purchaseAmount < MIN_AMOUNT){
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
    }

    private void validateAmountUnit(int purchaseAmount) {
        if(purchaseAmount % MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(AMOUNT_UNIT_ERROR);
        }
    }
}

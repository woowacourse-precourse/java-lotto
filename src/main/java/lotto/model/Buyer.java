package lotto.model;

public class Buyer {
    private static final String ENTER_WRONG_LETTERS_MESSAGE = "[ERROR] 금액을 잘못 입력하셨습니다. 프로그램을 종료합니다.";

    private static final String NUMERIC = "\\d+";
    private static final String BLANK = "";
    private static final int AMOUNT_UNIT=1000;
    private static final String ENTER_WRONG_AMOUNT_MESSAGE="[ERROR] 금액의 최소 단위(1,000원)가 맞지 않습니다. 프로그램을 종료합니다.";
    private static final int PROPER_AMOUNT_CONDITION=0;
    private int purchaseAmount;
    private int ticketAmount;

    public Buyer(int purchaseAmount){

        this.purchaseAmount=purchaseAmount;
        validateProperUnitAmount(this.purchaseAmount);
        calculateAmountOfTickets();
    }
    private void calculateAmountOfTickets(){
        ticketAmount=purchaseAmount/AMOUNT_UNIT;
    }
    private void validateProperUnitAmount(int purchaseAmount){
        if(purchaseAmount%AMOUNT_UNIT!=PROPER_AMOUNT_CONDITION){
            throw new IllegalArgumentException(ENTER_WRONG_AMOUNT_MESSAGE);
        }
    }
    private void validateProperLetters(String purchaseAmount) {
        if (!purchaseAmount.replaceAll(NUMERIC, BLANK).equals(BLANK)) {
            throw new IllegalArgumentException(ENTER_WRONG_LETTERS_MESSAGE);
        }
    }

}
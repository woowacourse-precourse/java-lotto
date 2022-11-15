package lotto.domain;

public class Buyer {
    private static final String ENTER_WRONG_LETTERS_MESSAGE = "[ERROR] 금액을 잘못 입력하셨습니다.";
    private static final String NUMERIC = "\\d+";
    private static final String BLANK = "";
    private static final int AMOUNT_UNIT = 1000;
    private static final int PROPER_AMOUNT_CONDITION = 0;
    private int purchaseAmount;
    private int ticketAmount;

    public void validateProperLetters(String purchaseAmount) {
        if (!purchaseAmount.replaceAll(NUMERIC, BLANK).equals(BLANK)) {
            System.out.println(ENTER_WRONG_LETTERS_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void validateProperUnitAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (amount % AMOUNT_UNIT != PROPER_AMOUNT_CONDITION) {
            System.out.println(ENTER_WRONG_LETTERS_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void calculateAmountOfTickets() {
        ticketAmount = purchaseAmount / AMOUNT_UNIT;
    }

    public int changeType(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public void buyTickets(String purchaseAmount) {
        validateProperLetters(purchaseAmount);
        validateProperUnitAmount(purchaseAmount);
        this.purchaseAmount = changeType(purchaseAmount);
        calculateAmountOfTickets();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTickets() {
        return ticketAmount;
    }
}
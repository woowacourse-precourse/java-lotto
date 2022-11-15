package lotto.management;

import lotto.enums.Message;
public class Purchase {

    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_REGEX  = "^[0-9]*$";

    final int LOTTO_TICKETS;

    public Purchase(String purchaseMoney) {
        isNumber(purchaseMoney);
        validDivide(purchaseMoney);
        this.LOTTO_TICKETS = changeMoneyToLottoTickets(purchaseMoney);
    }

    private int changeMoneyToLottoTickets(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
    }

    private void isNumber(String purchaseMoney){
        if (!purchaseMoney.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void validDivide(String purchaseMoney) {
        int amount = Integer.parseInt(purchaseMoney);
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(Message.ERROR_NOT_THOUSAND_DIVIDE.getMessage());
        }
    }

    public int getNumberOfLottoTickets() {
        return LOTTO_TICKETS;
    }
}

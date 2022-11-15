package lotto.management;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_REGEX  = "^[0-9]*$";

    final int LOTTO_TICKETS;

    public LottoPurchase(String purchaseMoney) {
        isNumber(purchaseMoney);
        validDivide(purchaseMoney);
        this.LOTTO_TICKETS = changeMoneyToLottoTickets(purchaseMoney);
    }

    private int changeMoneyToLottoTickets(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
    }

    private void isNumber(String purchaseMoney){
        if (!purchaseMoney.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력받아야 합니다.");
        }
    }

    private void validDivide(String purchaseMoney) {
        int amount = Integer.parseInt(purchaseMoney);
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 단위여야 합니다.");
        }
    }

    public int getNumberOfLottoTickets() {
        return LOTTO_TICKETS;
    }
}

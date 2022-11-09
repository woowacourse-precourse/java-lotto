package lotto;

public class LottoMachine {
    public void requestWantBuyAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int canBuyAmount(int wantBuyAmountInput) {
        return wantBuyAmountInput / 1000;
    }
}

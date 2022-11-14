package lotto;

public class LottoMachine {
    public int getLottoBuyCount(int paidMoney) {
        return paidMoney / LottoInfo.PRICE.getValue();
    }
}

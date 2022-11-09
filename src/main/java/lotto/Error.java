package lotto;

public class Error {
    static void purchasePrice(int purchasePrice) {
        if (purchasePrice % LottoConst.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 정확히 입력 해 주세요. 금액 : " + purchasePrice);
        }
    }
}

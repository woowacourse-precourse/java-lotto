package lotto;

import lotto.domain.PurchaseLotto;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        // 구입금액 입력 및 로또 번호 생성
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLotto.inputAmount();


    }
}

package lotto;

import lotto.domain.InputNumber;
import lotto.domain.PurchaseLotto;

public class Application {
    public static void main(String[] args) {
        // 구입금액 입력 및 로또 번호 생성
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLotto.inputAmount();

        // 로또 번호와 보너스 번호 입력받기
        InputNumber inputNumber = new InputNumber();
        inputNumber.getInputNumbers();

    }
}

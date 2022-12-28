package lotto;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 구입금액 입력 및 로또 번호 생성
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        List<Lotto> lottoNumbers = purchaseLotto.inputAmount();

        // 로또 번호와 보너스 번호 입력받기
        InputNumber inputNumber = new InputNumber();
        List<Object> winningBonusNumbers = inputNumber.getInputNumbers();

        // 당첨 확인
        CountNumber countNumber = new CountNumber();
        countNumber.compare(winningBonusNumbers, lottoNumbers);

        // 수익률 계산
        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();
        rateOfReturnCalculator.rateOfReturn();

    }
}

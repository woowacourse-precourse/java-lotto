package lotto.controller;

import java.util.List;
import lotto.model.Calculator;
import lotto.model.Compare;
import lotto.model.Generator;
import lotto.model.InputException;
import lotto.model.Lotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    public static void lottoStart() {
        // 사용자 구입 금액 입력
        int purchaseAmount = Input.userInput();
        // 구매 수량 계산
        int purchaseQuantity = Calculator.calculatePurchase(purchaseAmount);
        // 구매 수량에 따른 로또 묶음 생성
        List<Lotto> lottoBundle = Generator.creatLottoBundle(purchaseQuantity);
        // 로또 묶음 출력
        Output.printLottoBundle(lottoBundle, purchaseQuantity);
        // 당첨 번호 입력
        List<Integer> winningNumber = Generator.creatWinningNumber(Input.winningNumberInput());
        // 보너스 번호 입력
        int bonusNumber = Input.bonusNumberInput();
        // 보너스 번호 예외 처리
        InputException.isValidBonusNumberOverlap(winningNumber, bonusNumber);
        // 당첨 번호에 보너스 번호 추가
        winningNumber = Generator.addBonusNumber(winningNumber, bonusNumber);
        // 로또 한장씩 당첨 번호와 비교
        Compare.sliceBundle(lottoBundle, winningNumber);
        // 당첨 금액 추가
        Calculator.addPrize();
        // 당첨 통계 출력
        Output.printResult(Calculator.rateOfReturn(purchaseAmount));
    }
}

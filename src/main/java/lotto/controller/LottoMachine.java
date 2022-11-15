package lotto.controller;

import lotto.domain.IssuedLottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 로또 정답 번호를 만들고 사용자에게 구매한 로또에 대한 결과를 보여주는 기계
 */
public class LottoMachine {
    public void start() {
        // 1. 돈을 입력받음
        // 2. 로또를 입력받은 돈에 맞게 발행함
        IssuedLottos issuedLottos = issueLotto();
        OutputView.showIssuedLottos(issuedLottos);

        // 3. 당첨번호를 입력받음
        // 4. 보너스번호를 입력받음
        WinningLotto winningLotto = new WinningLotto(InputView.inputLottoAnswer(), InputView.inputBonusNum());

        // 5. 통계 셋팅
        WinningStatistic winningStatistic = new WinningStatistic(issuedLottos, winningLotto);

        // 6. 통계 보여주기
        OutputView.showStatistic(winningStatistic.getMap(), issuedLottos);
    }

    private IssuedLottos issueLotto() {
        try {
            return new IssuedLottos(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return issueLotto();
        }
    }
}
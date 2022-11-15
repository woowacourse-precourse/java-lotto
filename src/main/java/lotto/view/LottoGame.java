package lotto.view;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.WinningStatistics;
import lotto.service.LottoService;
import lotto.util.LottoRandom;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public class LottoGame {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_BOUGHT_LOTTO = "개를 구매했습니다.";
    private static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final LottoController lottoController = new LottoController(new LottoService());
    public void start() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchaseAmount = lottoController.inputPurchaseAmount();     // 구입 금액 입력 받기
        List<Lotto> boughtLottos = createLottos(purchaseAmount);                      // 구매한 로또 출력
        printLottos(boughtLottos);
        System.out.println(purchaseAmount + NUMBER_OF_BOUGHT_LOTTO);    // 구매한 로또 개수 출력
        System.out.println(INPUT_PRIZE_NUMBER);
        Lotto winningLotto = lottoController.inputWinningNumbers();     // 당첨 번호 입력 받기
        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = lottoController.inputBonusNumber(winningLotto); // 보너스 번호 입력 받기
        printWinningStatistics(winningLotto, boughtLottos, bonusNumber); // 당첨 통계 출력
    }

    private List<Lotto> createLottos(int purchaseAmount) {
        return LottoRandom.createLottos(purchaseAmount);
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    private void printWinningStatistics(Lotto winningLotto, List<Lotto> boughtLottos, int bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, boughtLottos, bonusNumber);
        System.out.println(winningStatistics.toString());
    }
}

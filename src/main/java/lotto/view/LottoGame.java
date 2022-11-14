package lotto.view;

import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.service.LottoService;

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
        System.out.println(purchaseAmount + NUMBER_OF_BOUGHT_LOTTO);    // 구매한 로또 개수 출력
        System.out.println(INPUT_PRIZE_NUMBER);
        Lotto winningLotto = lottoController.inputWinningNumbers();     // 당첨 번호 입력 받기
        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = lottoController.inputBonusNumber();           // 보너스 번호 입력 받기
        // TODO: 당첨 통계 출력
    }
}

package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    /**
     * 구입금액 입력
     * @return 구매한 로또 개수
     */
    public int inputPurchaseAmount() {
        return lottoService.toPurchaseAmount(Console.readLine());
    }

    /**
     * 당첨 번호 입력
     * @return 당첨 번호 Lotto 객체
     */
    public Lotto inputWinningNumbers() {
        return lottoService.toLotto(Console.readLine());
    }

    //TODO: 보너스 번호 입력
    public int inputBonusNumber() {
        return 7;
    }
}

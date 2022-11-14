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

    // TODO: 구입금액 입력
    public int inputPurchaseAmount() {
        return lottoService.toPurchaseAmount(Console.readLine());
    }

    //TODO: 당첨 번호 입력
    public Lotto inputWinningNumbers() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    //TODO: 보너스 번호 입력
    public int inputBonusNumber() {
        return 7;
    }
}

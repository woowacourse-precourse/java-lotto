package lotto.controller;

import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.vo.LottoPurchaseInfo;
import lotto.vo.LottoWinNumberInfo;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoService service;

    /**
     * Lotto 게임 동작 수행
     */
    public void runLotto() {
        // 1. 로또 구매
        LottoPurchaseInfo lottoPurchaseInfo = lottoPurchaseController();
        // 2. 당첨 번호 입력
        LottoWinNumberInfo lottoWinNumberInfo = lottoNumbersController();
        // 3. 보너스 번호 입력
        lottoWinNumberInfo = lottoBonusNumberController();

    // 3. 결재한 금액만큼 로또 생성
}

    private LottoPurchaseInfo lottoPurchaseController() {
        LottoPurchaseInfo lottoPurchaseInfo = service.LottoPurchaseServcie();
        return lottoPurchaseInfo;
    }

    private LottoWinNumberInfo lottoNumbersController() {
        LottoWinNumberInfo lottoWinNumberInfo = service.lottoNumbersService();
        return lottoWinNumberInfo;
    }

    private LottoWinNumberInfo lottoBonusNumberController() {
        LottoWinNumberInfo lottoWinNumberInfo = service.lottoBonusNumberService();
        return lottoWinNumberInfo;
    }

    private void CreateLottoNumbers() {

    }


}

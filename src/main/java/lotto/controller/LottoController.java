package lotto.controller;

import java.util.List;
import lotto.service.LottoServiceImpl;
import lotto.vo.Lotto;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.vo.LottoPurchaseInfo;
// import lotto.vo.LottoScore;
import lotto.vo.LottoWinNumberInfo;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoService service = new LottoServiceImpl();

    /**
     * Lotto 게임 동작 수행
     */
    public void runLotto() {
        LottoPurchaseInfo lottoPurchaseInfo = getLottoPurchase();
        LottoWinNumberInfo lottoWinNumberInfo = getInputWinNumbers();
        List<Lotto> lottoNumbers = createLottoNumbers(lottoPurchaseInfo.getLottoGameCount());
        List<String> lottoScore = getLottoRank(lottoNumbers, lottoWinNumberInfo);
    }

    private LottoWinNumberInfo getInputWinNumbers() {
        String lottoWinNumbers = getLottoWinNumbers();
        int lottoBonusNumber = getLottoBonusNumber();

        return new LottoWinNumberInfo(lottoWinNumbers, lottoBonusNumber);
    }

    private LottoPurchaseInfo getLottoPurchase() {
        return service.getLottoPurchase();
    }

    private String getLottoWinNumbers() {
        return service.getLottoWinNumbers();
    }

    private int getLottoBonusNumber() {
        return service.getLottoBonusNumber();
    }

    private List<Lotto> createLottoNumbers(int lottoGameCount) {
        List<Lotto> lottoNumbers = service.createLottoNumbers(lottoGameCount);
        outputView.printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }
    private List<String> getLottoRank(List<Lotto> lottoNumbers, LottoWinNumberInfo lottoWinNumberInfo) {
        return service.getLottoRank(lottoNumbers, lottoWinNumberInfo);
    }
}

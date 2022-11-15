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
        // 1. 로또 구매
        LottoPurchaseInfo lottoPurchaseInfo = getLottoPurchase();
        // 2,3. 당첨 번호, 보너스 번호 입력
        LottoWinNumberInfo lottoWinNumberInfo = getInputWinNumbers();

        // 4. 결재한 금액만큼 로또 생성
        List<Lotto> lottoNumbers = createLottoNumbers(lottoPurchaseInfo.getLottoGameCount());

        // 5. 당첨번호와 생성한 번호를 비교하여 등수를 체크한다.
        List<String> lottoScore = getLottoRank(lottoNumbers, lottoWinNumberInfo);

        // 6. 총 수익률을 출력한다.


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

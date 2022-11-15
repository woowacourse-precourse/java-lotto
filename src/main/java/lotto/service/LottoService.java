package lotto.service;

import lotto.domain.LottoMachine;
import lotto.view.LottoView;

public class LottoService {

    private LottoView lottoView;
    private LottoMachine lottoMachine;

    public LottoService() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
    }

    // 로또 구매하는 기능
    public void buyLotto() throws IllegalArgumentException {
        lottoView.displayInputMoney();
        lottoMachine.inputMoney();
        int lottoCount = lottoMachine.getLottoCount();
        lottoView.displayLottoAmount(lottoCount);
        lottoMachine.buyLottos(lottoCount);
        lottoView.displayMyLottos(lottoMachine.getBuyLottos());
    }

    // 당첨 번호 입력하는 기능
    public void inputWinningNumber() throws IllegalArgumentException {
        lottoView.displayInputWinningNumber();
        lottoMachine.inputWinningNumber();
    }

    // 보너스 번호 입력하는 기능
    public void inputBonusNumber() throws IllegalArgumentException {
        lottoView.displayInputBonusNumber();
        lottoMachine.inputBonusNumber();
    }

    // 당첨 결과 보여주는 기능
    public void showLottoYield() {
        lottoView.displayWinStatsHead();
        int[] lottoResult = lottoMachine.getLottoResult();
        lottoView.displayPrizes(lottoResult);
        lottoView.displayYield(lottoMachine.getYield());
    }
}

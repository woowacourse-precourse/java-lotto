package lotto;

import lotto.domain.Lotto;
import lotto.ui.LottoInput;
import lotto.ui.LottoOutput;

import java.util.List;

public class LottoSimulator {

    private List<Lotto> lotteries;
    private LottoInput lottoInput;
    private LottoOutput lottoOutput;

    public void start(){
        inputPrice();
        inputLottoNumber();
        inputLottoBonusNumber();
        showStatistics();
    }

    private void inputPrice() {
    }

    private void inputLottoNumber() {
    }

    private void inputLottoBonusNumber() {
    }

    private void showStatistics() {
    }
}

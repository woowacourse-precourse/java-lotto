package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoInputDataService {
    private final LottoException lottoException = new LottoException();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public Lotto inputLottoData() {
        String lottoNumbers = inputLottoNumbers();
        String bonusNumber = inputBonusNumber(lottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers, bonusNumber); // 로또 번호 + 보너스 번호 받기
        return lotto;
    }

    public String inputLottoNumbers() {
        outputView.askLottoNumbers();
        String lottoNumbers = inputView.inputLottoNumbersView();
        lottoException.validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public String inputBonusNumber(String lottoNumbers) {
        outputView.askBonusNumber();
        String bonusNumber = inputView.inputBonusNumberView();
        lottoException.validateBonusNumbers(lottoNumbers, bonusNumber);
        return bonusNumber;
    }
}

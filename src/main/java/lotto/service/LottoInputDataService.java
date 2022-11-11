package lotto.service;

import static lotto.util.LottoUtil.bonusNumberParser;
import static lotto.util.LottoUtil.lottoNumbersParser;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoInputDataService {
    private final LottoException lottoException = new LottoException();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public Lotto inputLottoData() {
        List<Integer> lottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();
        return setLotto(lottoNumbers, bonusNumber);
    }

    public Lotto setLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(bonusNumber);
        return lotto;
    }

    public List<Integer> inputLottoNumbers() {
        outputView.askLottoNumbers();
        List<Integer> lottoNumbers = lottoNumbersParser(inputView.inputLottoNumbersView());
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        outputView.askBonusNumber();
        int bonusNumber = bonusNumberParser(inputView.inputBonusNumberView());
        return bonusNumber;
    }
}

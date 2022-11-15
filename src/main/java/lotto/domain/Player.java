package lotto.domain;

import lotto.utils.InputView;
import lotto.utils.OutputView;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.LOTTO_PRICE;

public class Player {

    int lottoCount;
    List<Lotto> lottoNumbers = new ArrayList<>();

    public Player() {
        inputCostForLotto();
        buyLotto();
        printLottoNumber();
    }

    private void inputCostForLotto() {
        OutputView.printPurchaseMessage();
        String input = InputView.getInputValue();
        Validator.validateForIllegalInput(input);
        int cost = Integer.parseInt(input);
        Validator.validateForDividedBy1000(cost);

        lottoCount = cost / LOTTO_PRICE;
    }

    private void buyLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new Lotto(Lotto.createLottoNumber()));
        }
        OutputView.printPurchaseConfirmMessage(lottoCount);
    }

    private void printLottoNumber() {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottoNumbers.get(i).sortLottoNumber();
        }
        OutputView.printLineBreak();
    }
}

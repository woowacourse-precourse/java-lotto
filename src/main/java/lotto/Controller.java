package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoGenerator;
import lotto.model.Player;
import lotto.model.Service;
import lotto.util.Calculator;
import lotto.util.InputVerifier;
import lotto.view.View;

public class Controller {

    Player player = new Player();
    Service service = new Service();

    public String getPurchaseAmount() {
        String purchaseAmount = player.getInput();

        if (!InputVerifier.isInteger(purchaseAmount)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (!InputVerifier.isLottoPrice(purchaseAmount)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }

        return purchaseAmount;
    }

    public int getLottoAmount(String purchaseAmount) {
        return Calculator.countLottoAmount(purchaseAmount);
    }

    private List<List<Integer>> getLottoNumbers(int lottoAmount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            lottoNumbers.add(LottoGenerator.getWinningNumbers());
        }
        return lottoNumbers;
    }

    public List<String> guessLottoNumbers() {
        List<String> lottoNumbers = player.guessLottoNumbers();

        for (String lottoNumber : lottoNumbers) {
            if (!InputVerifier.isInteger(lottoNumber)) {
                View.printNotInteger();
                throw new IllegalArgumentException();
            }
        }

        if (!InputVerifier.isValidSize(lottoNumbers)) {
            View.printNotLottoSize();
            throw new IllegalArgumentException();
        }

        if (!InputVerifier.isUniqueNumber(lottoNumbers)) {
            View.printNotUniqueNumber();
            throw new IllegalArgumentException();
        }

        if (!InputVerifier.isValidNumber(lottoNumbers)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }
        return lottoNumbers;
    }

}

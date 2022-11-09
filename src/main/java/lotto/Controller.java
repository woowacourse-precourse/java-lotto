package lotto;

import java.util.List;
import lotto.model.LottoGenerator;
import lotto.model.Player;
import lotto.model.Service;
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
        return service.getLottoAmount(purchaseAmount);
    }

    private void buyLotto(int lottoAmount) {
        String purchaseAmount = player.getInput();

        for (int i = 0; i < lottoAmount; i++) {
            LottoGenerator.getWinningNumbers();
        }
    }

    // TODO: 구매 정보를 출력하는 기능 구현

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

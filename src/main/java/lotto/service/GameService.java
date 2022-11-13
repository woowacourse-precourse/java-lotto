package lotto.service;

import static lotto.domain.Lotto.makeLottoNumbers;
import static lotto.domain.User.payDividedByUnit;

import java.util.List;
import lotto.domain.GameScore;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.GameInput;
import lotto.view.GamePrint;

public class GameService {

    public GameScore lottoGameStart() {
        User user = getUserLottoListByPay();
        Lotto winLottoNumbers = getWinLottoNumberByUserInput();
        int bonusLottoNumber = getBonusLottoNumberByUserInput();

        return user.getGameScore(winLottoNumbers, bonusLottoNumber);
    }

    private User getUserLottoListByPay() {
        GamePrint.printInputMoney();
        int money = GameInput.inputUserPay();

        List<Lotto> lottos = makeLottoNumbers(payDividedByUnit(money));
        GamePrint.printLottoNumberList(lottos);

        return User.of(money, lottos);
    }

    private Lotto getWinLottoNumberByUserInput() {
        GamePrint.printInputWinLottoNumber();
        List<Integer> numbers = GameInput.inputWinLottoNumbers();
        return Lotto.of(numbers);
    }

    private int getBonusLottoNumberByUserInput() {
        GamePrint.printInputBonusLottoNumber();
        return GameInput.inputBonusLottoNumber();
    }
}

package lotto.service;

import lotto.domain.*;
import lotto.view.GameInput;
import lotto.view.GameMessage;

import java.util.List;

import static lotto.domain.GameView.printProfitRange;
import static lotto.domain.GameView.printWinLottoStats;
import static lotto.domain.Lotto.makeLottoNumbers;


public class LottoService {

    public void startLottoGame() {
        User user = getUserLottoListByPay();
        Lotto userLottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusLottoNumber();
        GameScore score = user.getGameScore(userLottoNumbers, bonusNumber);
        printProfitRange(score.getProfitRate());
        printWinLottoStats(score);
    }

    private User getUserLottoListByPay() {
        GameMessage.printInputMoney();
        int userPay = GameInput.inputUserPay();
        int lottoCount = getLottoCount(userPay);
        List<Lotto> lotto = makeLottoNumbers(lottoCount);
        return User.of(userPay, lotto);
    }

    private static int getLottoCount(int money) {
        int change = 0;
        change = money / 1000;
        GameMessage.printLottoCount(change);
        return change;
    }

    private static Lotto inputLottoNumbers() {
        GameMessage.printInputLottoNumbers();
        List<Integer> answer = GameInput.inputLottoNumbers();
        return Lotto.of(answer);
    }

    private static int inputBonusLottoNumber() {
        GameMessage.printInputBonusLottoNumber();
        int bonusNumber = GameInput.inputBonusLottoNumber();
        return bonusNumber;
    }
}

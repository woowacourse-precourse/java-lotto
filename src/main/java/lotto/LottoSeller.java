package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import ui.View;
import user.NumberValidator;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private final int LOTTO_NUMBER_SIZE = 6;
    private final int LOTTO_NUMBER_MIN = 1;
    private final int LOTTO_NUMBER_MAX = 45;
    private final boolean NOT_HAVE = false;
    private Lotto winningLotto;
    private Integer bonus;

    private Lotto makeLotto() {
        List lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    public void giveLottos(User user) {
        while (user.getLottoMount() != user.getLottos().size()) {
            user.addLottos(makeLotto());
        }
    }

    public void lottoDraw() {
        makeWinningLottos();
        makeBonusNumber();
    }

    private void makeWinningLottos() {
        String lottoNumbers = NumberValidator.makeLotto();
        winningLotto = new Lotto(lottoNumbers);
    }

    private void makeBonusNumber() {
        int bonus = NumberValidator.makeLottoNumber();
        validateBonusNotInLotto(bonus);
        this.bonus = bonus;
    }

    private void validateBonusNotInLotto(int bonus) {
        if (winningLotto.hasLottoNumber(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private int winnigCheck(Lotto userLotto) {
        int correctCount = winningLotto.compareLotto(userLotto);
        if (correctCount == 5 && userLotto.hasLottoNumber(bonus)) {
            correctCount++;
        } else if (correctCount == 6) {
            correctCount++;
        }
        return correctCount;
    }

    private List<Integer> winningCount(User user) {
        List<Integer> winningCount = new ArrayList<Integer>(List.of(0, 0, 0, 0, 0));
        int index = 0;
        for (Lotto lotto : user.getLottos()) {
            index = winnigCheck(lotto) - 3;
            if (index >= 0) {
                winningCount.set(index, winningCount.get(index) + 1);
            }
        }
        View.printWinnigSummary(winningCount);
        return winningCount;
    }

    private long prizeCalculate(List<Integer> winningCount) {
        long result = 0;
        for (int i = 0; i < winningCount.size(); i++) {
            result += Prize.getPrizeValue(i + 3, winningCount.get(i));
        }
        return result;
    }

    public void givePrize(User user) {
        long prize = prizeCalculate(winningCount(user));
        user.setPrizeMoney(prize);
    }
}


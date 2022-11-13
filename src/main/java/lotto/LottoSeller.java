package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import ui.View;
import user.Money;
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
        user.setLottos(makeUserLottos(user.getLottoMount()));
    }

    private List<Lotto> makeUserLottos(int mount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        List<String> duplicateCheckList = new ArrayList<>();
        Lotto lotto;
        while (purchasedLottos.size() < mount) {
            lotto = makeLotto();
            if (duplicateCheckList.contains(lotto.toNumberForm()) == NOT_HAVE) {
                purchasedLottos.add(lotto);
                duplicateCheckList.add(lotto.toNumberForm());
            }
        }
        return purchasedLottos;
    }

    public void lottoDraw() {
        makeWinningLottos();
        makeBonusNumber();
    }

    private void makeWinningLottos() {
        View.promptWinningNumber();
        String lottoNumbers = Console.readLine();
        winningLotto = new Lotto(lottoNumbers);
    }

    private void makeBonusNumber() {
        View.promptBonusNUmber();
        String bonus = Console.readLine();
        validateBonus(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateBonus(String bonus) {
        validateBonusNull(bonus);
        validateBonusLength(bonus);
        validateBonusOutRange(bonus);
        validateBonusNotInLotto(bonus);
    }

    private void validateBonusNull(String bonus) {
        if (bonus == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusLength(String bonus) {
        if (bonus.length() > 2 || bonus.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusOutRange(String bonus) {
        if (bonus.charAt(0) < '1' || bonus.charAt(0) > '9') {
            throw new IllegalArgumentException();
        }
        if (bonus.length() == 2) {
            if (bonus.charAt(0) > '4' || bonus.charAt(1) < '0' || bonus.charAt(1) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBonusNotInLotto(String bonus) {
        int bonusNumber = Integer.parseInt(bonus);
        if (winningLotto.hasBonus(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private int winnigCheck(Lotto userLotto) {
        int correctCount = winningLotto.compareLotto(userLotto);
        if (correctCount == 5 && userLotto.hasBonus(bonus)) {
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

    private int prizeCalculate(List<Integer> winningCount) {
        int result = 0;
        int[] prize = {5000, 50000, 1500000, 30000000, 2000000000};
        for (int i = 0; i < winningCount.size(); i++) {
            result += winningCount.get(i) * prize[i];
        }
        return result;
    }

    public void givePrize(User user) {
        int prize = prizeCalculate(winningCount(user));
        user.setPrizeMoney(new Money(prize));
    }
}

package lotto;

import static Constant.ErrorMessage.LOTTO_DUPLICATE;
import static Constant.ErrorMessage.OUT_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class WinningNumber {

    Lotto lotto;
    Integer bonus;
    Utils util = new Utils();
    List<Integer> result;
    UserInterface userInterface = new UserInterface();

    public List<Integer> getWinningNumber() {
        userInterface.printEnterWinningNumber();
        result = getNumbers(Console.readLine());
        lotto = new Lotto(result);

        userInterface.printEnterBonusNumber();
        bonus = util.isNumeric(Console.readLine());
        validateBonus();

        return result;
    }

    List<Integer> getNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        String[] split = input.split(",");

        for (String number : split) {
            result.add(util.isNumeric(number));
        }
        return result;
    }

    private void validateBonus() {
        validateDuplication();
        validateRange();
    }

    private void validateDuplication() {
        if (lotto.isHitted(bonus)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE);
        }
    }

    private void validateRange() {
        if (util.invalidRange(bonus)) {
            throw new IllegalArgumentException(OUT_RANGE);
        }
    }

    Rank match(Lotto userLotto) {
        int countMatched = userLotto.countMatchedNumber(lotto);
        boolean bonusMatched = userLotto.isHitted(bonus);

        return rank(countMatched, bonusMatched);
    }

    private Rank rank(int countMatched, boolean bonusMatched) {
        if (countMatched == 6) {
            return Rank.FIRST;
        } else if (countMatched == 5) {
            return isSecondThird(bonusMatched);
        } else if (countMatched == 4) {
            return Rank.FOURTH;
        } else if (countMatched == 3) {
            return Rank.FIFTH;
        }
        return Rank.NOTHING;
    }

    private Rank isSecondThird(boolean bonusMatched){
        if (bonusMatched) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}

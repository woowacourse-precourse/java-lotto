package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 구현 목록 - 로또 번호와 보너스 번호를 받아 하나의 객체로 만들어주는 클래스!
 * 1. 로또 6자리 받기
 * 2. 보너스 번호 받기
 * 3. 번호 받은 것들은 필드로 저장하기
 * 4. 로또 + 보너스가 유효한지 검사
 * 5. 보너스가 범위 안의 숫자인지 검사
 */

public class WinningNumber {

    private Lotto lotto;
    private Integer bonus;

    public List<Integer> getWinningNumber() {
        List<Integer> result = new ArrayList<>();

        String input = Console.readLine();
        String[] split = input.split(",");
        for (String number : split) {
            result.add(Integer.parseInt(number));
        }

        lotto = new Lotto(result);
        bonus = Integer.parseInt(Console.readLine());

        validateLotto();

        return result;
    }

    private void validateLotto() {
        validateDuplication();
        validateRange();
    }

    private void validateDuplication() {
        if (lotto.hasNumber(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange() {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }
    }

    Rank match(Lotto userLotto) {
        int countMatched = userLotto.countMatchedNumber(lotto);
        boolean bonusMatched = userLotto.hasNumber(bonus);

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
        return Rank.NONE;
    }

    private Rank isSecondThird(boolean bonusMatched){
        if (bonusMatched) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}

package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {


    public static void main(String[] args) {
        List<Integer> numbers = makeLottoNumbers();
        Lotto lotto = new Lotto(numbers);

        int bonusNumber = makeLottoBonusNumber();
        lotto.validateBonus(bonusNumber);

    }

    private static int makeLottoBonusNumber() {
        return pickNumberInRange(1, 45);
    }

    private static List<Integer> makeLottoNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}

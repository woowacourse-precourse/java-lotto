package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.Winning.*;

public class Util {
    // 로또 당첨 확인 로직
    public void ConfirmationOfTheWinner(List<Buyer> userLottos, Lotto lottoNums, int bonusNumber) {
        // 몇 개나 일치하는지 확인
        for (Buyer user : userLottos) {
            List<Integer> matchNumber = user.userNumber.stream()
                    .filter(number -> lottoNums.getNumbers().stream()
                            .anyMatch(Predicate.isEqual(number)))
                    .collect(Collectors.toList());
            int match = matchNumber.size();
            setWinningCount(bonusNumber, user.userNumber, match);
        }
    }
    // 당첨된 로또 갯수 확인
    public void setWinningCount(int bonusNumber, List<Integer> userNumber, int match) {
        if (match == 3) {
            FIFTH_PLACE.setCount(FIFTH_PLACE.getCount() + 1);
            return;
        }

        if (match == 4) {
            FOURTH_PLACE.setCount(FOURTH_PLACE.getCount() + 1);
            return;
        }

        if (match == 5) {
            if (userNumber.contains(bonusNumber)) {
                SECOND_PLACE.setCount(SECOND_PLACE.getCount() + 1);
                return;
            }
            THIRD_PLACE.setCount(THIRD_PLACE.getCount() + 1);
            return;
        }

        if (match == 6) {
            FIRST_PLACE.setCount(FIRST_PLACE.getCount() + 1);
        }
    }
}

package lotto;

import java.util.List;
import java.util.stream.Collectors;
import static lotto.LottoConst.LOTTO_MAX_NUMBER;

public class Error {
    static void purchasePrice(int purchasePrice) {
        if (purchasePrice % LottoConst.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 정확히 입력 해 주세요. 금액 : " + purchasePrice);
        }
    }

    static void duplicationWinnigNumber(List<Integer> winnigNumber) {
        List<Integer> removedDuplicationNumber =
                winnigNumber.stream()
                        .distinct()
                        .collect(Collectors.toList());

        if (removedDuplicationNumber.size() != LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 있습니다.");
        }
    }

    static void containBonusInWinningNumber(List<Integer> winningNumber,int Bonus) {
        if (winningNumber.contains(Bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 안에 중복된 보너스번호가 있습니다.");
        }
    }

    static void sizeWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != LottoConst.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또번호의 개수가 유효하지 않습니다.");
        }
    }
}

package lotto;

import java.util.List;
import java.util.stream.Collectors;
import static lotto.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.LottoConst.LOTTO_NUMBER_COUNT;
import static lotto.LottoConst.LOTTO_PRICE;

public class Error {
    static void purchasePrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 정확히 입력 해 주세요. 금액 : " + purchasePrice);
        }
    }

    static void duplicationWinningNumber(List<Integer> winnigNumber) {
        List<Integer> removedDuplicationNumber =
                winnigNumber.stream()
                        .distinct()
                        .collect(Collectors.toList());

        if (removedDuplicationNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 있습니다.");
        }
    }

    static void containBonusInWinningNumber(List<Integer> winningNumber,int Bonus) {
        if (winningNumber.contains(Bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 안에 중복된 보너스번호가 있습니다.");
        }
    }

    static void sizeWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또번호의 개수가 유효하지 않습니다.");
        }
    }

    static void rangeWinningNumber(List<Integer> winningNumber) {
        long validRangeNumberCount = winningNumber.stream()
                .filter(number -> number >= LOTTO_MIN_NUMBER)
                .filter(number -> number <= LOTTO_MAX_NUMBER)
                .count();

        if (validRangeNumberCount != LottoConst.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호가 있습니다.");
        }
    }

    static boolean checkTextError(String userAnswer)  throws IllegalArgumentException {
        try{
            Integer.parseInt(userAnswer);
            return true;
        } catch (Exception e) {
            System.out.println("[ERROR] 유효하지 않은 입력입니다.");
            throw new IllegalArgumentException();
        }
    }
}

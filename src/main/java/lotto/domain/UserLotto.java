package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Judgment.checkBonusCorrect;
import static lotto.domain.Judgment.getCorrectLottoNumberCount;
import static lotto.domain.Preprocessor.convertStringToInt;

public class UserLotto {
    private final int lottoAmount;

    public UserLotto(String lottoAmount) throws IllegalArgumentException {
        validateIsNumeric(lottoAmount);
        int tmpLottoAmount = convertStringToInt(lottoAmount);
        validateCanDivideThousand(tmpLottoAmount);
        this.lottoAmount = tmpLottoAmount;
    }

    private void validateIsNumeric(String lottoAmount) throws IllegalArgumentException {
        for (char c : lottoAmount.toCharArray()) {
            if (!(0 <= c - '0' && c - '0' <= 9)) {
                throw new IllegalArgumentException("[ERROR] 복권 구입 금액은 양의 정수 형태이어야 합니다.");
            }
        }
    }

    private void validateCanDivideThousand(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 복권 구입 금액은 1000 으로 나누어 떨어져야 합니다.");
        }
    }

    public static List<Integer> createLottoResult(List<Lotto> lottos,
                                                  List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lottoResult = new ArrayList<>(List.of(0, 0, 0, 0, 0)); // 1등, 2등 ... 5등
        for (Lotto lotto : lottos) {
            int matchingCount = getCorrectLottoNumberCount(lotto, winningNumbers);
            boolean bonusMatching = checkBonusCorrect(bonusNumber, lotto.getLotto());
            Prize prize = Prize.getPrize(matchingCount, bonusMatching);
            int resultIndex = prize.ordinal();

            if (!prize.equals(Prize.NONE)) { // 꽝은 결과에 필요없음
                lottoResult.set(resultIndex, lottoResult.get(resultIndex) + 1);
            }
        }
        return lottoResult;
    }

    public int getLottoCount() {
        return (this.lottoAmount / 1000);
    }

    public double getRateOfReturn(List<Integer> lottoResult) {
        int total = 0;

        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                total += prize.getPrizeMoney() * lottoResult.get(prize.ordinal());
            }
        }
        return (total / (double) lottoAmount) * 100;
    }
}

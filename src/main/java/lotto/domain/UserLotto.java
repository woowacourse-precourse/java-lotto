package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Judgment.*;


public class UserLotto {
    private final int lottoAmount;

    public UserLotto(String lottoAmount) {
        validateIsNumeric(lottoAmount);

        int tmpLottoAmount = Preprocessor.convertStringToInt(lottoAmount);

        validateCanDivideThousand(tmpLottoAmount);

        this.lottoAmount = tmpLottoAmount;
    }

    public int getLottoCount() {
        return (this.lottoAmount / 1000);
    }

    private void validateIsNumeric(String lottoAmount) {
        for(char c : lottoAmount.toCharArray()) {
            if (!(0 <= c - '0' && c - '0' <= 9)) {
                System.out.println("[ERROR} 복권 구입 금액은 양의 정수 형태이어야 합니다.");
                throw new IllegalArgumentException("[ERROR] 잘못된 형식의 복권 구입 금액");
            }
        }
    }

    private void validateCanDivideThousand(int lottoAmount) {
        if (lottoAmount % 1000 != 0) {
            System.out.println("[ERROR} 복권 구입 금액은 1000 으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 구입 금액");
        }
    }

    public static List<Integer> createLottoResult(List<Lotto> boughtLotto,
                                                  List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lottoResult = new ArrayList<>(List.of(0,0,0,0,0)); // 1등, 2등 ... 5등
        for (Lotto lotto : boughtLotto) {
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

    public double getRateOfReturn(List<Integer> lottoResult) {
        int total = 0;
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                break;
            }
            total += prize.getPrizeMoney() * lottoResult.get(prize.ordinal());
        }
        return (total / (double) lottoAmount) * 100;
    }
}

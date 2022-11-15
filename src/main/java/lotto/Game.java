package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.Input;

public class Game {
    public static final int LOTTO_PRICE = 1000;
    public static final int FIRST_RANK = 1;
    public static final int SECOND_RANK = 2;
    public static final int THIRD_RANK = 3;
    public static final int FOURTH_RANK = 4;
    public static final int FIFTH_RANK = 5;
    public static final int NO_RANK = 0;
    public static LottoPrize lottoPrize;

    private Lotto winLotto;
    private int bonusNumber;

    public void setWinLotto() {
        winLotto = new Lotto(Input.inputWinLottoNumbers());
        bonusNumber = Input.inputWinLottoBonusNumber();
    }

    public int getLottoPrize(String rank) {
        int lottoPrize = LottoPrize.valueOf(rank).getLottoPrize();
        return lottoPrize;
    }

    public void saveScoreResult(Person person) {// 각 등수별 당첨 수 저장
        List<Lotto> userLottos = person.getLottos();
        List<Integer> result = person.getLottoScoreResult().winScoreList;
        int rank;
        int count;
        for (Lotto userLotto : userLottos) {
            rank = calculateRank(userLotto);
            count = result.get(rank);
            count++;
            result.add(rank, count);
        }
    }

    public int calculateRank(Lotto lotto) {
        int correctNumbersCount = countCorrectNumbers(lotto);
        if (correctNumbersCount == 6) {//1등
            return FIRST_RANK;
        }
        if (correctNumbersCount == 5) {
            return secondOrThirdRank(lotto);
        }
        if (correctNumbersCount == 4) {
            return FOURTH_RANK;
        }
        if (correctNumbersCount == 3) {
            return FIFTH_RANK;
        }
        return NO_RANK;
    }

    public int countCorrectNumbers(Lotto lotto) {
        int countCorrectNumbers = 0;
        countCorrectNumbers = (int) lotto.getNumbers().stream()
                .filter(number -> winLotto.getNumbers().contains(number))
                .count();
        return countCorrectNumbers;
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int secondOrThirdRank(Lotto lotto) {
        if (hasBonusNumber(lotto)) {
            return SECOND_RANK;
        }
        return THIRD_RANK;
    }
}


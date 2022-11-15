package lotto.domain;

import static lotto.domain.constant.WinningStatisticsValueConstant.MATCHED_FIVE_AND_BONUS_BALL;
import static lotto.domain.constant.WinningStatisticsValueConstant.MATCHED_SIX;
import static lotto.domain.constant.WinningStatisticsValueConstant.NOTHING;
import static lotto.domain.constant.WinningStatisticsValueConstant.values;

import java.util.Arrays;
import java.util.Objects;

public class Result {

    private Integer correctNumber;

    private boolean existenceBonusNumber;
    private Integer ranking;

    public Result(Integer correctNumber, boolean existenceBonusNumber) {
        this.correctNumber = correctNumber;
        this.existenceBonusNumber = existenceBonusNumber;
        rank();
    }

    public Integer getCorrectNumber() {
        return correctNumber;
    }

    public boolean isExistenceBonusNumber() {
        return existenceBonusNumber;
    }

    public Integer getRanking() {
        return ranking;
    }

    private void rank() {
        if (Objects.equals(this.correctNumber, MATCHED_SIX.getNumber()) && this.isExistenceBonusNumber()) {
            this.ranking = MATCHED_FIVE_AND_BONUS_BALL.getNumber();

            return;
        }

        this.ranking = Arrays.stream(values())
                             .filter(i -> i.getNumber().equals(this.correctNumber))
                             .findFirst()
                             .orElse(NOTHING)
                             .getRanking();
    }

}

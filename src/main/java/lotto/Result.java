package lotto;

import java.util.Objects;

public class Result {
    private int matchCount = 0;
    private boolean hasBonusNumber = false;
    private ResultStatus resultStatus;

    protected Result(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        setResultStatus();
    }

    public Result(WinLotto winLotto, Lotto generatedLotto) {
        for (Integer number : generatedLotto.getNumbers()) {
            setMatchCount(winLotto, number);
        }
        setHasBonusNumber(winLotto, generatedLotto);
        setResultStatus();
    }

    private void setMatchCount(WinLotto winLotto, Integer number) {
        if (winLotto.getNumbers().contains(number)) {
            this.matchCount++;
        }
    }

    private void setHasBonusNumber(WinLotto winLotto, Lotto generatedLotto) {
        if (generatedLotto.getNumbers().contains(winLotto.bonusNumber)) {
            this.hasBonusNumber = true;
        }
    }

    private void setResultStatus() {
        if (matchCount == ResultStatus.MATCH6.getCount()) {
            this.resultStatus = ResultStatus.MATCH6;
            return;
        }
        if (matchCount == ResultStatus.MATCH5_WITH_BONUS_BALL.getCount() &&
                hasBonusNumber == ResultStatus.MATCH5_WITH_BONUS_BALL.isHasBonusBall()) {
            this.resultStatus = ResultStatus.MATCH5_WITH_BONUS_BALL;
            return;
        }
        if (matchCount == ResultStatus.MATCH5.getCount()) {
            this.resultStatus = ResultStatus.MATCH5;
            return;
        }
        if (matchCount == ResultStatus.MATCH4.getCount()) {
            this.resultStatus = ResultStatus.MATCH4;
            return;
        }
        if (matchCount == ResultStatus.MATCH3.getCount()) {
            this.resultStatus = ResultStatus.MATCH3;
            return;
        }
        this.resultStatus = ResultStatus.NONE;
    }

    public ResultStatus getResultStatus() {
        return this.resultStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return matchCount == result.matchCount && hasBonusNumber == result.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, hasBonusNumber);
    }
}

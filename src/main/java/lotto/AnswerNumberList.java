package lotto;

import java.util.List;

public class AnswerNumberList {
    private final List<Long> winningNumbers;
    private final Long bonusNumber;

    public AnswerNumberList(List<Long> answerNumbers, Long bonusNumber) {
        this.winningNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void checkRangeOfNumber(Long number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 안의 수가 아닙니다.");
        }
    }

    private void validate() {
        this.winningNumbers.forEach(this::checkRangeOfNumber);
        checkRangeOfNumber(bonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 목록에 보너스 번호가 있습니다.");
        }
    }

}

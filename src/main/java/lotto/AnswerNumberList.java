package lotto;

import java.util.List;

public class AnswerNumberList {
    private final List<Long> winningNumbers;
    private final Long bonusNumber;

    public AnswerNumberList(List<Long> answerNumbers, Long bonusNumber) {
        this.winningNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }
}

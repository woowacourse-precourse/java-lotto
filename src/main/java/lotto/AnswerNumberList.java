package lotto;

import java.util.ArrayList;
import java.util.List;

public class AnswerNumberList {
    private final List<Long> answerNumbers;
    private Long bonusNumber;

    public AnswerNumberList(List<Long> answerNumbers, Long bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }
}

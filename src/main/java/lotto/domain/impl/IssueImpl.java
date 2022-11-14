package lotto.domain.impl;

import lotto.Lotto;
import lotto.domain.Issue;

import java.util.List;

import static lotto.message.ExceptionMessage.AMOUNT_EXCEPTION;

public class IssueImpl implements Issue {

    //예외
    //1. 금액이 1,000원으로 나누어 떨어지지 않는 경우
    @Override
    public List<Lotto> createLotto(int amount) {
        validate(amount);
        return null;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }
}

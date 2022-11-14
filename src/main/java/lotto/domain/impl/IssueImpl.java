package lotto.domain.impl;

import lotto.Lotto;
import lotto.domain.Issue;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;
import static lotto.message.ExceptionMessage.AMOUNT_EXCEPTION;

public class IssueImpl implements Issue {

    private final NumberGenerator numberGenerator = new NumberGeneratorImpl();

    //예외
    //1. 금액이 1,000원으로 나누어 떨어지지 않는 경우
    @Override
    public List<Lotto> createLotto(int amount) {
        validate(amount);
        int count = amount / LOTTO_PRICE;

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = numberGenerator.createRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            result.add(lotto);
        }
        return result;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }
}

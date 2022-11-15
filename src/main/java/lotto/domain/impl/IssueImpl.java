package lotto.domain.impl;

import lotto.Lotto;
import lotto.domain.Issue;
import lotto.domain.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Constants.*;
import static lotto.message.ExceptionMessage.AMOUNT_EXCEPTION;

public class IssueImpl implements Issue {

    private final NumberGenerator numberGenerator = new NumberGeneratorImpl();

    @Override
    public List<Lotto> createLottos(int amount) {
        int lottoIssueCount = getLottoIssueCount(amount);

        return IntStream.range(0, lottoIssueCount)
                .mapToObj(i -> numberGenerator.createRandomNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private int getLottoIssueCount(int amount) {
        validate(amount);
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        zeroValidate(amount);
        amountValidate(amount);
    }

    private void zeroValidate(int amount) {
        if (isZero(amount)) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }

    private boolean isZero(int amount) {
        return amount == 0;
    }

    private void amountValidate(int amount) {
        if (!isMultipleOfLottoPrice(amount)) {
            throw new IllegalArgumentException(AMOUNT_EXCEPTION);
        }
    }

    private boolean isMultipleOfLottoPrice(int amount) {
        return amount % LOTTO_PRICE == 0;
    }
}

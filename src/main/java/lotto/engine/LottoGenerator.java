package lotto.engine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.error.Error;
import lotto.model.Lotto;

public class LottoGenerator {
    private static final int MINIMUM_LOTTO_COUNT = 1;
    private static final int AMOUNT_UNIT = 1_000;
    private static final int AMOUNT_LIMIT = 100_000;

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottos(int count) {
        if (count < MINIMUM_LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }

        return Stream.generate(() -> new Lotto(numberGenerator.generate()))
                .limit(count)
                .collect(Collectors.toList());
    }

    public int parseToLottoCount(String purchasePrice) {
        if (purchasePrice == null || purchasePrice.isEmpty()) {
            throw new IllegalArgumentException(Error.PRICE_EMPTY_INPUT_ERROR.getMessage());
        }
        businessValidate(purchasePrice);

        return Integer.parseInt(purchasePrice) / AMOUNT_UNIT;
    }

    private void businessValidate(String purchasePrice) {
        if (!purchasePrice.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Error.NOT_DIGIT_ERROR.getMessage());
        }

        int limitNumberLength = (int) Math.log10(AMOUNT_LIMIT) + 1;
        if (purchasePrice.length() > limitNumberLength
                || Integer.parseInt(purchasePrice) > AMOUNT_LIMIT
                || Integer.parseInt(purchasePrice) < AMOUNT_UNIT) {
            throw new IllegalArgumentException(Error.AMOUNT_RANGE_ERROR.getMessage());
        }

        if (Integer.parseInt(purchasePrice) % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(Error.DIVIDE_UNIT_ERROR.getMessage());
        }
    }
}

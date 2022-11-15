package lotto.engine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Lotto;

public class LottoGenerator {
    private static final int MINIMUM_LOTTO_COUNT = 1;
    private static final int AMOUNT_UNIT = 1_000;
    private static final int AMOUNT_LIMIT = 100_000;
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "금액을 입력하세요";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "금액은 숫자로 입력하세요.";
    private static final String DIVIDE_UNIT_ERROR_MESSAGE = "금액은 1,000원 단위로 입력하세요.";
    private static final String AMOUNT_RANGE_ERROR_MESSAGE = "금액은 100,000원 이하 1000원 이상으로 입력하세요.";

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
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
        businessValidate(purchasePrice);

        return Integer.parseInt(purchasePrice) / AMOUNT_UNIT;
    }

    private void businessValidate(String purchasePrice) {
        if (!purchasePrice.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_DIGIT_ERROR_MESSAGE);
        }

        int limitNumberLength = (int) Math.log10(AMOUNT_LIMIT) + 1;
        if (purchasePrice.length() > limitNumberLength
                || Integer.parseInt(purchasePrice) > AMOUNT_LIMIT
                || Integer.parseInt(purchasePrice) < AMOUNT_UNIT) {
            throw new IllegalArgumentException(AMOUNT_RANGE_ERROR_MESSAGE);
        }

        if (Integer.parseInt(purchasePrice) % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(DIVIDE_UNIT_ERROR_MESSAGE);
        }
    }
}

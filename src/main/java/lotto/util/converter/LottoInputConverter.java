package lotto.util.converter;

import lotto.util.ConstValue.LottoConst;
import lotto.util.Validator;

import java.util.List;

import static lotto.exception.ExceptionType.*;
import static lotto.util.converter.LottoInputConverter.LottoInputValidator.*;

public class LottoInputConverter {

    private final static String LOTTO_MAIN_NUMBER_INPUT_PATTERN =
            String.format("^[0-9]+(,[0-9]+){5}");

    private final static String LOTTO_BONUS_NUMBER_INPUT_PATTERN =
            String.format("^[0-9]+");

    private final static String USER_BUY_MONEY_PATTERN =
            String.format("^[0-9]+");

    private final Converter<String, List<Integer>> stringToIntListConverter;
    private final Converter<String, Integer> stringToIntConverter;

    public LottoInputConverter() {
        stringToIntListConverter = new StringToIntListConverter(LottoConst.LOTTO_MAIN_NUMBER_DELIMETER);
        stringToIntConverter = new StringToIntConverter();
    }

    public int userLottoPurchaseCostToInt(final String input) {
        final List<Validator<String>> validators =
                List.of(
                        LOTTO_INPUT_NULL.validator,
                        LOTTO_INPUT_USER_PURCHASE_COST.validator
                );
        return stringToIntConverter.convert(input, validators);
    }

    public List<Integer> winningLottoNumberToList(final String input) {
        final List<Validator<String>> validators =
                List.of(
                        LOTTO_INPUT_NULL.validator,
                        LOTTO_INPUT_WINNING_NUMBER.validator
                );
        return stringToIntListConverter.convert(input, validators);
    }

    public int bonusLottoNumberToInt(final String input) {
        final List<Validator<String>> validators =
                List.of(
                        LOTTO_INPUT_NULL.validator,
                        LOTTO_INPUT_BONUS_NUMBER.validator
                );
        return stringToIntConverter.convert(input, validators);
    }

    public enum LottoInputValidator {

        LOTTO_INPUT_NULL((String input) -> {
            if (input == null) {
                throw new IllegalArgumentException(NULL_INPUT.getMessage());
            }
        }),

        LOTTO_INPUT_USER_PURCHASE_COST((String input) -> {
            if (!input.matches(USER_BUY_MONEY_PATTERN)) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }),

        LOTTO_INPUT_WINNING_NUMBER((String input) -> {
            if (!input.matches(LOTTO_MAIN_NUMBER_INPUT_PATTERN)) {
                throw new IllegalArgumentException(WINNING_LOTTO_NUMBER_INPUT_PATTERN_NOT_MATCH.getMessage());
            }
        }),

        LOTTO_INPUT_BONUS_NUMBER((String input) -> {
            if (!input.matches(LOTTO_BONUS_NUMBER_INPUT_PATTERN)) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }),
        ;

        private final Validator<String> validator;

        LottoInputValidator(final Validator<String> validator) {
            this.validator = validator;
        }
    }
}

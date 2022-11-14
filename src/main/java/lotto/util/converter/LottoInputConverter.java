package lotto.util.converter;

import lotto.util.ConstValue.LottoConst;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

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
        final List<Validator<String>> validators = new ArrayList<>();
        return stringToIntConverter.convert(input, validators);
    }

    public List<Integer> winningLottoNumberToList(final String input) {
        final List<Validator<String>> validators = new ArrayList<>();
        return stringToIntListConverter.convert(input, validators);
    }

    public int bonusLottoNumberToInt(final String input) {
        final List<Validator<String>> validators = new ArrayList<>();
        return stringToIntConverter.convert(input, validators);
    }
}

package lotto.util.converter;

import lotto.util.ConstValue.LottoConst;

import java.util.List;

public class LottoInputConverter {

    private final Converter<String, List<Integer>> stringToIntListConverter;
    private final Converter<String, Integer> stringToIntConverter;

    public LottoInputConverter() {
        stringToIntListConverter = new StringToIntListConverter(LottoConst.LOTTO_MAIN_NUMBER_DELIMETER);
        stringToIntConverter = new StringToIntConverter();
    }
}

package lotto.Lotto;

import lotto.LottoNumberValidator;
import lotto.Message;

import java.util.*;

public class Lotto {
    private final List<Integer> lottoNumbers;
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer START_LOTTO_NUMBER = 1;
    public static final Integer END_LOTTO_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.lottoNumbers = numbers;
    }

    public boolean isContain(Integer lottoNumber)
    {
        return lottoNumbers.contains(lottoNumber);
    }

    public Integer get(int index)
    {
        return lottoNumbers.get(index);
    }

    @Override
    public String toString()
    {
        return lottoNumbers.toString();
    }

}

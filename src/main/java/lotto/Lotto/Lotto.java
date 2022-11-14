package lotto.Lotto;

import lotto.LottoNumberValidator;

import java.util.*;

public class Lotto {
    private final List<Integer> lottoNumbers;
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

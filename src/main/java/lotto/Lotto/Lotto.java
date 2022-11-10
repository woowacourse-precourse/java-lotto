package lotto.Lotto;

import lotto.Message;

import java.util.*;

public class Lotto {
    private final List<Integer> lottoNumbers;
    public static final Integer LOTTO_SIZE = 6;
    public static final Integer START_LOTTO_NUMBER = 1;
    public static final Integer END_LOTTO_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidation(numbers);
        lottoNumberInBoundValidation(numbers);
        duplicationValidation(numbers);
    }

    private void lottoSizeValidation(List<Integer> numbers)
    {
        if (numbers.size() != LOTTO_SIZE)
        {
            throw new IllegalArgumentException(Message.getLottoSizeErrorMessage());
        }
    }

    private void lottoNumberInBoundValidation(List<Integer> numbers)
    {
        for(int lottoNumber : numbers)
        {
            if(isOutOfBound(lottoNumber))
            {
                throw new IllegalArgumentException(
                        Message.getLottoNumberOutOfBoundErrorMessageBody());
            }
        }
    }

    protected boolean isOutOfBound(Integer lottoNumber)
    {
        if(lottoNumber < START_LOTTO_NUMBER || END_LOTTO_NUMBER < lottoNumber)
        {
            return true;
        }

        return false;
    }

    private void duplicationValidation(List<Integer> numbers)
    {
        Set<Integer> lottoNumberGroup = new HashSet<>(numbers);

        if(lottoNumberGroup.size() != numbers.size())
        {
            throw new IllegalArgumentException(
                    Message.getLottoNumberDuplicationErrorMessage());
        }
    }

    @Override
    public String toString()
    {
        return lottoNumbers.toString();
    }

}

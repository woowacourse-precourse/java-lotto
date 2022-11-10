package lotto;

import lotto.Lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validate(List<Integer> numbers) {
        lottoSizeValidation(numbers);
        lottoNumberInBoundValidation(numbers);
        duplicationValidation(numbers);
    }

    public static void lottoSizeValidation(List<Integer> numbers)
    {
        if (numbers.size() != Lotto.LOTTO_SIZE)
        {
            throw new IllegalArgumentException(Message.getLottoSizeErrorMessage());
        }
    }

    public static void lottoNumberInBoundValidation(List<Integer> numbers)
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

    public static boolean isOutOfBound(Integer lottoNumber)
    {
        if(lottoNumber < Lotto.START_LOTTO_NUMBER || Lotto.END_LOTTO_NUMBER < lottoNumber)
        {
            return true;
        }

        return false;
    }

    public static void duplicationValidation(List<Integer> numbers)
    {
        Set<Integer> lottoNumberGroup = new HashSet<>(numbers);

        if(lottoNumberGroup.size() != numbers.size())
        {
            throw new IllegalArgumentException(
                    Message.getLottoNumberDuplicationErrorMessage());
        }
    }



}

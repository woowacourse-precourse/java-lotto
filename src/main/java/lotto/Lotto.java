package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private static final Integer LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidation(numbers);
        duplicationValidation(numbers);
    }

    private void lottoSizeValidation(List<Integer> numbers)
    {
        if (numbers.size() != LOTTO_SIZE)
        {
            throw new IllegalArgumentException(Message.getLottoSizeErrorMessage());
        }
    }

    private void duplicationValidation(List<Integer> numbers)
    {
        Set<Integer> lottoNumberGroup = new HashSet<>();

        for(int lottoNumber : numbers)
        {
            if(lottoNumberGroup.contains(lottoNumber))
            {
                throw new IllegalArgumentException(Message.getLottoNumberDuplicationErrorMessage());
            }

            lottoNumberGroup.add(lottoNumber);
        }
    }

}

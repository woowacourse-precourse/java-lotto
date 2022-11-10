package lotto.Lotto;

import lotto.LottoNumberValidator;
import lotto.Message;

import java.util.List;

public class WinningLotto extends Lotto {
    private final Integer specialNumber;

    public WinningLotto(List<Integer> numbers,Integer specialNumber)
    {
        super(numbers);
        specialNumberInBoundValidation(specialNumber);
        specialNumberDuplicationValidate(numbers,specialNumber);
        this.specialNumber = specialNumber;
    }

    private void specialNumberInBoundValidation(Integer specialNumber)
    {
        if(LottoNumberValidator.isOutOfBound(specialNumber)) {
            throw new IllegalArgumentException(
                    Message.getLottoNumberOutOfBoundErrorMessageBody());
        }
    }

    private void specialNumberDuplicationValidate(List<Integer> numbers, Integer specialNumber)
    {
        if(numbers.contains(specialNumber))
        {
            throw new IllegalArgumentException(Message.getLottoNumberDuplicationErrorMessage());
        }
    }

    public Integer getSpecialNumber()
    {
        return specialNumber;
    }

    @Override
    public boolean isContain(Integer lottoNumber)
    {
        if(lottoNumber == specialNumber) return true;

        return super.isContain(lottoNumber);
    }
}

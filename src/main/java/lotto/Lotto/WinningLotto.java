package lotto.Lotto;

import lotto.LottoNumberValidator;
import java.util.List;

public class WinningLotto extends Lotto {
    private final Integer specialNumber;

    public WinningLotto(List<Integer> numbers,Integer specialNumber)
    {
        super(numbers);
        LottoNumberValidator.specialNumberInBoundValidation(specialNumber);
        LottoNumberValidator.specialNumberDuplicationValidate(numbers,specialNumber);
        this.specialNumber = specialNumber;
    }



    public Integer getSpecialNumber()
    {
        return specialNumber;
    }
}

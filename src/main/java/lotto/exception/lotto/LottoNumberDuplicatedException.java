package lotto.exception.lotto;

import java.util.List;

public class LottoNumberDuplicatedException extends IllegalArgumentException  {



    private static final String ERROR_MESSAGE = "[ERROR] 로또의 번호는 중첩될수 없습니다. %s";

    public LottoNumberDuplicatedException(List<Integer> numbers){
        super(String.format(ERROR_MESSAGE,numbers));
    }
}

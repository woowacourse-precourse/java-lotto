package lotto.exception.lotto;

import java.util.List;

public class BonusDuplicatedException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 숫자는 보너스번호와 중첩될수 없습니다. 로또 : %s 보너스 : %d";

    public BonusDuplicatedException(List<Integer> winLotto, int bonus){
        super(String.format(ERROR_MESSAGE,winLotto,bonus));
    }
}

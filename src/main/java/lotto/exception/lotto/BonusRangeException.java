package lotto.exception.lotto;

import java.util.List;

public class BonusRangeException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 45보다 크거나 1보다 작을수 없습니다. : %d";

    public BonusRangeException(int bonus){
        super(String.format(ERROR_MESSAGE,bonus));
    }
}

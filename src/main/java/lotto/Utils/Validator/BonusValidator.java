package lotto.Utils.Validator;

import lotto.Utils.Util;

public class BonusValidator {
    public static final String ERROR = "[ERROR] ";
    public static final String NOT_INTEGER_STATE = "보너스 번호는 숫자로 입력되어야 합니다.";
    public static final String NOT_RANGE_STATE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    protected final String BonusLotto;

    public BonusValidator(String BonusLotto){
        this.BonusLotto = BonusLotto;
        isInteger();
        isValidRange();
    };

    private void isInteger(){
        try {
            Util.getInt(BonusLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }
    }

    private void isValidRange(){
        if(Util.getInt(BonusLotto) > 45 || Util.getInt(BonusLotto) < 1){
            throw new IllegalArgumentException(ERROR + NOT_RANGE_STATE);
        }
    }
}

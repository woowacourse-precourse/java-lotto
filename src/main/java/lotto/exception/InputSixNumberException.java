package lotto.exception;

import lotto.message.ErrorMessage;

public class InputSixNumberException extends LottoException {

    public InputSixNumberException (){
        super(ErrorMessage.INPUT_SIX_NUMBER);
    }
}

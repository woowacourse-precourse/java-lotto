package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Payment;
import lotto.view.validator.InputNumberValidator;

public class InputView {
    private static final String VIEW_CLASS_CREATE_EXCEPTION_MESSAGE = "View 클래스는 생성할 수 없습니다.";
    
    private InputView() {
        throw new IllegalStateException(VIEW_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static Payment inputPayment() {
        final String inputPayment = Console.readLine();
        InputNumberValidator.validate(inputPayment);
        return new Payment(Integer.parseInt(inputPayment));
    }
}
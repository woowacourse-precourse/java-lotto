package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.view.validator.InputNumberValidator;
import lotto.view.validator.InputWinningLottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String VIEW_CLASS_CREATE_EXCEPTION_MESSAGE = "View 클래스는 생성할 수 없습니다.";
    private static final String COMMA_DELIMITER = ",";
    
    private InputView() {
        throw new IllegalStateException(VIEW_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static Payment inputPayment() {
        final String inputPayment = Console.readLine();
        InputNumberValidator.validate(inputPayment);
        return new Payment(Integer.parseInt(inputPayment));
    }
    
    public static WinningLottoNumbers inputWinningLottoNumbers() {
        Lotto inputWinningLotto = inputWinningLotto(Console.readLine());
        int inputBonusNumber = inputBonusNumber(Console.readLine());
        return new WinningLottoNumbers(inputWinningLotto, inputBonusNumber);
    }
    
    private static Lotto inputWinningLotto(final String inputWinningLottoNumbers) {
        InputWinningLottoValidator.validate(inputWinningLottoNumbers);
        return new Lotto(parseLotto(inputWinningLottoNumbers));
    }
    
    private static List<Integer> parseLotto(final String inputWinningLottoNumbers) {
        return Arrays.stream(inputWinningLottoNumbers.split(COMMA_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    
    private static int inputBonusNumber(final String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }
}
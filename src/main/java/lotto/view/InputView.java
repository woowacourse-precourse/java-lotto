package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.WinningLottoNumbers;
import lotto.exception.ViewClassCreateException;
import lotto.validator.view.InputNumberValidator;
import lotto.validator.view.InputWinningLottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA_DELIMITER = ",";
    
    private InputView() {
        throw new ViewClassCreateException();
    }
    
    public static Payment inputPayment() {
        final String inputPayment = Console.readLine();
        InputNumberValidator.validate(inputPayment);
        return new Payment(Integer.parseInt(inputPayment));
    }
    
    public static WinningLottoNumbers inputWinningLottoNumbers() {
        return new WinningLottoNumbers(inputWinningLotto(), inputBonusNumber());
    }
    
    private static Lotto inputWinningLotto() {
        OutputView.printWinningLottoNumbersInputMessage();
        final String inputWinningLottoNumbers = Console.readLine();
        
        InputWinningLottoValidator.validate(inputWinningLottoNumbers);
        return new Lotto(parseLotto(inputWinningLottoNumbers));
    }
    
    private static List<Integer> parseLotto(final String inputWinningLottoNumbers) {
        return Arrays.stream(inputWinningLottoNumbers.split(COMMA_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    
    private static int inputBonusNumber() {
        OutputView.printBonusNumberInputMessage();
        final String inputBonusNumber = Console.readLine();
        
        InputNumberValidator.validate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }
}
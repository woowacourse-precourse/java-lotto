package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ExceptionHandler;
import lotto.data.InputForm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoForm {

    public int inputPrice() throws IllegalArgumentException {
        InputForm.INPUT_PRICE.printMessage();

        String priceInput = Console.readLine();
        ExceptionHandler.checkNumeric(priceInput);

        int price = Integer.parseInt(priceInput);
        ExceptionHandler.checkNotDivisibleByThousand(price);

        return price;
    }

    public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        InputForm.INPUT_WINNING_NUMBERS.printMessage();

        String winningNumberInput = Console.readLine();
        ExceptionHandler.checkNumeric(winningNumberInput);

        List<Integer> winningNumbers = Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ExceptionHandler.checkDuplicateNumber(winningNumbers);
        ExceptionHandler.checkOutOfRange(winningNumbers);
        ExceptionHandler.checkInvalidSize(winningNumbers);

        return winningNumbers;
    }
    
    public int inputBonus() throws IllegalArgumentException {
        InputForm.INPUT_BONUS.printMessage();

        String bonusInput = Console.readLine();
        ExceptionHandler.checkNumeric(bonusInput);

        int bonus = Integer.parseInt(bonusInput);
        ExceptionHandler.checkOutOfRange(bonus);

        return bonus;
    }
}

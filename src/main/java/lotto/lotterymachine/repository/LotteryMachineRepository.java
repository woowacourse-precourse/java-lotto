package lotto.lotterymachine.repository;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.validate.ValidateLotteryMachine;
import lotto.util.Constant;
import lotto.view.ValidateError;

public class LotteryMachineRepository {

    private static final List<Integer> INIT_NUMBERS = Collections.singletonList(Constant.INIT_ZERO);

    public boolean setTargetNumbers(LotteryMachine lotteryMachine) {
        List<Integer> inputNumbers = setInputTargetNumbers();
        if (inputNumbers.equals(INIT_NUMBERS)) {
            return false;
        }
        lotteryMachine.setTargetNumbers(inputNumbers);
        return true;
    }

    public boolean setTargetBonusNumber(LotteryMachine lotteryMachine) {
        int inputTargetNumber = setInputTargetBonusNumber();
        if (inputTargetNumber == Constant.INIT_ZERO) {
            return false;
        }
        lotteryMachine.setTargetBonusNumber(inputTargetNumber);
        return true;
    }

    public List<Integer> setInputTargetNumbers() {
        String userInputs = Console.readLine();
        if (!checkInputOnlyNumbers(userInputs)) {
            return INIT_NUMBERS;
        }
        if (!checkInputNumbersSize(userInputs)) {
            return INIT_NUMBERS;
        }

        return Arrays.stream(userInputs.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int setInputTargetBonusNumber() {
        String userInputs = Console.readLine();
        if (!checkInputOnlyNumber(userInputs)) {
            return Constant.INIT_ZERO;
        }
        return Integer.parseInt(userInputs);
    }

    public boolean checkInputOnlyNumber(String userInput) {
        try {
            ValidateLotteryMachine.validateOnlyNumber(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            ValidateError.printError(e);
            return false;
        }
    }

    public boolean checkInputOnlyNumbers(String userInput) {
        try {
            ValidateLotteryMachine.validateOnlyNumbers(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            ValidateError.printError(e);
            return false;
        }
    }

    private boolean checkInputNumbersSize(String userInput) {
        try {
            ValidateLotteryMachine.validateNumbersSize(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            ValidateError.printError(e);
            return false;
        }
    }
}

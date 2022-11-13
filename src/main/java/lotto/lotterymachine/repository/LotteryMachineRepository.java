package lotto.lotterymachine.repository;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.lotterymachine.domain.LotteryMachine;
import lotto.lotterymachine.validate.ValidateLotteryMachine;

public class LotteryMachineRepository {
    private static final int INIT_NUMBER = 0;
    private static final List<Integer> INIT_NUMBERS =Collections.singletonList(INIT_NUMBER);
    public void setTargetNumbers(LotteryMachine lotteryMachine) {
        System.out.println("당첨 번호를 입력해 주세요.");
        lotteryMachine.setTargetNumbers(setInputTargetNumbers());
    }

    public void setTargetBonusNumber(LotteryMachine lotteryMachine) {
        System.out.println("보너스 번호를 입력해 주세요.");
        lotteryMachine.setTargetBonusNumber(setInputTargetBonusNumber());
    }
    public List<Integer> setInputTargetNumbers(){
        String userInputs = Console.readLine();
        if (!checkInputOnlyNumbers(userInputs)) {
            return INIT_NUMBERS;
        }
        if(!checkInputNumbersSize(userInputs)) {
            return INIT_NUMBERS;
        }

        return Arrays.stream(userInputs.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
    public int setInputTargetBonusNumber() {
        String userInputs = Console.readLine();
        if (!checkInputOnlyNumber(userInputs)) {
            return INIT_NUMBER;
        }
        return Integer.parseInt(userInputs);
    }

    public boolean checkInputOnlyNumber(String userInput) {
        try {
            ValidateLotteryMachine.validateOnlyNumber(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean checkInputOnlyNumbers(String userInput) {
        try {
            ValidateLotteryMachine.validateOnlyNumbers(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

    private boolean checkInputNumbersSize(String userInput) {
        try {
            ValidateLotteryMachine.validateNumbersSize(userInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }
}

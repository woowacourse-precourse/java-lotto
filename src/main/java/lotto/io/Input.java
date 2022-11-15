package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.*;
import lotto.message.LottoMessage;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final Output output;
    private final static int UNIT_MONEY = 1000;
    private final static int LOTTO_LEN = 6;
    private final static int START = 1;
    private final static int END = 45;
    private final String REGEX = "^[0-9]*$";

    public Input() {
        this.output = new Output();
    }

    public int inputPurchaseMoney() {
        output.printMessageWithEnter(LottoMessage.INPUT_PURCHASE_MONEY);
        String number = inputNumber();
        int lottoCount = checkValidatePurchaseNumber(number);
        output.printEnter();
        return lottoCount;
    }

    public List<Integer> inputWinningNumbers() {
        String number = inputNumber();
        List<Integer> winningNumberList = checkValidateWinningNumbers(number);
        output.printEnter();
        return winningNumberList;
    }

    public int inputBonusNumber(List<Integer> winningNumberList) {
        String bonusNumber = inputNumber();
        int bonusNum = checkValidateBonusNumber(winningNumberList, bonusNumber);
        output.printEnter();
        return bonusNum;
    }

    private String inputNumber() {
        String number = Console.readLine();
        return number;
    }

    private int checkValidatePurchaseNumber(String number) {
        checkOnlyUseNumber(number);
        int num = Integer.parseInt(number);
        if(num % UNIT_MONEY > 0) {
            throw new InputWrongPurchaseMoneyException();
        }
        return num / UNIT_MONEY;
    }

    private List<Integer> checkValidateWinningNumbers(String number) {
        String[] num = number.split(",");
        checkWinningNumbersLength(num);
        List<Integer> winningNumberList = new ArrayList<>();
        for(String n : num) {
            checkOnlyUseNumber(n);
            winningNumberList.add(Integer.parseInt(n));
        }
        return winningNumberList;
    }

    private void checkWinningNumbersLength(String[] num) {
        if (num.length != LOTTO_LEN) {
            throw new InputSixNumberException();
        }
    }

    private int checkValidateBonusNumber(List<Integer> winningNumberList, String bonusNumber) {
        int bonusNum = Integer.parseInt(bonusNumber);
        checkOnlyUseNumber(bonusNumber);
        checkDuplicateBonusNumber(winningNumberList, bonusNum);
        checkRangeOfBonusNumber(bonusNum);
        return bonusNum;
    }

    private void checkDuplicateBonusNumber(List<Integer> winningNumberList, int bonusNumber) {
        if (winningNumberList.contains(bonusNumber)) {
            throw new AlreadyExistSameNumberException();
        }
    }
    private void checkRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < START || bonusNumber > END) {
            throw new OutOfRangeException();
        }
    }

    private void checkOnlyUseNumber(String input) {
        if(!input.matches(REGEX)) {
            throw new OnlyUseNumberException();
        }
    }

}

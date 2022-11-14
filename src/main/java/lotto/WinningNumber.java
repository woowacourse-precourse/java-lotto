package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningNumber() {
        winningNumbers = new ArrayList<Integer>();
        bonusNumber = 0;
    }

    public void createWinningNumbers() {
        transformInputWinningNumbers(inputWinningNumbers());
    }

    public void createBonusNumber() {
        transformBonusNumbers(inputBonusNumber());
    }

    private String inputWinningNumbers() {
        System.out.println(Message.EnterWinningNumberMessage);
        return Console.readLine();
    }

    private String inputBonusNumber() {
        System.out.println(Message.EnterBonusNumberMessage);
        return Console.readLine();
    }

    private void transformInputWinningNumbers(String inputWinningNumbers) {
        List<String> modifiedInputWinningNumbers = List.of(inputWinningNumbers.split(Message.Comma));
        winningNumberslengthCheck(modifiedInputWinningNumbers);

        for (String s : modifiedInputWinningNumbers) {
            try {
                int transformedWinningNumber = Integer.parseInt(s);
                rangeCheck(transformedWinningNumber);
                winningNumbers.add(transformedWinningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.IsNotNumberMessage);
            }
        }
        duplicationCheck(winningNumbers);
    }

    private void transformBonusNumbers(String inputBonusNumber) {
        bonusNumberlengthCheck(inputBonusNumber);
        try {
            int transformedBonusNumber = Integer.parseInt(inputBonusNumber);
            rangeCheck(transformedBonusNumber);
            bonusNumber = transformedBonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.IsNotNumberMessage);
        }
    }

    private void winningNumberslengthCheck(List<String> modifiedInputWinningNumbers) {
        if (modifiedInputWinningNumbers.size() != Message.LOTTOLENGTH) {
            throw new IllegalArgumentException(Message.WrongSizeWinningNumbersMessage);
        }
    }

    private void bonusNumberlengthCheck(String modifiedInputWinningNumbers) {
        if (modifiedInputWinningNumbers.length() != Message.BONUSLENGTH) {
            throw new IllegalArgumentException(Message.WrongSizeBonusNumberMessage);
        }
    }

    private void rangeCheck(int WinningNumber) {
        if (WinningNumber < 1 || 45 < WinningNumber) {
            throw new IllegalArgumentException(Message.WrongRangeMessage);
        }
    }

    private void duplicationCheck(List<Integer> winningNumbers) {
        for (Integer num : winningNumbers) {
            if (Collections.frequency(winningNumbers, num) != 1) {
                throw new IllegalArgumentException(Message.DuplicationMessage);
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}

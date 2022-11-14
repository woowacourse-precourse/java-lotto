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

        for (String s : modifiedInputWinningNumbers) {
            try {
                int transformedwinningNumber = Integer.parseInt(s);
                winningNumbers.add(transformedwinningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.IsNotNumberMessage);
            }
        }
    }

    private void transformBonusNumbers(String inputBonusNumber) {
        try {
            int transformedBonusNumber = Integer.parseInt(inputBonusNumber);
            bonusNumber = transformedBonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.IsNotNumberMessage);
        }
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}

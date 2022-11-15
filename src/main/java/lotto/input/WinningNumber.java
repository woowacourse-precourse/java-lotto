package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputSixDigitException;
import lotto.exception.NumberCheckException;
import lotto.exception.OverlapsNumberException;
import lotto.exception.ScopeOverException;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public List<Integer> putNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> putWinningNumber = OverlapsNumberException.overlapsCheck(
                InputSixDigitException.OverCheck(Console.readLine()));
        List<Integer> winningNumber = new ArrayList<>();

        for (String number : putWinningNumber) {
            winningNumber.add(
                    ScopeOverException.scopeCheck(NumberCheckException.check(number)));
        }// for

        return winningNumber;
    }//putNumber
}// end class

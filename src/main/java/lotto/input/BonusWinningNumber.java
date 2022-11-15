package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberCheckException;
import lotto.exception.OverlapsNumberException;
import lotto.exception.ScopeOverException;

import java.util.Arrays;
import java.util.List;

public class BonusWinningNumber {
    public int putBonusNum(List<Integer> putWinningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        List<String> winningNumber = Arrays.asList(putWinningNumber.toString()
                .replaceAll("\\[(.*)\\]", "$1").split(", "));

        Integer bonusNumber = NumberCheckException.check(
                OverlapsNumberException.bonusOverlapsCheck(winningNumber, Console.readLine()));
        ScopeOverException.scopeCheck(bonusNumber);

        return bonusNumber;
    }//putBonusNum
}// end class

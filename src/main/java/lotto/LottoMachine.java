package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        checkThatWinningNumberIsRightInput(inputNumber);

    }

    public List<String> splitNumber(String number) {
        return Arrays.asList(number.split(","));
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String bonusNumber = Console.readLine();
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }

    public void checkThatWinningNumberIsRightInput(String inputNumber) {
        List<String> winningNumberTemp = splitNumber(inputNumber);
        List<Integer> winningNumber = Exception.changeListStringToInteger(winningNumberTemp);

    }


}

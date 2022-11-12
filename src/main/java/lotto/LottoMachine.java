package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoMachine {
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        String[] winningNumber = splitNumber(inputNumber);
    }

    public String[] splitNumber(String number) {
        return number.split(",");
    }
}

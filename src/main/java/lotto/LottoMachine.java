package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoMachine {
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        int[] winningNumber = splitNumber(inputNumber);
    }

    public int[] splitNumber(String number) {
        String[] winningNumber = number.split(",");

        //String형 배열을 int형 배열로 변환하여 return
        return Arrays.stream(winningNumber).mapToInt(Integer::parseInt).toArray();
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }
}

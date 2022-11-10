package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumber {
    public void printInputWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public List<Integer> input() {
        String inputNumber = Console.readLine();
        List<Integer> inputNumbers = new ArrayList<>();
        String[] inputNumberArr = inputNumber.split(",");

        for(int i = 0; i < inputNumberArr.length; i++) {
            inputException(Integer.valueOf(inputNumberArr[i]));
            inputNumbers.add(Integer.valueOf(inputNumberArr[i]));
        }

        return inputNumbers;
    }

    private void inputException(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}

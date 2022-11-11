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
        printInputWinningNumberMessage();

        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumber = Console.readLine();
        String[] inputNumberArr = inputNumber.split(",");

        for (String number : inputNumberArr) {
            inputRangeException(Integer.parseInt(number));
            inputDuplicationException(winningNumbers, Integer.parseInt(number));
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        printInputBonusNumberMessage();

        int bonusNumber = Integer.parseInt(Console.readLine());

        inputRangeException(bonusNumber);

        return bonusNumber;
    }

    private void inputRangeException(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void inputDuplicationException(List<Integer> winning, int number) {
        if (winning.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 수를 입력할 수 없습니다.");
        }
    }
}

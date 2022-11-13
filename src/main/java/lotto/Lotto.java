package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateWinningNumberInput(numbers);
        this.numbers = numbers;
    }

    /**
     * Receives user input of winning numbers
     * @return list of winning lotto numbers
     */
    public static List<Integer> inputWinningNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningLotto = new ArrayList<>();
        String input = Console.readLine().replaceAll("\\s","");

        try {
            validateWinningNumberInputString(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (String num : input.split(",")) {
            winningLotto.add(Integer.parseInt(num));
        }

        return winningLotto;
    }

    /**
     * Check if user input string is valid
     * @param input user input of winning numbers in String format
     * @throws IllegalArgumentException if comma is not included
     */
    public static void validateWinningNumberInputString(String input) throws IllegalArgumentException {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉽표로 구분되어야 합니다.");
        }
    }

    /**
     * Validate user input of winning numbers
     * @param winningNumber list of winning numbers
     * @throws IllegalArgumentException if the size of the list isn't 6 or has duplicate numbers
     */
    private void validateWinningNumberInput(List<Integer> winningNumber) throws IllegalArgumentException{
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 총 6개여야 합니다.");
        }
        for (int i = 0; i < winningNumber.size() - 1; i++) {
            if (winningNumber.subList(i + 1, winningNumber.size()).contains(winningNumber.get(i))) {
                throw new IllegalArgumentException("[ERROR] 당첨번호에는 중복되는 숫자가 있어선 안됩니다.");
            }
            if (winningNumber.get(i) < 1 || winningNumber.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1 에서 45 사이의 정수여야 합니다.");
            }
        }
    }

    /**
     * Receives user input of bonus number
     * @return bonus number
     * @throws IllegalArgumentException if input is invalid
     */
    private int getBonusNumber() throws IllegalArgumentException {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    /**
     * Validates bonus number input
     * @param bonusNumInput String format of user input
     * @throws IllegalArgumentException if bonus number is not a number between 1 and 45 or is not a number
     */
    public void validateBonusNumber(String bonusNumInput) throws IllegalArgumentException {
        int bonusNum;
        try {
            bonusNum = Integer.parseInt(bonusNumInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 에서 45 사이의 정수여야 합니다.");
        }
    }

    /**
     * Receives user input of winning numbers/bonus number and calculates result
     * @param purchasedLottos purchases lottos from Manager class
     */
    public void result(List<List<Integer>> purchasedLottos) {
        int bonusNum;
        try {
            bonusNum = getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        Calculator calculator = new Calculator(purchasedLottos, numbers, bonusNum);
        calculator.calculate();
    }
}

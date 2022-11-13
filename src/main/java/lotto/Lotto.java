package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }
    private void validateLotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
            if (countSameNumber(numbers,number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }
    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }
    }

    private int countSameNumber(List<Integer> numbers, int standardNumber) {
        int count = 0;
        for (int number : numbers) {
            if (number == standardNumber) {
                count++;
            }
        }
        return count;
    }
}


class UserInput {

    static public void requestPayment() {
        String userInput = Console.readLine();
        isNumeric(userInput);
    }

    static public List<Integer> requestWinningLottoNumber() {
        String userInput = Console.readLine();
        String[] splitUserInput = userInput.split(",");
        List<Integer> numbers = new ArrayList<Integer>();

        for (String number : splitUserInput) {
            isNumeric(number);
            numbers.add(Integer.parseInt(number));
        }
        return numbers;

    }

    static public int requestBonusNumber() {
        String userInput = Console.readLine();
        isNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    private static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 숫자가 아닙니다.");
        }
    }


}





package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Exeption {

    public static void isNotoverlapped(List<Integer> numbers) {
        int length = numbers.size();
        int distinctLength = (int) numbers.stream().distinct().count();
        if (length != distinctLength) {
            throw new IllegalArgumentException("[ERROR] 숫자 중복되었습니다.");
        }
    }
    // String to List<Integer>
    public static List<Integer> stringToList(String input) {
        List<String> splitInput = Arrays.asList(input.split(","));
        // String to Integer // 중복 제거
        return splitInput.stream()
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }

    // input 예외처리
    public static void inputWinningNumberExeption(String input, boolean isFirst) {
        List<String> splitInput = Arrays.asList(input.split(","));
        inputWinningNumberExeptionDetail(splitInput);
        StringToInteger(splitInput, isFirst);
    }

    //List<String> to List<Integer>
    public static void StringToInteger(List<String> input, boolean isFirst) {
        int length = input.size();
        List<Integer> numbers = input.stream()
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
        wrongNumberSize(numbers, length, isFirst);

    }

    public static void wrongNumberSize(List<Integer> numbers, int length, boolean isFirst) {
        if (length != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복입력 하였습니다.");
        }
        // 첫 입력
        if (isFirst) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 숫자 개수를 잘못입력하셨습니다.");
            }
        }
        // 보너스 입력
        if (!isFirst) {
            if (numbers.size() != 1) {
                throw new IllegalArgumentException("[ERROR] 숫자 개수를 잘못입력하셨습니다.");
            }
        }

    }

    //로또 번호에 숫자가 아닌 문자가 들어갔을 때
    public static void inputWinningNumberExeptionDetail(List<String> splitInput) {
        splitInput.stream().forEach((num) -> {
            if (!num.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            }
            int number = Integer.parseInt(num);
            if (number < 1 && number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45사이입니다.");
            }
        });
    }
    public static void inputMoneyExeption(String money) {
        if (!money.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR]");
            throw new NoSuchElementException("[ERROR] 숫자가 아닙니다.");
        }

        int moneyCheck = Integer.parseInt(money);
        // 1,000 으로 나누어 떨어지지 않을 때
        if (moneyCheck % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나누어 떨어지지 않습니다.");
        }
        if (money.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 0을 입력하시면 안됩니다.");
        }
    }
}

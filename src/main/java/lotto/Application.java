package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int money = inputMoney();
        printLottoList(money);
    }

    public static int inputMoney() {
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static void validateMoney(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void printLottoList(int money) {
        List<Lotto> lottoList = Lotto.getLottoList(money);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String numbers = Console.readLine();
        validateWinningNumbers(numbers);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static void validateWinningNumbers(String numbers) {
        if (!isDigit(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (!hasDuplication(numbers)) {
            throw new IllegalStateException("[ERROR] 6개의 다른 숫자만 입력 가능합니다.");
        }
        if (!hassValidScope(numbers)) {
            throw new IllegalStateException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static boolean isDigit(String numbers) {
        for (char element : numbers.toCharArray()) {
            if (element == ',') {
                continue;
            }
            if (!Character.isDigit(element)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplication(String numbers) {
        Set<String> elements = new HashSet<>(Arrays.asList(numbers.split(",")));
        return elements.size() == 6;
    }

    public static boolean hassValidScope(String numbers) {
        for (String number : numbers.split(",")) {
            int element = Integer.parseInt(number);
            if (!(0 < element && element < 46)) {
                return false;
            }
        }
        return true;
    }
}

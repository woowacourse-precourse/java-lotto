package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static void priceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void checkPriceDigit(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!Character.isDigit(numbers.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
            }
        }
    }

    static void checkPrice(int n) {
        if (n % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 형식이 맞지 않습니다.");
        }
    }

    static int inputPrice() {
        priceMessage();
        String price = Console.readLine();
        System.out.println();
        checkPriceDigit(price);
        checkPrice(Integer.parseInt(price));
        return Integer.parseInt(price) / 1000;
    }

    static void numberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static void checkDigitNumber(String numbers) {
        String allNumber = numbers.replaceAll(",", "");
        for (int i = 0; i < allNumber.length(); i++) {
            if (!Character.isDigit(allNumber.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }

    static void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개 숫자이어야 합니다.");
        }
    }

    static void checkNumberRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || 45 < numbers.get(i)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위의 숫자이여야 합니다.");
            }
        }
    }

    static void checkNumberDuplication(List<Integer> numbers) {
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) == numbers.get(i + 1)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 없는 숫자이여야 합니다.");
            }
        }
    }

    static List<Integer> inputNumbers() {
        numberMessage();
        String numbers = Console.readLine();
        System.out.println();
        checkDigitNumber(numbers);

        List<Integer> result = new ArrayList<>();
        for (String number : numbers.split(",")) {
            result.add(Integer.parseInt(number));
        }
        checkNumberCount(result);
        checkNumberRange(result);
        checkNumberDuplication(result);
        return result;
    }

    static void bonusMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static void checkDigitBonus(String numbers) {
        String allNumber = numbers.replaceAll(",", "");
        for (int i = 0; i < allNumber.length(); i++) {
            if (!Character.isDigit(allNumber.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
            }
        }
    }

    static void checkBonusRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 숫자이여야 합니다.");
        }
    }

    static void checkBonusDuplication(int number, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 없는 숫자이여야 합니다.");
            }
        }
    }

    static void inputBonusNumbers(List<Integer> numbers) {
        bonusMessage();
        String number = Console.readLine();
        System.out.println();
        checkDigitBonus(number);
        checkBonusRange(Integer.parseInt(number));
        checkBonusDuplication(Integer.parseInt(number), numbers);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int count = inputPrice();
            System.out.println(count + "개를 구매했습니다.");
            List<Lotto> lottos = Lotto.createLottos(count);

            List<Integer> result = inputNumbers();
            inputBonusNumbers(result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

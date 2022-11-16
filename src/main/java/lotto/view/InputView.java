package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.InputValidationUtils.validateFormat;
import static lotto.utils.InputValidationUtils.validateNumbers;
import static lotto.utils.InputValidationUtils.validatePrice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = getNumber();
        validatePrice(price);
        return price;
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return getNumber();
    }

    public static int getNumber() {
        String input = readLine();
        validateFormat(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨번호를 입력해 주세요.");
        String[] numbers = readLine().split(",");
        validateNumbers(numbers);

        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}

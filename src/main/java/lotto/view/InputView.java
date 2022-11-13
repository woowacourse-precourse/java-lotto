package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static Integer getAmount(String input) {
        try {
            Integer amount = Integer.valueOf(input);
            if(amount % 1000 != 0 || amount < 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요. ");
            }
            return amount;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요. ");
        }
    }

    public static List<Integer> getWinningNumber(String input) {
        try {
            List<Integer> winningNumber = Arrays.stream(input.split(","))
                                            .map(number -> Integer.valueOf(number))
                                            .collect(Collectors.toList());
            for(Integer number:winningNumber) {
                if(number < 1 || number > 45) {
                    throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 입력해주세요. ");
                }
            }
            return winningNumber;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값이 입력됐습니다. ");
        }
    }

    public static Integer getBonusNumber(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다. ");
        }
    }

    public static Integer getAmount() {
        return getAmount(readLine());
    }

    public static List<Integer> getWinningNumber() {
        return getWinningNumber(readLine());
    }

    public static Integer getBonusNumber() {
        return getBonusNumber(readLine());
    }
}

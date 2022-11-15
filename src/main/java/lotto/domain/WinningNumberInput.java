package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.ErrorMessage.*;

public class WinningNumberInput {
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";




    public static Lotto winningNumberInput(){
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        Lotto winningNumbers = new Lotto(convertNumbers(Console.readLine()));
        System.out.println();
        return winningNumbers;
    }

    public static List<Integer> convertNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    public static int BonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = convertNumbers(Console.readLine()).get(0);

        return bonusNumber;
    }

}








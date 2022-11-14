package lotto.service;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class LottoWinningNumberService {

    public static Lotto generateLottoWinningNumber() {
        List<String> separatedInputString = separateStringByComma(inputWinningNumbers());
        isDigit(separatedInputString);
        List<Integer> winningNumbers = intValueOf(separatedInputString);
        return new Lotto(winningNumbers);
    }

    public static int generateBonusNumber() {
        return inputBonusNumber();
    }

    private static void isDigit(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> intValueOf(List<String> inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    private static List<String> separateStringByComma(String inputWinningNumbers) {
        List<String> separatedString = Arrays.asList(inputWinningNumbers.split(","));
        if (separatedString.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 구분자를 확인해주세요.");
        }
        return separatedString;
    }
}

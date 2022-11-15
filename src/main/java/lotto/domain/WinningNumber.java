package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public String inputWinningNumbers() {
        String input = Console.readLine();
        validateComma(input);
        validateCountComma(input);
        return input;
    }

    public List<Integer> seperatedByComma(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] seperatedComma = input.split(",");

        for (int i = 0; i < seperatedComma.length; i++) {
            winningNumbers.add(Integer.parseInt(seperatedComma[i]));
        }
        return winningNumbers;
    }

    private void validateComma(String numbers) {
        int count = 0;
        String match = "[0-9]";
        numbers = numbers.replaceAll(match, "");

        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) != ',') {
                count++;
            }
        }

        if (count > 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 로또 번호가 콤마로 구성되어 있지 않습니다.");
        }
    }

    private void validateCountComma(String numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == ',') {
                count++;
            }
        }

        if (count != 5) {
            throw new IllegalArgumentException("[ERROR] 입력된 콤마 개수가 5개가 아닙니다.");
        }
    }
}

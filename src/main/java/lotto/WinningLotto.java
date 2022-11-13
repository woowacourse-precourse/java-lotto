package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(String numbers) {
        List<Integer> winningNumbers = parseIntegerList(numbers);
        winningLotto = new Lotto(winningNumbers);
    }

    public List<Integer> parseIntegerList(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            try {
                winningNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
                throw new IllegalArgumentException();
            }
        }
        return winningNumbers;
    }
}

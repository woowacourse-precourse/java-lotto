package lotto;

import java.util.List;
import java.util.Scanner;

public class WinLotto extends Lotto {
    int bonus;

    public WinLotto(List<Integer> numbers) {
        super(numbers);
        validate(numbers);
        String input = getBonusInputFromUser();
    }

    private String getBonusInputFromUser() {
        System.out.println(Message.INPUT_BONUS.message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void validate(List<Integer> numbers) {
        validateWinLottoNumbersRange(numbers);
    }

    public void validateWinLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Application.LOTTO_START || number > Application.LOTTO_END) {
                throw new IllegalArgumentException(Message.ERROR_LOTTO_INPUT.message);
            }
        }
    }
}

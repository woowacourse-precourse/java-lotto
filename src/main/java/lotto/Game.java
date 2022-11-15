package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private User user;

    public void play() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();
        user = new User(validateNumberFormat(inputAmount));
        user.buyLotto();
        user.printLottos();

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinNumber = Console.readLine();
        List<Integer> winNumbers = validateWinNumber(inputWinNumber);

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        long bonusNumber = validateNumberFormat(inputBonusNumber);

        WinLotto winLotto = new WinLotto(new Lotto(winNumbers), bonusNumber);
    }

    private long validateNumberFormat(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> validateWinNumber(String inputWinNumber) {
        List<Integer> winNumbers = new ArrayList<>();
        List<String> numbers = Arrays.stream(inputWinNumber.split(",")).collect(Collectors.toList());
        for (String number:numbers) {
            winNumbers.add((int) validateNumberFormat(number.trim()));
        }

        winNumbers.sort(Integer::compare);

        return winNumbers;
    }

}

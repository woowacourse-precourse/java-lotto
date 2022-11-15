package lotto.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    UserException exception = new UserException();

    public int purchasePrice() throws IllegalArgumentException{
        System.out.print("구매 금액을 입력해 주세요.");
        String price = readLine();
        exception.IsNumberFormat(price);
        return Integer.parseInt(price);
    }

    public List<Integer> winnerNumbers() throws IllegalArgumentException{
        System.out.print("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        exception.IsRightWinnerNumberFormat(numbers);
        List<Integer> winnerNumber = Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return winnerNumber;
    }

    public int bonusNumber() throws IllegalArgumentException{
        System.out.print("보너스 번호를 입력해 주세요.");
        String number = readLine();
        exception.IsRightBonusNumberFormat(number);
        return Integer.parseInt(number);
    }
}

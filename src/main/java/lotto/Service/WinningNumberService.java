package lotto.Service;

import camp.nextstep.edu.missionutils.Console;

import lotto.Model.Lotto;

import java.util.List;

import java.util.stream.Collectors;

import static lotto.Application.separator;
import static lotto.Application.ERROR_MESSAGE;
import static lotto.Application.errorContent;

public class WinningNumberService {

    public Lotto generateWinningNumber() {
        String winningNumberString = Console.readLine();
        Lotto winningNumber = new Lotto(convertToInteger(winningNumberString, separator));
        return winningNumber;
    }

    public List<Integer> convertToInteger(String winningNumberString, String separator) {
        List<String> winningNumberStringList = List.of(winningNumberString.split(separator, 0));
        try {
            return winningNumberStringList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            errorContent = ERROR_MESSAGE + " 당첨 번호는 구분자로 구분된 숫자로 입력되어야합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }
}

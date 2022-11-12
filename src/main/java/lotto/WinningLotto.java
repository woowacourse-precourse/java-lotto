package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto() {
        Print.PrintTypingWinLotto();
        String stringInputNumbers = Console.readLine();

        String[] stringWinningNumbers = stringInputNumbers.split(",");
        Exception.validateLottoLength(stringWinningNumbers);
        Exception.validateLottoNumberRange(stringWinningNumbers);
        Exception.validateDuplicateNumbers(stringWinningNumbers);

        winningLotto = new Lotto(
                Arrays.stream(stringWinningNumbers).map(Integer::parseInt).collect(Collectors.toList())
        );

        Print.PrintTypingBonusNumber();
        String inputBonusNumber = Console.readLine();
        Exception.validateNumber(inputBonusNumber);
        Exception.validateLottoNumberRange(inputBonusNumber);
        Exception.validateDuplicateNumbers(winningLotto,inputBonusNumber);

        bonusNumber = Integer.parseInt(inputBonusNumber);
    }
}

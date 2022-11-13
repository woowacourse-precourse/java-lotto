package lotto.template;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.validator.LottoValidator;
import lotto.utils.validator.MoneyValidator;
import lotto.utils.validator.NumberValidator;
import lotto.utils.validator.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int insertMoney() {
        String input = readAfterPrint("구입금액을 입력해 주세요.");
        return parseMoney(input);
    }

    public static List<Integer> insertWinningNumbers() {
        String input = readAfterPrint("당첨 번호를 입력해 주세요.");
        return parseWinningNumbers(input);
    }

    public static int insertBonusNumber(List<Integer> winningNumbers) {
        String input = readAfterPrint("보너스 번호를 입력해 주세요.");
        return parseBonusNumber(input, winningNumbers);
    }

    private static String readAfterPrint(String out) {
        System.out.println(out);
        return Console.readLine();
    }

    private static int parseMoney(String input) {
        NumberValidator.checkNaturalNumber(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> parseWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputs = input.split(",");

        StringValidator.checkSplitSixArgs(inputs);
        for (String string : inputs) {
            NumberValidator.checkNaturalNumber(string);
            winningNumbers.add(Integer.parseInt(string));
        }
        LottoValidator.checkLottoNumbers(winningNumbers);
        LottoValidator.checkDuplicateNumber(winningNumbers);
        return winningNumbers;
    }

    private static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        NumberValidator.checkNaturalNumber(input);
        int number = Integer.parseInt(input);
        LottoValidator.checkLottoNumber(number);
        LottoValidator.checkContainNumber(winningNumbers, number);
        return number;
    }
}

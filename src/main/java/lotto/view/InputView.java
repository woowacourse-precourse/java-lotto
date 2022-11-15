package lotto.view;

import lotto.exception.lotto.LottoNumWrongPatternException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_TICKET_COUNT_MESSAGE = System.lineSeparator() + "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_TICKET_NUMBS_GROUP_MESSAGE = System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.";

    private static final String REGEX = ",";
    private static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return inputNum();
    }

    public static int inputManualTicketCount() {
        System.out.println(MANUAL_TICKET_COUNT_MESSAGE);
        return inputNum();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_INPUT_MESSAGE);
        return inputNum();
    }

    public static List<Integer> inputWinLottoNums() {
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE);
        return inputLottoNums();
    }

    public static List<List<Integer>> inputManualNums(final int repeatCount) {
        System.out.println(MANUAL_TICKET_NUMBS_GROUP_MESSAGE);
        List<List<Integer>> numsGroup = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            numsGroup.add(inputLottoNums());
        }
        return numsGroup;
    }

    private static int inputNum() {
        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    private static List<Integer> inputLottoNums() {
        final String lottoNumbers = SCANNER.nextLine();
        validateLottoNums(lottoNumbers);
        return separateNumbers(lottoNumbers);
    }

    private static List<Integer> separateNumbers(final String numbersText) {
        return Arrays.stream(numbersText.split(REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateLottoNums(final String rawLottoNumbers) {
        if (!PATTERN.matcher(rawLottoNumbers).matches()) {
            throw new LottoNumWrongPatternException(rawLottoNumbers);
        }
    }
}

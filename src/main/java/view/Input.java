package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Util;

import java.util.List;
import java.util.regex.Pattern;

public class Input {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$");

    public static int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return inputNumber();
    }

    public static List<Integer> inputWinningLotteryNumber() {
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE);
        return inputLotteryNumber();
    }

    private static List<Integer> inputLotteryNumber() {
        String lotteryWinningNumber = Console.readLine();
        validateLottoNums(lotteryWinningNumber);
        List<Integer> list = Util.separateNumberWithComma(lotteryWinningNumber);
        validateDuplicate(list);
        return list;
    }

    private static void validateDuplicate(List<Integer> list) {
        if (isDuplicateNumberExist(list)) {
            throw new IllegalArgumentException("[ERROR] 중복된 값을 입력할 수 없습니다.");
        }
    }

    private static boolean isDuplicateNumberExist(List<Integer> list) {
        return list.size() != list.stream().distinct().count();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return inputNumber();
    }

    private static int inputNumber() {
        String textNumber = Console.readLine();
        int result;
        try {
            result = Util.convertStringToInt(textNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
        return result;
    }

    private static void validateLottoNums(String lottoNumbers) {
        if (!PATTERN.matcher(lottoNumbers).matches()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 잘못되었습니다.");
        }
    }

}

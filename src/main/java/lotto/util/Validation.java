package lotto.util;

import java.util.*;

public class Validation {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int MONEY_UNIT = 1000;
    private static final String INPUT_NAN_ERROR_MSG = "[ERROR] 문자가 아닌 숫자를 입력해주세요.";
    private static final String INPUT_UNIT_ERROR_MSG = "[ERROR] 금액을 1000원 단위로 입력해주세요.";
    private static final String INPUT_LOTTO_NUMBER_RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INPUT_LOTTO_NUMBER_SIZE_ERROR_MSG = "[ERROR] 로또 번호 6개를 입력해주세요.";
    private static final String INPUT_LOTTO_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 로또 번호 6개는 서로 다른 숫자여야 합니다.";
    private static final String LOTTO_AND_BONUS_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 보너스 번호는 로또 번호와 다른 숫자여야 합니다.";


    public static int validateMoney(String input) {
        int money = 0;

        if (isInteger(input)) {
            money = Integer.parseInt(input);
            checkUnit(money);
        }
        return money;
    }

    public static List<Integer> validateLottoNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String s : numbers) {
            if (isInteger(s)) {
                int number = Integer.parseInt(s);
                checkInRange(number);
                lottoNumbers.add(number);
            }
        }
        validateLotto(lottoNumbers);

        return lottoNumbers;
    }

    public static int validateBonusNumbers(String input) {
        int number = 0;

        if (isInteger(input)) {
            number = Integer.parseInt(input);
            checkInRange(number);
        }

        return number;
    }

    public static void checkDuplicateLottoNumbersAndBonusNumber(List<Integer> lottoNumbers, int number) {
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(LOTTO_AND_BONUS_NUMBER_DUPLICATE_ERROR_MSG);
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NAN_ERROR_MSG);
        }

        return true;
    }

    private static void checkUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR_MSG);
        }
    }

    private static void checkInRange(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_RANGE_ERROR_MSG);
        }
    }

    public static void validateLotto(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (numbers.size() != check.size()) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_DUPLICATE_ERROR_MSG);
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_SIZE_ERROR_MSG);
        }
    }
}

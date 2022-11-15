package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheck {
    private static final String NOT_NUMBER_INPUT_ERROR_MSG = "[ERROR] 숫자 이외의 값을 입력했습니다.";
    private static final String EMPTY_ERROR_MSG = "[ERROR] 빈 값이 입력되었습니다.";
    private static final String AMOUNT_SCALE_ERROR_MSG = "[ERROR] 1000원 미만의 값이 입력되었습니다.";
    private static final String LOTTO_NUMBER_LENGTH_ERROR_MSG = "[ERROR] 입력한 로또번호의 길이가 6이 아닙니다.";

    private static final String RANGE_ERROR_MSG = "[ERROR] 로또 범위에 맞지 않는 숫자값을 가지고 있습니다.";
    private static final String DUPLICATE_ERROR_MSG = "[ERROR] 로또에 중복된 번호가 있습니다.";
    private static final String DUPLICATE_BONUS_NUBER_ERROR_MSG = "[ERROR] 보너스 번호가 로또의 번호와 중복됩니다.";

    public static void validInputMoney(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkMoneyScale(input);
    }

    public static void validCreateLotto(List<Integer> lotto) {
        validateSize(lotto);
        validateNumbersRange(lotto);
        validateDuplicate(lotto);
    }

    public static void validInputLottoNumbers(String input) {
        checkEmpty(input);
        checkDigit(input);
        checkLottoLength(input);
        checkLottoNumberRange(input);
        checkDuplicateNumber(input);
    }

    public static void validInputBonusNumber(List<Integer> lottoNumbers, String input) {
        checkEmpty(input);
        checkDigit(input);
        checkLottoNumberRange(input);
        checkDuplicateNumber(lottoNumbers,input);
    }

    private static void checkDuplicateNumber(List<Integer> lottoNumbers, String input) {
        Set<Integer> duplicateNumbers = new HashSet<>(lottoNumbers);

        int bonusNumber = Integer.parseInt(input);
        if(duplicateNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUBER_ERROR_MSG);
        }
    }

    private static void checkLottoNumberRange(String input) {
        String[] str = stringToArray(input);

        for (String s : str) {
            int num = Integer.parseInt(s);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }

    private static void checkDuplicateNumber(String input) {
        String[] str = stringToArray(input);
        List<Integer> numbers = new ArrayList<>();

        for (String s : str) {
            int num = Integer.parseInt(s);
            if (numbers.contains(num)) {
                throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
            }
            numbers.add(num);
        }
    }

    private static void checkLottoLength(String input) {
        String[] str = stringToArray(input);

        if(str.length == 6) {
            return;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR_MSG);
    }

    private static void checkDigit(String input) {
        input = input.replace(",","");
        for(int i = 0 ; i < input.length(); ++i) {
            if(Character.isDigit(input.charAt(i))) {
                continue;
            }
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MSG);
        }
    }

    private static void checkEmpty(String input) {
        String[] str = stringToArray(input);
        for (String s : str) {
            if (s.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_ERROR_MSG);
            }
        }
    }

    private static void checkMoneyScale(String input) {
        int money = Integer.parseInt(input);
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_SCALE_ERROR_MSG);
        }

    }


    private static void validateNumbersRange(List<Integer> lotto) {
        for(int number : lotto) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }

    private static void validateDuplicate(List<Integer> lotto) {
        Set<Integer> duplicateNumbers = new HashSet<>(lotto);
        if(duplicateNumbers.size() == 6) {
            return;
        }
        throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
    }

    private static void validateSize(List<Integer> lotto) {
        if(lotto.size() == 6){
            return;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_LENGTH_ERROR_MSG);
    }

    private static String[] stringToArray(String str) {
        return str.split(",");
    }
}

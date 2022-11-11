package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private final static int LOTTO_NUMBER_MIN = 1;
    private final static int LOTTO_NUMBER_MAX = 45;
    private final static int LOTTO_PRICE_UNIT = 1000;
    private final static int LOTTO_NUMBERS_INPUT_SIZE = 6;
    private final static String LOTTO_NUMBER_DELIMITER = ",";

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumber(String input) {
        int lottoNumber;
        validateNumber(input);
        lottoNumber = Integer.parseInt(input);
        if (lottoNumber < LOTTO_NUMBER_MIN || lottoNumber > LOTTO_NUMBER_MAX) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validatePrice(int price) {
        if (price % LOTTO_PRICE_UNIT != 0) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static int price() {
        int price;
        String input = Console.readLine();
        validateNumber(input);
        price = Integer.parseInt(input);
        validatePrice(price);
        return price;
    }

    public static List<Integer> lottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        String input = Console.readLine();
        String[] splitByCommaInput = input.split(LOTTO_NUMBER_DELIMITER);
        validateSplitByCommaInputSize(splitByCommaInput);
        for (String lottoNumber : splitByCommaInput) {
            validateLottoNumber(lottoNumber);
            lottoNumbers.add(Integer.parseInt(lottoNumber));
        }
        validateNonDuplicatedLottoNumbers(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }

    public static void validateSplitByCommaInputSize(String[] splitByCommaInput) {
        if (splitByCommaInput.length != LOTTO_NUMBERS_INPUT_SIZE) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validateNonDuplicatedLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_INPUT_SIZE) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static int bonusNumber() {
        String input = Console.readLine();
        validateLottoNumber(input);
        return Integer.parseInt(input);
    }
}

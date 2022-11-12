package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Constant;

public class Input {

    private final static String LOTTO_NUMBER_DELIMITER = ",";
    private final static int REMAINDER = 0;

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            Print.numberException();
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumber(String input) {
        int lottoNumber;
        validateNumber(input);
        lottoNumber = Integer.parseInt(input);
        if (lottoNumber < Constant.LOTTO_NUMBER_MIN || lottoNumber > Constant.LOTTO_NUMBER_MAX) {
            Print.lottoNumberException();
            throw new IllegalArgumentException();
        }
    }

    public static void validatePrice(int price) {
        if (price % Constant.LOTTO_PRICE_UNIT != REMAINDER) {
            Print.priceException();
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
        if (splitByCommaInput.length != Constant.LOTTO_NUMBERS_INPUT_SIZE) {
            Print.splitByCommaInputSizeException();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNonDuplicatedLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constant.LOTTO_NUMBERS_INPUT_SIZE) {
            Print.nonDuplicatedLottoNumbersException();
            throw new IllegalArgumentException();
        }
    }

    public static int bonusNumber() {
        String input = Console.readLine();
        validateLottoNumber(input);
        return Integer.parseInt(input);
    }
}

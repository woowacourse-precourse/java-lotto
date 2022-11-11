package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    private final static int LOTTO_NUMBERS_INPUT_SIZE = 6;

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
        if (lottoNumber < 1 || lottoNumber > 45) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
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
        String[] splitByCommaInput = input.split(",");
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
}

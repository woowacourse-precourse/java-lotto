package lotto.inputparser;

import lotto.lottonumber.Lotto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.inputparser.InputLottoType.*;

/**
 * 입력 문자열을 로또 번호들로 파싱하는 역할을 담당하는 클래스입니다.
 */
public class InputParser {
    /**
     *
     * @param inputLottoString 입력으로 받은 일반 로또 숫자에 해당하는 문자열
     * @return 입력 문자열을 로또 클래스로 파싱한 결과
     */
    public static Lotto parseLottoString(String inputLottoString) {
        String[] numbers = inputLottoString.split(",");
        InputLottoType inputLottoType = validateInputLottoString(numbers);

        if (inputLottoType == OK) {
            return new Lotto(parseStringList(numbers));
        }
        alertError(inputLottoType);
        return null;
    }

    /**
     * 구입 금액 문자열이 정상적인 입력인지 확인하고, 정상적이면 구입 금액을 반환합니다.
     * @param amount 구입 금액에 해당하는 문자열
     * @return 구입 금액
     */
    public static int parsePurchaseAmount(String amount) {
        if (!isNumber(amount)) {
            alertError(IS_NOT_PURCHASE_NUMBER);
        }
        int purchaseAmount = Integer.parseInt(amount);
        if (purchaseAmount < 0) {
            alertError(INVALID_PURCHASE_AMOUNT);
        }
        return Integer.parseInt(amount);
    }

    /**
     * 보너스 번호에 해당하는 문자열이 정상적인 번호인지 판단하고, 정상적인 경우 파싱된 결과를 반환합니다.
     * @param number 보너스 번호에 해당하는 문자열
     * @return 보너스 번호
     */
    public static int parseBonusNumber(String number) {
        if (!isNumber(number)) {
            alertError(IS_NOT_BONUS_NUMBER);
        }
        int bonusNumber = Integer.parseInt(number);
        if (bonusNumber < 1 || bonusNumber > 45) {
            alertError(OUT_OF_RANGE);
        }
        return Integer.parseInt(number);
    }

    /**
     * 입력 문자열이 정상적인 입력인지 판단하는 기능을 담당합니다
     * 다음의 경우 예외가 발생합니다.
     *   1. 입력으로 받은 문자열이 쉼표와 숫자 로만 이루어지지 않은 경우
     *   2. 로또 번호의 수가 6이 아닌 경우
     *   3. 로또 번호의 수의 범위가 1 ~ 45가 아닌 경우
     *   4. 중복된 로또 번호의 수가 등장한 경우
     * @param numbers 입력 문자열을 ,으로 split해서 생성된 문자열 배열
     */
    private static InputLottoType validateInputLottoString(String[] numbers) {
        if (numbers.length != 6) return IS_NOT_SIX_NUMBERS;
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (!isNumber(numbers[i])) return IS_NOT_NUMBER;
            int singleLottoNumber = Integer.parseInt(numbers[i]);
            if (singleLottoNumber < 1 || singleLottoNumber > 45) return OUT_OF_RANGE;
            lottoNumbers.add(singleLottoNumber);
        }
        if (new HashSet<>(lottoNumbers).size() != 6) return DUPLICATED_NUMBER;
        return OK;
    }

    /**
     * 특정 문자열이 정수형으로 변환 가능한지 확인하는 기능을 담당합니다.
     * @param str 정수형으로 형변환이 가능한지 확인하고자 하는 문자열
     * @return 정수형으로 변환 가능한지 여부
     */
    private static boolean isNumber(String str) {
        if (str.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * 문자열 배열의 각 element를 정수형으로 형변환하고,이를 리스트에 담아 반환합니다.
     * @param numbers 변환하고자 하는 문자열 배열
     * @return 변환된 정수형 리스트
     */
    private static List<Integer> parseStringList(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }

    /**
     * 예외가 발생한 경우, 해당 예외에 해당하는 에러 메시지를 출력하고, 예외를 던집니다.
     * @param inputLottoType 발생한 예외의 종류입니다.
     */
    private static void alertError(InputLottoType inputLottoType) {
        String prefix = "[ERROR] ";
        System.out.println(prefix + inputLottoType.getMessage());
        throw new IllegalArgumentException(inputLottoType.getMessage());
    }

}

package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.manageLotto.LottoManager;
import lotto.ProgramManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 사용자의 입력과 그에 대한 예외처리 담당
public class InputManager {

    // 0으로 시작하지 않는 숫자 입력 (각 자리별 범위 : 0 ~ 9)
    private static final String PRICE_REGEX = "^[^0][0-9]*$";

    // 숫자, 쉼표(,)만으로 이루어진 입력
    private static final String PREDICT_LOTTO_NUMBER_REGEX = "^(\\d|,)*$";

    // 0으로 시작하지 않는 숫자로만 이루어진 입력
    private static final String PREDICT_BONUS_LOTTO_NUMBER_REGEX = "^[^0]\\d*$";


    /**
     * TODO: 로또 구입 금액 입력
     *
     * @return 로또 구입 금액
     */
    public static int getInput_price() {
        String price = Console.readLine();
        if (!checkPrice_regex(price) || !checkPrice_value(price)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(price);
    }

    /**
     * @param price 사용자가 입력한 로또 구입 금액
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    private static boolean checkPrice_regex(String price) {
        Pattern pattern = Pattern.compile(PRICE_REGEX);
        Matcher matcher = pattern.matcher(price);
        return matcher.matches();
    }

    /**
     * @param price 사용자가 입력한 로또 구입 금액
     * @return 구입 단위가 올바른 경우 true / 올바르지 않은 경우 false
     */
    private static boolean checkPrice_value(String price) {
        return Float.parseFloat(price) % ProgramManager.LOTTO_PRICE == 0;
    }


    /**
     * TODO: 당첨 번호 입력
     *
     * @return 당첨 번호 List
     */
    public static List<Integer> getInput_predictLottoNumber() {
        String userInput_predictLottoNumber = Console.readLine();
        if (!checkPredictLottoNumber_regex(userInput_predictLottoNumber)) {
            throw new IllegalArgumentException();
        }

        List<Integer> predictLottoNumber = convertStringToIntegerList(userInput_predictLottoNumber);
        if (predictLottoNumber.size() != LottoManager.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (!checkPredictLottoNumber_value(predictLottoNumber)) {
            throw new IllegalArgumentException();
        }
        return predictLottoNumber;
    }

    /**
     * @param userInput_predictLottoNumber 사용자가 입력한 당첨 번호
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    private static boolean checkPredictLottoNumber_regex(String userInput_predictLottoNumber) {
        Pattern pattern = Pattern.compile(PREDICT_LOTTO_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(userInput_predictLottoNumber);
        return matcher.matches();
    }

    /**
     * @param userInput_predictLottoNumber 사용자가 입력한 당첨 번호
     * @return 당첨 번호를 쉼표(,) 기준으로 나눈 Integer List
     */
    public static List<Integer> convertStringToIntegerList(String userInput_predictLottoNumber) {
        String[] userInput_values = userInput_predictLottoNumber.split(",");
        List<Integer> predictLottoNumber = new ArrayList<>();
        for (String userInput_value : userInput_values) {
            predictLottoNumber.add(Integer.parseInt(userInput_value));
        }
        return predictLottoNumber;
    }

    /**
     * @param userInput_predictLottoNumber 사용자가 입력한 당첨 번호
     * @return 번호의 범위가 1 ~ 45라면 true / 범위를 벗어났다면 false
     */
    private static boolean checkPredictLottoNumber_value(List<Integer> userInput_predictLottoNumber) {
        for (int i = 0; i < LottoManager.LOTTO_LENGTH; i++) {
            int userInputNumber = userInput_predictLottoNumber.get(i);
            if (userInputNumber < LottoManager.MIN_NUMBER || userInputNumber > LottoManager.MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }


    /**
     * TODO: 보너스 번호 입력
     *
     * @return 보너스 번호
     */
    public static Integer getInput_predictBonusLottoNumber() {
        String userInput_predictBonusLottoNumber = Console.readLine();
        if (!checkPredictBonusLottoNumber_regex(userInput_predictBonusLottoNumber)) {
            throw new IllegalArgumentException();
        }

        int predictBonusLottoNumber = Integer.parseInt(userInput_predictBonusLottoNumber);
        if (!checkPredictBonusLottoNumber_value(predictBonusLottoNumber)) {
            throw new IllegalArgumentException();
        }
        return predictBonusLottoNumber;
    }

    /**
     * @param userInput_predictBonusLottoNumber 사용자가 입력한 보너스 번호
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    private static boolean checkPredictBonusLottoNumber_regex(String userInput_predictBonusLottoNumber) {
        Pattern pattern = Pattern.compile(PREDICT_BONUS_LOTTO_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(userInput_predictBonusLottoNumber);
        return matcher.matches();
    }

    /**
     * @param userInput_predictBonusLottoNumber 사용자가 입력한 보너스 번호
     * @return 번호의 범위가 1 ~ 45라면 true / 범위를 벗어났다면 false
     */
    private static boolean checkPredictBonusLottoNumber_value(int userInput_predictBonusLottoNumber) {
        return userInput_predictBonusLottoNumber >= LottoManager.MIN_NUMBER && userInput_predictBonusLottoNumber <= LottoManager.MAX_NUMBER;
    }

}

package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationCheck {

    /**
     * 입력이 1~9로 시작하여 000으로 끝나는지 확인. 아닐시 IllegalArgumentException 발생
     * @param gamblerInput String 형의 입력값
     */
    public static void checkValidMoneyInput(String gamblerInput){
        boolean isDividedBy1000 = Pattern.matches("^[1-9]+\\d*000$", gamblerInput);
        if (!isDividedBy1000) {
            throw new IllegalArgumentException("1000으로 나누어지는 숫자이어야 합니다.");
        }
    }

    public static void checkDigitAndComma(String winningNumbers) {
        String regexPattern = "^[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+$";
        boolean isRightLottoNumbers = Pattern.matches(regexPattern, winningNumbers);
        if (!isRightLottoNumbers){
            throw new IllegalArgumentException("숫자와 콤마로만 이루어진 \"숫자,숫자,숫자,숫자,숫자,숫자\"형태 이어야 합니다.");
        }
    }

    /**
     * 6개의 숫자가 중복없이 들어왔는지 확인한다.
     * @param winningNumbers 로또 1등 당첨 번호(보너스 번호 제외)
     */
    public static void checkOverlapAndSize(String winningNumbers) {
        List<String> temp = Arrays.asList(winningNumbers.split(","));
        Set<String> delOverlap = new HashSet<>(temp);
        boolean isNoOverlap = delOverlap.size() == 6;
        if (!(isNoOverlap)){
            throw new IllegalArgumentException("6개의 숫자를 중복없이 입력해야 합니다.");
        }
    }

    /**
     * csv의 값이 start이상 end이하인지 확인한다.
     * @param winningNumbers 로또 1등 당첨 번호(보너스 번호 제외)
     * @param start 범위 시작하는 정수(포함)
     * @param end 범위 끝나는 정수(포함)
     */
    public static void isBetweenCertainNumbers(String winningNumbers, int start, int end){
        String[] target = winningNumbers.split(",");
        System.out.println(Arrays.toString(target));
        for (String num: target){
            int current = Integer.parseInt(num);
            if (current < start || current > end){
                throw new IllegalArgumentException("숫자는 1이상 45이하이어야 합니다.");
            }
        }
    }

    public static void isDigit(String bonusNumber){
        boolean isDigit = Pattern.matches("^[0-9]{1,2}$", bonusNumber);
        if (!isDigit) {
            throw new IllegalArgumentException("보너스번호는 숫자로만 이루어져야 합니다.");
        }
    }

    public static void isNotOverlap(String bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.valueOf(bonusNumber))){
            throw new IllegalArgumentException("보너스번호와 중복되는 번호가 존재합니다.");
        }
    }

}

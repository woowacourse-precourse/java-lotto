package lotto;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Validator {

    private final int LENGTH = 6;
    private final int MAX_VALUE = 45;
    private final int MIN_VALUE = 1;
    private final int MONEY_UNIT = 1000;
    private final int MIN_MONEY = 1000;

    public Validator() {

    }
    public void validateMoneyOnlyNumber(String inputMoney){
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, inputMoney)) {
            System.out.println("[ERROR] 금액은 숫자로만 입력해야 합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로만 입력해야 합니다.");
        }
    }

    public void validateMoney(int inputMoney) {
        if(inputMoney<MIN_MONEY){
            throw new IllegalArgumentException("[ERROR] 1000원 이상 내셔야 로또 구매가 가능합니다.");
        }
        if (inputMoney % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해야 합니다.");
        }
    }

    public void validateLottoLength(String[] numbers) {
        if (numbers.length != LENGTH) {
            throw new IllegalArgumentException("[ERROR] 6자리 당첨번호를 입력해야 합니다.");
        }
    }

    public void validateBonus(String bonusInput, List<Integer>numbers) {
        validateBonusOneNumber(bonusInput);
        int bonus = Integer.parseInt(bonusInput);
        validateBonusRange(bonus);
        validateBonusDuplicate(numbers, bonus);
    }

    public void validateBonusDuplicate(List<Integer> numbers, int bonus) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bonus) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해야 합니다.");
            }
        }
    }

    public void validateBonusRange(int bonus) {
        if (bonus > MAX_VALUE || bonus < MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 입력해야 합니다.");
        }
    }

    public void validateBonusOneNumber(String bonusInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, bonusInput)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 '하나의 숫자로만' 입력해야 합니다.");
        }
    }

    public void validateNumbersRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > MAX_VALUE || numbers.get(i) <MIN_VALUE) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자만 입력해야 합니다.");
            }
        }
    }

    public void validateWinningNumbers(String[] numbers) {
        String pattern = "^[0-9]*$";
        String manInput = String.join("",numbers);
        if (!Pattern.matches(pattern, manInput)) {
            throw new IllegalArgumentException("[ERROR] 6개의 '숫자만' 입력하고 ','로 당첨 번호를 구분해야 합니다.");
        }
    }

    public void validateDuplicate(String[] numbers){
        long distinctCount = Stream.of(numbers).distinct().count();
        if(numbers.length != distinctCount){
         throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해야 합니다.");
        }
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String SCOPE_ERROR_MESSAGE = "범위 내에 입력해주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "당첨 번호와 중복됩니다. 다시 입력해주세요.";
    private static final String IS_NUMBER_MESSAGE = "숫자만 입력해주세요.";
    private static final String SCOPE_DUPLICATE_ERROR_MESSAGE = "범위 밖의 숫자 또는 중복된 숫자를 입력하셨습니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "1000으로 나누어 떨어지는 금액을 입력해주세요.";
    private static final String SMALL_AMOUNT_ERROR_MESSAGE = "1000원 이상의 금액을 입력해주세요.";
    private static final String SEPARATOR = ",";

    private static final String REDUNDANT_OR_NON_NUMERIC_CHARACTERS = "중복되거나 숫자가 아닌 문자를 입력하였습니다.";

    public int getMoney(){
        try {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            return validateMoney(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getMoney();
        }
    }

    public Lotto getWinningNumbers(){
        try {
            System.out.println(WINNING_NUMBERS_MESSAGE);
            return new Lotto(validateWinningNumbers(Console.readLine().split(SEPARATOR)));
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers){
        try {
            System.out.println(BONUS_NUMBER_MESSAGE);
            return validateBonusNumber(Console.readLine(), winningNumbers);
        } catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private int validateMoney(String unverifiedMoney) {
        if(!isItANumberOrNot(unverifiedMoney)) errorThrow(IS_NUMBER_MESSAGE);
        int money = Integer.parseInt(unverifiedMoney);
        if(money < 1000) errorThrow(SMALL_AMOUNT_ERROR_MESSAGE);
        if(money % 1000 != 0) errorThrow(DIVIDE_ERROR_MESSAGE);
        return money;
    }

    private List<Integer> validateWinningNumbers(String[] numbers) {
        List<Integer> winningNumbers = null;
        try {
            winningNumbers = Stream.of(numbers)
                    .map(String::trim).map(Integer::parseInt)
                    .filter(num -> num >= 1 && num <= 45)
                    .distinct()
                    .collect(Collectors.toList());
            if(winningNumbers.size() != 6) errorThrow(SCOPE_DUPLICATE_ERROR_MESSAGE);
        }catch (NumberFormatException e){
            errorThrow(REDUNDANT_OR_NON_NUMERIC_CHARACTERS);
        }
        return winningNumbers;
    }

    private int validateBonusNumber(String bonus, List<Integer> winningNumbers) {
        if(!isItANumberOrNot(bonus)) errorThrow(IS_NUMBER_MESSAGE);
        int bonusNumber = Integer.parseInt(bonus);
        if(!(bonusNumber >=1 && bonusNumber <=45)) errorThrow(SCOPE_ERROR_MESSAGE);
        if(winningNumbers.contains(bonusNumber)) errorThrow(DUPLICATE_ERROR_MESSAGE);
        return bonusNumber;
    }

    private boolean isItANumberOrNot(String unverifiedNumber){
        try {
            Integer.parseInt(unverifiedNumber);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private void errorThrow (String error){
        throw new IllegalArgumentException(error);
    }
}

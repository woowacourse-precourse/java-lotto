package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public int getMoney(){
        try {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            String unverifiedMoney = Console.readLine();
            int money = validateMoney(unverifiedMoney);
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getMoney();
        }
    }

    private int validateMoney(String unverifiedMoney) {
        if(!isItANumberOrNot(unverifiedMoney)) errorThrow(IS_NUMBER_MESSAGE);
        int money = Integer.parseInt(unverifiedMoney);
        if(money < 1000) errorThrow(SMALL_AMOUNT_ERROR_MESSAGE);
        if(money % 1000 != 0) errorThrow(DIVIDE_ERROR_MESSAGE);
        return money;
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

    public Lotto getWinningNumbers(){
        System.out.println(WINNING_NUMBERS_MESSAGE);

        String winningNumbers = Console.readLine();

        String[] numbers = winningNumbers.split(SEPARATOR);
        try {
            List<String> winningNumbersCast =
                    Arrays.stream(numbers)
                            .map(String::trim)
                            .collect(Collectors.toList());
            return convertLettersToNumbers(winningNumbersCast);
        }catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers){
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        try {
            validateBonusNumber(bonusNumber, winningNumbers);
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return getBonusNumber(winningNumbers);
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        parseInt(bonusNumber);
        int bonusNum = Integer.parseInt(bonusNumber);
        if(!(bonusNum >=1 && bonusNum <=45)) {
            throw new IllegalArgumentException(SCOPE_ERROR_MESSAGE);
        }
        if(winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void parseInt(String number) {
        try {
            Integer.parseInt(number);
        }catch (Exception e){
            throw new IllegalArgumentException(IS_NUMBER_MESSAGE);
        }
    }

    private Lotto convertLettersToNumbers(List<String> stringWinningAmount) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for(String number : stringWinningAmount){
                winningNumbers.add(Integer.parseInt(number));
            }
            isItInRange(winningNumbers);
            return new Lotto(winningNumbers);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(IS_NUMBER_MESSAGE);
        }
    }

    private void isItInRange(List<Integer> winningNumbers) {
        try {
            int count = (int) winningNumbers.stream().
                    filter(num -> num >= 1 && num <= 45).distinct()
                    .count();
            if(count != 6) {
                throw new IllegalArgumentException(SCOPE_DUPLICATE_ERROR_MESSAGE);
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}

package lotto;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;

public class InputValidator {
    public static final String ERROR = "[ERROR]";
    public static final String INPUT_ONLY_NUMBER = "숫자만 입력해 주세요.";
    public static final String MAKE_DIVISION_WITH_COMMA = "숫자는 , 로 구분해서 입력해주세요.";
    public static final String OBEY_THE_RULE_MONEY_UNIT = "금액은 천원 단위로 입력해주세요.";
    public static final String BONUS_NUMBER_SIZE = "보너스 숫자는 1-45 사이로 입력 해 주세요.";
    public static final String BONUS_CANNOT_OVERLAP_WITH_WINNING_NUMBERS = "보너스 숫자는 당첨 번호와 중복될 수 없습니다.";
    private final String input;
    private final int MONEY_UNIT = 1000;
    public final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]*$");

    public InputValidator(String input){
        this.input = input;
    }

    public int getLottosAmount(){
        int inputMoney;
        inputMoney = changeString(input);
        moneyUnitCheck(inputMoney);
        return inputMoney/MONEY_UNIT;
    }

    public List<Integer> getWinningNumbers(){
        return changeList(input);
    }

    public int getBonusNumbers(List<Integer> winning){
        int inputBonusNumber;
        inputBonusNumber = changeString(input);
        checkBonusNumberRange(inputBonusNumber);
        winningContainsBouns(inputBonusNumber,winning);
        return inputBonusNumber;
    }

    public int changeString(String input){
        checkOnlyNumber(input);
        return Integer.parseInt(input);
    }

    public List<Integer> changeList(String input){
        checkContainsComma(input);
        return Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public void checkOnlyNumber(String input){
        if(!input.matches(ONLY_NUMBER.pattern())){
            throw new IllegalArgumentException(ERROR+INPUT_ONLY_NUMBER);
        }
    }

    public void checkContainsComma(String input){
        if(!input.contains(",")){
            throw new IllegalArgumentException(ERROR+MAKE_DIVISION_WITH_COMMA);
        }
    }

    public void moneyUnitCheck(int money){
        if(!(money % MONEY_UNIT == 0)){
            throw new IllegalArgumentException(ERROR+OBEY_THE_RULE_MONEY_UNIT);
        }
    }

    public void checkBonusNumberRange(int bonusNumber){
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ERROR+BONUS_NUMBER_SIZE);
        }
    }

    public void winningContainsBouns(int bonus, List<Integer> winning){
        if(winning.contains(bonus)){
            throw new IllegalArgumentException(ERROR+BONUS_CANNOT_OVERLAP_WITH_WINNING_NUMBERS);
        }
    }



}

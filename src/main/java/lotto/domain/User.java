package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    //2주차 피드백 반영
    static final String INPUT_MONEY_STR = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_STR = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_STR = "보너스 번호를 입력해 주세요.";
    static final String NOT_NUMBER_ERROR_MSG = "[ERROR] 숫자를 입력해주세요!";
    static final String UNDER_THAN_LOTTO_CHARGE_ERROR_MSG ="[ERROR] 로또 1장의 구매가격은 1000원 입니다! 1000이상의 수를 입력해주세요";
    static final String UNIT_ERROR_MSG ="[ERROR] 1000 단위로 입력해주세요!";
    static final String CIPHER_ERROR_MSG = "[ERROR] 콤마를 기준으로 6자리를 입력해주세요!";
    static final String NOT_NUMBER_ERROR_IN_WINNING_NUMBER_MSG = "[ERROR] 콤마를 기준으로 숫자만 입력해주세요!";
    static final String DUPLICATE_NUMBER_ERROR_MSG = "[ERROR] 중복된 숫자를 입력했습니다!";
    static final String RANGE_ERROR_MSG = "[ERROR] 1~45범위로 숫자를 입력해주세요!";
    static final String DUPLICATE_BONUS_NUMBER_AND_WINNING_NUMBER_ERROR_MSG="[ERROR] 당첨 번호에 없는 숫자를 입력해주세요!";
    static final char CHAR_COMMA = ',';
    static final String STRING_COMMA = ",";
    static final int NUMBER_OF_COMMA = 5;
    static final int LOTTO_CHARGE = 1000;

    private int money;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputMoney() {
        System.out.println(INPUT_MONEY_STR);
        String money = Console.readLine();
        try {
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        this.money = Integer.parseInt(money);
    }

    public void inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBER_STR);
        String winningNumbers = Console.readLine();

        try {
            validateWinningNumbers(winningNumbers);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        this.winningNumbers= new Lotto(convertToList(winningNumbers)).getNumbers();
    }

    public void inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_STR);
        String bonusNumber = Console.readLine();
        try {
            validateBonusNumber(bonusNumber);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> convertToList(String winningNumbers){
        List<Integer> convertWinningNumbers = new ArrayList<>();

        String [] numbers = winningNumbers.split(STRING_COMMA);

        for(String number : numbers){
            convertWinningNumbers.add(Integer.parseInt(number));
        }

        return convertWinningNumbers;
    }

    public void validateMoney(String money) {
        int convertMoney;
        try {
            convertMoney = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MSG);
        }
        if (convertMoney < LOTTO_CHARGE) {
            throw new IllegalArgumentException(UNDER_THAN_LOTTO_CHARGE_ERROR_MSG);
        }
        if(convertMoney % LOTTO_CHARGE != 0){
            throw new IllegalArgumentException(UNIT_ERROR_MSG);
        }
    }

    public void validateWinningNumbers(String winningNumbers){
        if(winningNumbers.chars().filter(c -> c == CHAR_COMMA).count() != NUMBER_OF_COMMA){
            throw new IllegalArgumentException(CIPHER_ERROR_MSG);
        }

        String [] numbers = winningNumbers.split(STRING_COMMA);
        List<String> duplicateCheck = new ArrayList<>();

        for(String number : numbers){
            try {Integer.parseInt(number);
            }catch (NumberFormatException e){throw new IllegalArgumentException(NOT_NUMBER_ERROR_IN_WINNING_NUMBER_MSG);}
            if(duplicateCheck.contains(number)){throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MSG);}
            if(Integer.parseInt(number)<1 || Integer.parseInt(number)>45){throw new IllegalArgumentException(RANGE_ERROR_MSG);}
            duplicateCheck.add(number);
        }
    }

    public void validateBonusNumber(String bonusNumber){
        int convertBonusNumber = 0;
        try{
            convertBonusNumber = Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MSG);
        }

        if(convertBonusNumber<1 || convertBonusNumber>45){
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }

        if(winningNumbers.contains(Integer.parseInt(bonusNumber))){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_AND_WINNING_NUMBER_ERROR_MSG);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getMoney() {
        return money;
    }
}

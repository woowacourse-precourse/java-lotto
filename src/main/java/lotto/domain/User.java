package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    //2주차 피드백 반영
    static final int LOTTO_CHARGE = 1000;

    private int money;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        try {
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        this.money = Integer.parseInt(money);
    }

    public void inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        try {
            validateWinningNumbers(winningNumbers);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        this.winningNumbers= new Lotto(convertToList(winningNumbers)).getNumbers();
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
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

        String [] numbers = winningNumbers.split(",");

        for(String number : numbers){
            convertWinningNumbers.add(Integer.parseInt(number));
        }

        return convertWinningNumbers;
    }

    public void validateMoney(String money) {
        int convertMoney = 0;
        try {
            convertMoney = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요!");
        }
        if (convertMoney < LOTTO_CHARGE) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 구매가격은 1000원 입니다! 1000이상의 수를 입력해주세요");
        }
        if(convertMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000 단위로 입력해주세요!");
        }
    }

    public void validateWinningNumbers(String winningNumbers){
        if(winningNumbers.chars().filter(c -> c == ',').count() != 5){
            throw new IllegalArgumentException("[ERROR] 콤마를 기준으로 6자리를 입력해주세요!");
        }

        String [] numbers = winningNumbers.split(",");
        List<String> duplicateCheck = new ArrayList<>();

        for(String number : numbers){
            try {Integer.parseInt(number);
            }catch (NumberFormatException e){throw new IllegalArgumentException("[ERROR] 콤마를 기준으로 숫자만 입력해주세요!");}
            if(duplicateCheck.contains(number)){throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다!");}
            if(Integer.parseInt(number)<1 || Integer.parseInt(number)>45){throw new IllegalArgumentException("[ERROR] 1~45범위로 숫자를 입력해주세요!");}
            duplicateCheck.add(number);
        }
    }

    public void validateBonusNumber(String bonusNumber){
        int convertBonusNumber = 0;
        try{
            convertBonusNumber = Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 한 개의 숫자만 입력해주세요!");
        }

        if(convertBonusNumber<1 || convertBonusNumber>45){
            throw new IllegalArgumentException("[ERROR] 1~45범위로 숫자를 입력해주세요!");
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

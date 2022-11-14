package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.UserValidate;

import java.util.ArrayList;
import java.util.List;

public class User {
    //2주차 피드백 반영
    static final String INPUT_MONEY_STR = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_STR = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_STR = "보너스 번호를 입력해 주세요.";
    static final String STRING_COMMA = ",";

    private int money;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    UserValidate userValidate = new UserValidate();

    public void inputMoney() {
        System.out.println(INPUT_MONEY_STR);
        String money = Console.readLine();
        try {
            userValidate.validateMoney(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        this.money = Integer.parseInt(money);
    }

    public void inputWinningNumbers(){
        // 실행 결과 예시와 맞추기 위해 한 칸 띄우기
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_STR);
        String winningNumbers = Console.readLine();

        try {
            userValidate.validateWinningNumbers(winningNumbers);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        this.winningNumbers= new Lotto(convertToList(winningNumbers)).getNumbers();
    }

    public void inputBonusNumber(){
        // 실행 결과 예시와 맞추기 위해 한 칸 띄우기
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_STR);
        String bonusNumber = Console.readLine();
        try {
            userValidate.validateBonusNumber(winningNumbers,bonusNumber);
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

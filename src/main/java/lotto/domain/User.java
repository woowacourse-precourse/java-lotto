package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    //2주차 피드백 반영
    static final int LOTTO_CHARGE = 1000;

    private int money;
    private List<Integer> winningNumbers;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        try {
            this.money = convertToInt(money);
            validateMoney(this.money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        this.winningNumbers=convertToList(winningNumbers);
    }

    public int convertToInt(String money) {
        validateMoney(money);

        return Integer.parseInt(money);
    }

    public List<Integer> convertToList(String winningNumbers){
        List<Integer> convertWinningNumbers = new ArrayList<>();

        String [] numbers = winningNumbers.split(",");

        for(String number : numbers){
            convertWinningNumbers.add(Integer.parseInt(number));
        }

        return convertWinningNumbers;
    }

    public void validateMoney(int money) {
        if (money < LOTTO_CHARGE) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 구매가격은 1000원 입니다! 1000이상의 수를 입력해주세요");
        }
    }

    public void validateMoney(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요!");
        }
    }
}

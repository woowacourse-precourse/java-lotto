package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Input {
    private final int MONEY_UNIT = 1000;
    private final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    public int getMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine().trim();

        if(!isValidMoney(input)){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    //Validator 클래스
    public boolean isNumber(String input) {
//        return input.chars().allMatch(Character::isDigit);
        //방법2
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidMoney(String input) {
        if (!isNumber(input)) {
            return false;
        }

        int money = Integer.parseInt(input);
        return money%MONEY_UNIT ==0;
    }



    public List<Integer> getWinningNumbers() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();

        if(!input.contains(",")){
            throw new IllegalArgumentException();
        }

        List<Integer> winningNumbers = new ArrayList<>();

        for(String number : input.split(",")){
            isNumber(number);
            winningNumbers.add(Integer.valueOf(number));
            }

        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String input = Console.readLine().trim();

        isNumber(input);
        return Integer.parseInt(input);
    }
}

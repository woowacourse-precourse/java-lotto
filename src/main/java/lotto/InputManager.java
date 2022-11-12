package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class InputManager {

    public List<Integer> getWinningNum() {
        String input = Console.readLine();
        List<String> temp = List.of(input.split(","));
        List<Integer> lotto = new ArrayList<Integer>();
        for (String temp_ : temp) {
            isNumberInRange(temp_);
            isInputOnlyNumber(temp_);
            lotto.add(Integer.parseInt(temp_));
        }
        return lotto;
    }
    public int getBounusNum()
    {
        String input = Console.readLine();
        isInputOnlyNumber(input);
        return Integer.parseInt(input);
    }

    private int purchaseAmount() {
        String input = Console.readLine();
        int temp = Integer.parseInt(input);
        if (temp % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] purchase Amount can't be divided by 1000");
        }
        return temp % 1000;
    }

    //입력한 숫자가 (1, 45) 인 수인지 검증 
    protected void isNumberInRange(String inputString) {
        int temp = Integer.parseInt(inputString);
        if (temp > 45) {
            throw new IllegalArgumentException("[ERROR] input bigger than 45");
        }
        if (temp < 1) {
            throw new IllegalArgumentException("[ERROR] input smaller than 1");
        }
    }
    protected void isInputOnlyNumber(String inputStirng)
    {
        String pattern = "[0-9]{1}|^[1-3]{1}[0-9]{1},";
        if(!Pattern.matches(pattern, inputStirng))
        {
            throw new IllegalArgumentException("[ERROR] input including other characters");
        }
    }
}

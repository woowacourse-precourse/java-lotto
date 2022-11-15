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
            isInputOnlyNumber(temp_);
            isNumberInRange(temp_);
            if (lotto.contains(temp_)) {
                System.out.println("Duplicated number!");
                throw new IllegalArgumentException("[ERROR] Duplicated number!");
            }
            lotto.add(Integer.parseInt(temp_));
        }
        return lotto;
    }

    public int getBounusNum() {
        String input = Console.readLine();
        isInputOnlyNumber(input);
        return Integer.parseInt(input);
    }

    protected int purchaseAmount() {
        String input = Console.readLine();
        if (isInputOnlyNumber(input) == false) {
            return 0;
        }
        int temp = Integer.parseInt(input);
        if (temp % 1000 != 0) {
            System.out.println("[ERROR] purchase Amount can't be divided by 1000");
            throw new IllegalArgumentException("[ERROR] purchase Amount can't be divided by 1000");
        }
        return temp / 1000;
    }

    // 입력한 숫자가 (1, 45) 인 수인지 검증
    protected void isNumberInRange(String inputString) {
        int temp = Integer.parseInt(inputString);
        if (temp > 45) {
            System.out.println("[ERROR] input bigger than 45");
            throw new IllegalArgumentException("[ERROR] input bigger than 45");
        }
        if (temp < 1) {
            System.out.println("[ERROR] input smaller than 1");
            throw new IllegalArgumentException("[ERROR] input smaller than 1");
        }
    }

    protected boolean isInputOnlyNumber(String inputStirng) {
        String pattern = "^[0-9]+$";
        if (!Pattern.matches(pattern, inputStirng)) {
            System.out.println("[ERROR] input including other characters");
            // throw new IllegalArgumentException();
            return false;
        }
        return true;
    }
}

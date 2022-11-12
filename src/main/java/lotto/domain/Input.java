package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public int inputPurchase() {
        int input = isNumber(Console.readLine());
        validate(input);
        return input / 1000;
    }

    public void validate(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야합니다.");
        }
    }

    public List<Integer> inputLottoNumber() {
        List<Integer> number = new ArrayList<>();
        String input = Console.readLine();
        String[] inputNumber = input.split(",");
        for (String s : inputNumber) {
            number.add(isNumber(s));
        }
        return number;
    }

    public int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해야 합니다." + e.getMessage());
        }
        return 0;
    }
}

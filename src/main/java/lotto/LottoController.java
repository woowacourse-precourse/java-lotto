package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void validate(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

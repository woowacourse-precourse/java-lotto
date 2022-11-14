package util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Inputer {

    public int money() throws IllegalArgumentException {
        String input = Console.readLine();
        int money;
        if(!validate(input)) {
            throw new IllegalArgumentException("[ERROR] : Invalid argument!");
        }
        money = Integer.parseInt(input);
        if(!isMultiofThousand(money)) {
            throw new IllegalArgumentException("[ERROR] : Invalid argument!");
        }
        return money;
    }

    private boolean validate(String data) {
        for(int i = 0 ; i < data.length() ; i++) {
            if(!Character.isDigit(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMultiofThousand(int data) {
        if(data % 1000 != 0 || data <= 0) {
            return false;
        }
        return true;
    }


}

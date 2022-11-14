package util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Inputer {

    public int moneyandCount() throws IllegalArgumentException {
        String input = Console.readLine();
        int money;
        if(!validate(input)) {
            throw new IllegalArgumentException("[ERROR] : Invalid argument!");
        }
        money = Integer.parseInt(input);
        if(!isMultiofThousand(money)) {
            throw new IllegalArgumentException("[ERROR] : Invalid argument!");
        }
        return money / 1000;
    }

    public List<Integer> lotto() throws IllegalArgumentException {
        String input = Console.readLine();
        List<Integer> result = splitToken(input);
        for(int data : result) {
            if(!validToken(data)) {
                throw new IllegalArgumentException("[ERROR] : Invalid argument!");
            }
        }
        return result;
    }

    private List<Integer> splitToken(String data) {
        List<String> preresult = List.of(data.split(","));
        List<Integer> result = new ArrayList<>();
        for(String token : preresult) {
            if(!validate(token)) {
                throw new IllegalArgumentException("[ERROR] : Invalid argument!");
            }
            result.add(Integer.parseInt(token));
        }
        return result;
    }

    private boolean validate(String data) {
        for(int i = 0 ; i < data.length() ; i++) {
            if(!Character.isDigit(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validToken(int data) {
        if(data <= 0) {
            return false;
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

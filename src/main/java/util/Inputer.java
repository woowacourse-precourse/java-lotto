package util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Inputer {

    List<Integer> lottoNumbers;

    public int moneyandCount() throws IllegalArgumentException {
        String input = Console.readLine();
        int money;
        if(!validate(input)) {
            System.out.println("[ERROR] : Invalid argument!");
            throw new IllegalArgumentException();
        }
        money = Integer.parseInt(input);
        if(!isMultiofThousand(money)) {
            System.out.println("[ERROR] : Invalid argument!");
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public void inputlotto() throws IllegalArgumentException {
        String input = Console.readLine();
        lottoNumbers = splitToken(input);
        for(int data : lottoNumbers) {
            if(!validToken(data)) {
                System.out.println("[ERROR] : Invalid argument!");
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Integer> splitToken(String data) {
        List<String> preresult = List.of(data.split(","));
        List<Integer> result = new ArrayList<>();
        for(String token : preresult) {
            if(!validate(token)) {
                System.out.println("[ERROR] : Invalid argument!");
                throw new IllegalArgumentException();
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

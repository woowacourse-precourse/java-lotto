package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputMoney() {
        String input = Console.readLine();
        validateNumber(input);
        int price = Integer.parseInt(input);
        validateUnitIs1000(price);
        return price;
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException exception) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateUnitIs1000(int input) {
        if(!(input%1000==0)){
            System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

}

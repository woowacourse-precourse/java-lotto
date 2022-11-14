package lotto.verifier;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseManager {

    public int askAmountOfMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validateInput(input);

        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        if(!isDecimal(input)) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        if(!isThousandUnit(input)) {
            throw new IllegalArgumentException("천원 단위로 입력해야 합니다. ex) 14000");
        }
    }

    private boolean isDecimal(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isThousandUnit(String input) {
        int money = Integer.parseInt(input);
        return money % 1000 == 0;
    }
}

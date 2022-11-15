package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class InputView {
    public static int inputLottoAmount() {
        String money = Console.readLine();
        if(!money.matches("^[0-9]+$")) {
            try{
                int amount = parseInt(money);
                if(amount % 1000 != 0) {
                    System.out.println("[ERROR] 1000원 단위로 구입해야 합니다.");
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입해야 합니다.");
                }
                return amount;
            } catch (NumberFormatException exception) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
}

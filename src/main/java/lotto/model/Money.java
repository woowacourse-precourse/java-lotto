package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Error.*;

public class Money {
    public static int money;
    public static int numberOfLottos;

    public static int getMoney() throws IllegalStateException{
        String playerInput = Console.readLine();
        playerInput = playerInput.trim();

        validateNumbers(playerInput);

        money = Integer.parseInt(playerInput);
        validate(money);
        numberOfLottos = money / 1000;
        return money;
    }

    private static void validate(int money) throws IllegalStateException{
        if (money % 1000 != 0) {
            //throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException(Error.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    /*
        private static void validateNumbers(String playerInput){
            try{
                Integer.parseInt(playerInput);
            }catch (Exception e){
                throw new IllegalArgumentException(Error.INVALID_NUMBER_COUNT.getMessage());
            }

        }
    */
    private static boolean validateNumbers(String playerInput) throws IllegalStateException{
        try {
            Integer.parseInt(playerInput);
            return true;
        } catch (Exception ex) {
            //
        }
        return false;
    }


}

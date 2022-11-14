package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    public static int money;
    public static int numberOfLottos;
    public static int getMoney() {
        String playerInput = Console.readLine();
        validate(playerInput);
        money = Integer.parseInt(playerInput);
        validate(money);
        numberOfLottos = money/1000;
        return money;
    }

    private static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    private static boolean validate(String playerInput){
        try {
            Integer.parseInt(playerInput);
            return true;
        } catch (Exception ex) {
            throw new IllegalArgumentException("[ERROR]숫자가 아닌 값을 포함하고 있습니다.");
        }

    }

    /*public void numberOfLottos(){
        //Randoms.pickUniqueNumbersInRange(1,45,6);
    }*/

}

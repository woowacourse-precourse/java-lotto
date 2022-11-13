package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.BaseLotto;

public class Game {

    private User user = new User();


    public void gameStart(){
        System.out.println(BaseLotto.INPUTVALUE.getDescription());
        String input = Console.readLine();
        user.purchaseLotto(input);
    }
}

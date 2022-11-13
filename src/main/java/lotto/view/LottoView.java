package lotto.view;

import static lotto.LottoConstant.GAME_START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    public String getLottoPurchaseAmount(){
        return Console.readLine();
    }
}

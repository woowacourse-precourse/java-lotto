package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoPurAmount;

public class InputController {
    public void insertLottoAmount() {
        String str = Console.readLine();
        Integer lottopuramount = Integer.parseInt(str);
        LottoPurAmount lottoPurAmount = new LottoPurAmount(lottopuramount);
    }
}

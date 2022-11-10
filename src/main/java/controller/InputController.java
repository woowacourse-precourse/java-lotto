package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoPurAmount;

public class InputController {
    public Integer insertLottoAmount() {
        String stringpuramount = Console.readLine();
        Integer lottopuramount = Integer.parseInt(stringpuramount);
        return lottopuramount;
    }
}

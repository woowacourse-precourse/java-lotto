package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoPurAmount;

public class InputController {
    public Integer insertLottoAmount() {
        String stringpuramount = Console.readLine();
        Integer lottopuramount = Integer.parseInt(stringpuramount);
        return lottopuramount;
    }

    public boolean checkDigitPrice(String lottopuramount) {
        boolean result = true;
        for(int i=0; i<lottopuramount.length(); i++) {
            if(!Character.isDigit(lottopuramount.charAt(i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}

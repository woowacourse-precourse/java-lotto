package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoPurAmount;

public class InputController {
    public Integer insertLottoAmount() {
        String stringpuramount = Console.readLine();
        Integer lottopuramount = Integer.parseInt(stringpuramount);
        checkDigitPrice(stringpuramount);
        checkDevidePrice(lottopuramount);
        return lottopuramount;
    }

    public void checkDigitPrice(String lottopuramount) {
        for(int i=0; i<lottopuramount.length(); i++) {
            if(!Character.isDigit(lottopuramount.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkDevidePrice(Integer lottopuramount) {
        if(lottopuramount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

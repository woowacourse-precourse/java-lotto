package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoPurAmount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public List<Integer> makeLottoNumber() {
        List<Integer> lottonumber = new ArrayList<>();
        while (lottonumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottonumber.contains(randomNumber)) {
                lottonumber.add(randomNumber);
            }
        }
        lottonumber.sort(Comparator.naturalOrder());
        return lottonumber;
    }

}

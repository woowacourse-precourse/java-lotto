package lotto.verifiable;

import lotto.Prize;

import java.util.Collections;
import java.util.List;

public class CheckPrize implements Verifiable<Prize>{
    @Override
    public Integer checkWithValue(Prize input) {
//        compare with this
        List<Integer> numbersWithBonus = input.getNumberWithBonusNumber();
        List<Integer> purchaseNumber = input.getNumber();
        int cnt = 0;
        for (Integer number : numbersWithBonus) {
            if(Collections.frequency(purchaseNumber, number)>0){
                cnt++;
            }
        }
        return cnt;
    }

}

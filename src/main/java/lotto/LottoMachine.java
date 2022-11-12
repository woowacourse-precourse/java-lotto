package lotto;

import lotto.Lotto;
import lotto.Util;
import lotto.LottoBuyer;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public static void buyLotto(List<Lotto> lottos, BigInteger money){
        while(money.equals(BigInteger.ZERO) != true){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (Util.isDuplicate(numbers) == false){
                Collections.sort(numbers);
                lottos.add(new Lotto(numbers));
                money = money.subtract(BigInteger.valueOf(1000));
            }
        }
    }
}

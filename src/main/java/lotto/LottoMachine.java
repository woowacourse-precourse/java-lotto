package lotto;

import java.util.Iterator;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public static int buyLotto(List<Lotto> lottos, final BigInteger money) {
        BigInteger tmpMoney = new BigInteger(money.toString());

        while (!tmpMoney.equals(BigInteger.ZERO)) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (!Util.isDuplicate(numbers)) {
                lottos.add(new Lotto(numbers));
                tmpMoney = tmpMoney.subtract(BigInteger.valueOf(1000));
            }
        }
        int buyCount = lottos.size();
        return buyCount;
    }

    public static void printLottoLog(List<Lotto> lottos) {
        Iterator<Lotto> lottosIter = lottos.iterator();

        while (lottosIter.hasNext()) {
            Lotto lotto = lottosIter.next();
            List<Integer> tmpLotto = new ArrayList<>(lotto.getLottoNumbers());
            Collections.sort(tmpLotto);
            System.out.println(tmpLotto);
        }
    }

}

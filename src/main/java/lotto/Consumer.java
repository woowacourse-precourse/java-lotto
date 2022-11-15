package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Consumer {
    private static List<Lotto> lottos;

    Consumer() {
        lottos = new ArrayList<>();
    }

    public static void buyLotto() {
        LottoConsoleIo.printRequestPurchase();
        String inputValue = LottoConsoleIo.scanInputValue();
        ValidCheck.formatCheckPrice(inputValue);
        for (int i = 0; i < Integer.parseInt(inputValue); i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        LottoConsoleIo.printNoOfLotto(lottos);
    }
    public static List<Integer> calcStat(Lotto winNumber, int bonus) {
        List<Integer> stat = List.of(0,0,0,0,0,0);
        HashSet winNumbers = new HashSet(winNumber.getNumbers());
        for (Lotto lotto:lottos) {
            HashSet<Integer> myNumbers = new HashSet(lotto.getNumbers());
            myNumbers.retainAll(winNumbers);
            if (myNumbers.size()<3){
                continue;
            }
            if (myNumbers.size()==5 && winNumbers.contains(bonus)) {
                stat.set(4, stat.get(4)+1);
                continue;
            }
            stat.set(myNumbers.size()-3, stat.get(myNumbers.size()-3)+1);
        }
        return stat;
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Consumer {

    private static final List<Integer> STATISTICS_INIT = List.of(0,0,0,0,0,0);
    private static final int LOTTO_PRICE = 1_000;
    private static final int PROFIT_IND = 5;

    private static List<Lotto> lottos;

    Consumer(Lotto lotto) {
        lottos = new ArrayList<>(List.of(lotto));
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
        List<Integer> stat = new ArrayList<>(STATISTICS_INIT);
        HashSet winNumbers = new HashSet(winNumber.getNumbers());
        for (Lotto lotto:lottos) {
            HashSet<Integer> myNumbers = new HashSet(lotto.getNumbers());
            myNumbers.retainAll(winNumbers);
            if (Prize.sizeToInd(myNumbers.size())<Prize.THREE.getIndex()){
                continue;
            }
            if (Prize.sizeToInd(myNumbers.size())==Prize.FIVE.getIndex()
                    && winNumbers.contains(bonus)) {
                stat.set(Prize.FIVE.getIndex(), stat.get(Prize.FIVE.getIndex())+1);
                continue;
            }
            stat.set(Prize.sizeToInd(myNumbers.size()), stat.get(Prize.sizeToInd(myNumbers.size())+1));
        }
        return stat;
    }

    public static List<Integer> calcProfit(List<Integer> stat){
        float moneySpent = lottos.size()*LOTTO_PRICE;
        float moneyEarned = 0;
        for (Prize p:Prize.getList()) {
            moneyEarned = moneyEarned + p.getReward()*stat.get(p.getIndex());
        }
        stat.set(PROFIT_IND, Math.round(moneyEarned/moneySpent*100)/100);
        return stat;
    }

}

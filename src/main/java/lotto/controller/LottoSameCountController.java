package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoSameCountController {

    private final List<Integer> RANK_COUNT_LIST = new ArrayList<>();
    private final int SUM_MONEY;


    public LottoSameCountController(LottoListController lottolist,
        UserNumbersController usernumbers) {
        this.RANK_COUNT_LIST.addAll(List.of(0, 0, 0, 0, 0));
        for (Lotto lotto : lottolist.getLOTTO_LIST()) {
            AddRankCountList(RankCalculation(lotto, usernumbers.getNUMBERS(),
                usernumbers.getBONUS_NUMBER()));
        }
        this.SUM_MONEY = sumMoney();
    }

    private int sumMoney() {
        int sum = 0;
        sum += RANK_COUNT_LIST.get(0) * 2000000000;
        sum += RANK_COUNT_LIST.get(1) * 30000000;
        sum += RANK_COUNT_LIST.get(2) * 1500000;
        sum += RANK_COUNT_LIST.get(3) * 50000;
        sum += RANK_COUNT_LIST.get(4) * 5000;
        return sum;
    }

    private void AddRankCountList(int rank) {
        int index = rank - 1;
        if (rank != 0) {
            RANK_COUNT_LIST.set(index, RANK_COUNT_LIST.get(index) + 1);
        }
    }

    private int RankCalculation(Lotto userlotto, Lotto answerlotto, int bonusNumber) {
        int samecount = SameCount(userlotto, answerlotto);
        System.out.println(userlotto.getNumbers());
        if (Rank2validate(samecount, userlotto.getNumbers(), bonusNumber)) {
            return 2;
        }
        return otherRank(samecount);
    }

    private int SameCount(Lotto userlotto, Lotto answerlotto) {
        Lotto userlotoclone = new Lotto(userlotto.getNumbers());
        userlotoclone.getNumbers().retainAll(answerlotto.getNumbers());
        return userlotoclone.getNumbers().size();
    }

    private boolean Rank2validate(int samecount, List<Integer> userlotto, int bonusNumber) {
        if (samecount == 5) {
            return userlotto.contains(bonusNumber);
        }
        return false;
    }

    private int otherRank(int samecount) {
        if (samecount == 3) {
            return 5;
        }
        if (samecount == 4) {
            return 4;
        }
        if (samecount == 5) {
            return 3;
        }
        if (samecount == 6) {
            return 1;
        }
        return 0;
    }

    public List<Integer> getRANK_COUNT_LIST() {
        return RANK_COUNT_LIST;
    }

    public int getSUM_MONEY() {
        return SUM_MONEY;
    }


}

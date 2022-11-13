package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.WinningPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    ArrayList<Lotto> lottoReceipt = new ArrayList<>();

    int count = 0;

    //makeProcess
    public int makeLottoCount(int money) {
        count = money / 1000;
        return count;
    }

    public void makeLottoReceipt() {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lottoReceipt.add(lotto);
        }
    }

    public ArrayList<Lotto> getLottoReceipt() {
        return lottoReceipt;
    }

    public List<WinningPrize> makeStatistics(int bonus, Lotto answerValue) {
        ArrayList<WinningPrize> prize = new ArrayList<>();
        for (Lotto lotto : lottoReceipt) {
            prize.add(calculateLotto(answerValue, lotto, bonus));
        }
        return prize;
    }

    public WinningPrize calculateLotto(Lotto answer, Lotto lotto, int bonus) {
        int lottoCount = 0;
        boolean getBonus = false;
        ArrayList<Integer> answerValue = answer.getLotto();
        ArrayList<Integer> lottoValue = lotto.getLotto();
        for (Integer lottoNumber : lottoValue) {
            if (answerValue.contains(lottoNumber))
                lottoCount++;
            if (lottoNumber == bonus)
                getBonus = true;
        }
        return judgeLotto(lottoCount, getBonus);
    }

    public WinningPrize judgeLotto(int lottoCount, boolean getBonus) {
        if (lottoCount == 6)
            return WinningPrize.SIX;
        if (lottoCount == 5 && getBonus)
            return WinningPrize.FIVEWITHBONUS;
        if (lottoCount == 5)
            return WinningPrize.FIVE;
        if (lottoCount == 4)
            return WinningPrize.FOUR;
        if (lottoCount == 3)
            return WinningPrize.THREE;
        return WinningPrize.OTHER;
    }

}

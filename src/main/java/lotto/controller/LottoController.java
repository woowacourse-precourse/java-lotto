package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.MyLottoList;
import lotto.model.MyPrize;
import lotto.model.PrizeLotto;
import lotto.constant.LottoInfo;
import lotto.constant.RankInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    public static MyLottoList generateMyLottoListInstance() {
        return new MyLottoList();
    }

    public static PrizeLotto generatePrizeLottoInstance() {
        return new PrizeLotto();
    }

    public static MyPrize generateMyPrizeInstance(MyLottoList myLottoList, PrizeLotto prizeLotto) {
        int [] rankArr = traversalLottoList(myLottoList, prizeLotto);
        return new MyPrize(rankArr);
    }

    //━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    public static void setMyLottoListLotto(MyLottoList myLottoList) {
        List<Lotto> temp = new ArrayList<>();
        for(int i=0 ; i<myLottoList.getCount() ; i++) {
            temp.add(generateOneLotto());
        }
        myLottoList.setLotto(temp);
    }

    public static void setMyLottoListMoney(MyLottoList myLottoList, int money) {
        myLottoList.setCount(money);
    }

    public static void setPrizeLotto(PrizeLotto prizeLotto, List<Integer> prizeNum) {
        Lotto tempLotto = new Lotto(prizeNum);
        prizeLotto.setPrizeLotto(tempLotto);
    }

    public static void setBonusNum(PrizeLotto prizeLotto, int bonusNum) {
        prizeLotto.setBonusNumber(bonusNum);
    }

    public static Lotto generateOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoInfo.START_NUMBER, LottoInfo.END_NUMBER, LottoInfo.TOTAL_COUNT);
        sortAscendingOrder(numbers);
        return new Lotto(numbers);
    }

    public static void sortAscendingOrder(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>(numbers);
        Collections.sort(temp);
        numbers = temp;
    }

    public static int [] traversalLottoList(MyLottoList myLottoList, PrizeLotto prizeLotto) {
        int [] rankArr = new int[LottoInfo.REWARD_RANK_COUNT+1];
        for(Lotto lotto : myLottoList.getLotto()) {
            int rank = calculateRankOneLotto(lotto, prizeLotto);
            if(rank <= LottoInfo.REWARD_RANK_COUNT) {
                rankArr[rank] = rankArr[rank] + 1;
            }
        }

        return rankArr;
    }

    public static int calculateRankOneLotto(Lotto lotto, PrizeLotto prizeLotto) {
        int correctNum = 0;
        int rank = 0;
        for(int num : lotto.getNumbers()) {
            if(prizeLotto.getPrizeLotto().getNumbers().contains(num)) {
                correctNum += 1;
            }
        }
        rank = calculateRankByBonusNum(lotto, correctNum, prizeLotto.getBonusNumber());
        return rank;
    }

    public static int calculateRankByBonusNum(Lotto lotto, int correctNum, int BonusNum) {
        boolean isContainBonus = false;
        if(lotto.getNumbers().contains(BonusNum)) {
            isContainBonus = true;
        }

        for(RankInfo eachRankInfo : RankInfo.values()) {
            if(correctNum == eachRankInfo.getCorrect() && isContainBonus == eachRankInfo.isBonus()) {
                return eachRankInfo.getRank();
            }
        }

        return Integer.MAX_VALUE;
    }

    public static String calculateProfitRate(long Amount, int money) {
        double profit = (Amount / (double)money) * 100;
        return String.format("%.1f", profit);
    }
}

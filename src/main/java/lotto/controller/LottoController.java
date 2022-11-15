package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.MyLottoList;
import lotto.MyPrize;
import lotto.PrizeLotto;
import lotto.constant.LottoInfo;
import lotto.constant.Rank;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    public static MyLottoList generateMyLottoListInstance(int money) {
        return new MyLottoList(money);
    }

    public static void setMyLottoListLotto(MyLottoList myLottoList) {
        List<Lotto> temp = new ArrayList<>();
        for(int i=0 ; i<myLottoList.getCount() ; i++) {
            temp.add(generateOneLotto());
        }
        myLottoList.setLotto(temp);
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

    public static PrizeLotto generatePrizeLottoInstance() {
        Lotto prizeLotto = new Lotto(LottoView.inputPrizeLotto());
        return new PrizeLotto(prizeLotto);
    }

    public static void setBonusNum(PrizeLotto prizeLotto, int bonusNum) {
        prizeLotto.setBonusNumber(bonusNum);
    }

    public static MyPrize generateMyPrizeInstance(MyLottoList myLottoList, PrizeLotto prizeLotto) {
        int [] rankArr = new int[LottoInfo.REWARD_RANK_COUNT+1];
        for(Lotto lotto : myLottoList.getLotto()) {
            int rank = calculateRankOneLotto(lotto, prizeLotto);
            if(rank <= LottoInfo.REWARD_RANK_COUNT) {
                rankArr[rank] = rankArr[rank] + 1;
            }
        }
        return new MyPrize(rankArr);
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

        for(Rank eachRank : Rank.values()) {
            if(correctNum == eachRank.getCorrect() && isContainBonus == eachRank.isBonus()) {
                return eachRank.getRanking();
            }
        }

        return Integer.MAX_VALUE;
    }
}

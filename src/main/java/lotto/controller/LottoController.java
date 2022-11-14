package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.MyLottoList;
import lotto.PrizeLotto;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    public static MyLottoList generateMyLottoInstance(int money) {
        return new MyLottoList(money);
    }

    public static Lotto generateOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortAscendingOrder(numbers);
        return new Lotto(numbers);
    }

    public static void sortAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public static void generateMyLottoList(MyLottoList myLottoList) {
        List<Lotto> tempList = new ArrayList<>();
        for(int i=0 ; i<myLottoList.getNumber() ; i++) {
            tempList.add(generateOneLotto());
        }
        myLottoList.setLotto(tempList);
    }

    public static PrizeLotto generatePrizeLottoInstance() {
        Lotto prizeLotto = new Lotto(LottoView.inputPrizeLotto());
        return new PrizeLotto(prizeLotto);
    }

    public static void addBonusNum(int bonusNum, PrizeLotto prizeLotto) {
        prizeLotto.setBonusNumber(bonusNum);
    }

    public static void generateMyPrizeInstance(MyLottoList myLottoList, PrizeLotto prizeLotto) {
        int [] rankArr = new int[6];
        for(Lotto lotto : myLottoList.getLotto()) {
            int rank = calculateRankOneLotto(lotto, prizeLotto);
            if(rank <= 5) {
                rankArr[rank] = rankArr[rank] + 1;
            }
        }
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
        if(correctNum <= 4) {
            return 8 - correctNum;
        }

        if(correctNum == 6) {
            return 1;
        }

        if(correctNum == 5) {
            if(lotto.getNumbers().contains(BonusNum)) {
                return 2;
            }

            return 3;
        }
        return 10;
    }
}

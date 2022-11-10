package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class IssuingMachine {

    public List<Lotto> allIssuedLottery = new ArrayList<>();

    public List<Lotto> makeLotteryList(int quantity) {
        for (int i=0; i < quantity; i++) {
            List<Integer> lotteryNumbers = makeOneLottery();
            Lotto lotto = new Lotto(lotteryNumbers);
            allIssuedLottery.add(lotto);
        }

        return allIssuedLottery;
    }

    private List<Integer> makeOneLottery() {
        ArrayList<Integer> lottery = new ArrayList<>(); // 궁금 : 이거 근데 <Integer> 왼쪽 오른쪽에 넣는거 무슨 차이가 있는거임???

//        int[] allNumbers = new int[45];
//        Arrays.fill(allNumbers, 0);
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return integers;
    }


}

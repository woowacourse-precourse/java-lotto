package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class LottoWin {
    static LottoWin lotto;
    private List<Integer> lottoNum;

    private LottoWin(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        this.lottoNum = numbers;
    }

    public static LottoWin getInstance() {
        if(lotto == null){ //최초 한번만 new 연산자를 통하여 메모리에 할당한다.
            lotto = new LottoWin();
        }
        return lotto;
    }

//    수익률은 당첨금액/구입금액*100
    public void profitRateCal(List<int[]> result){
        final int expenseIndex = 0;
        final int profitIndex = 1;
        double profitRate;
        int expenseSum = 0;
        int profitSum = 0;
        for(int[] userInfo : result){
            expenseSum += userInfo[expenseIndex];
            profitSum += userInfo[profitIndex];
        }
        profitRate = ((double)profitSum / expenseSum) * 100;
        System.out.println(String.format("%.2f", profitRate));
    }

    public List<Integer> getLottoNum() {
        return lottoNum;
    }
}

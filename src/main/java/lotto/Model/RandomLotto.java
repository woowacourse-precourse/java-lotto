
package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomLotto {

    static ArrayList<List<Integer>> lottoNumberList = new ArrayList<>();

    static int money = Money.getInputMoney();
    static int lottoCount = money/1000;
    private static final String BUY_SENTENCE = lottoCount + "개를 구매했습니다.";

    public static ArrayList<List<Integer>> getLottoNumberList() {
        return lottoNumberList;
    }

    public static void BuyNewLotto() {
        System.out.println(BUY_SENTENCE);
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers;
            lottoNumbers = pickUniqueNumbersInRange(1, 45 ,6);
            System.out.println(lottoNumbers);
            lottoNumberList.add(lottoNumbers);
        }
    }

}

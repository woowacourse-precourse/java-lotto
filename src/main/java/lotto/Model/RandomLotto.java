package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomLotto {

    static ArrayList<List<Integer>> bundleOfLottoNumbers;

    static int money = Money.getInputMoney();
    static int lottoCount = money/1000;
    private static final String BUY_SENTENCE = lottoCount + "개를 구매했습니다.";

    public static ArrayList<List<Integer>> getBundleOfLottoNumbers() {
        return bundleOfLottoNumbers;
    }

    public static void BuyNewLotto() {
        bundleOfLottoNumbers = new ArrayList<>();
        System.out.println(BUY_SENTENCE);
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
            bundleOfLottoNumbers.add(lottoNumbers);
        }
    }

}


package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomLotto {

    public static ArrayList<List> getLottoNumberList() {
        return lottoNumberList;
    }

    static ArrayList<List> lottoNumberList = new ArrayList<>();

    static int money = Money.getInputMoney();
    static int countLotto = money/1000;

    public static void BuyNewLotto() {
        for(int i = 0; i < countLotto; i++) {
            List<Integer> lottoNumbers;
            lottoNumbers = pickUniqueNumbersInRange(1, 45 ,6);
            System.out.println(lottoNumbers);
            lottoNumberList.add(lottoNumbers);
        }
    }

}

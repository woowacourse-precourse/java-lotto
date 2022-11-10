package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class User {

    public static int lottoMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;
    Validator validator = new Validator();

    public int inputLottoPurchaseMoney(){
        lottoMoney = Integer.parseInt(Console.readLine());
        validator.validateMoneyInput(lottoMoney);
        return lottoMoney/PRICE_PER_LOTTO;
    }

    public List<Integer> createLottoOneGameNumber() {
        List<Integer> oneGameNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        oneGameNumbers.sort(Integer::compareTo);
        return oneGameNumbers;
    }
}
package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoConst.LOTTO_PRICE;

public class LottoMachine {
    static int userMoney;
    static int lottoCount;

    LottoMachine(int userMoney){
        Error.purchasePrice(userMoney);

        this.userMoney = userMoney;
        this.lottoCount = userMoney / LOTTO_PRICE;
    }

    static Lotto createLotto(){
        List<Integer> newLotto;
        newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Arrays.stream(newLotto.toArray())
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(newLotto);
    }
}

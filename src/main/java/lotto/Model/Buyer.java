package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Constants.Error;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.Constants.Number;
import lotto.Utils.Convert;

public class Buyer {

    private final int money;
    private final List<Lotto> number = new ArrayList<>();

    public Buyer(final String money) {
        this.money = Convert.StrToInt(money);
        isThousandUnit(this.money);
        makeAutoNumber();
    }

    private void isThousandUnit(final int money) {
        if (money % Number.THOUSAND_UNIT != Number.ZERO || money == Number.ZERO) {
            throw new IllegalArgumentException(Error.THOUSAND_UNIT);
        }
    }

    private void makeAutoNumber() {
        int ticket = money / Number.THOUSAND_UNIT;
        for (int piece = 0; piece < ticket; piece++) {
            number.add(new Lotto(new ArrayList<>(createRandomLottoNum())));
        }
    }

    private List<Integer> createRandomLottoNum() {
        return Randoms.pickUniqueNumbersInRange(Number.START_NUM, Number.END_NUM, Number.LIST_SIZE);
    }

    public List<Lotto> getLottoNumber() {
        return number;
    }

    public int getBuyerMoney() {
        return money;
    }
}

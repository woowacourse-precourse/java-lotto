package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Message;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Utils.Convert;

public class Buyer {

    private static final int THOUSAND_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int COUNT = 6;
    private final int money;
    private List<Lotto> number = new ArrayList<>();

    public Buyer(final String money) {
        this.money = Convert.StrToInt(money);
        isThousandUnit(this.money);
        makeAutoNumber();
    }

    private void isThousandUnit(final int money) {
        if (money % THOUSAND_UNIT != ZERO || money == 0) {
            throw new IllegalArgumentException(Message.ERROR_THOUSAND_UNIT.getMessage());
        }
    }

    private void makeAutoNumber() {
        int ticket = money / THOUSAND_UNIT;
        for (int piece = 0; piece < ticket; piece++) {
            number.add(new Lotto(new ArrayList<>(createRandomLottoNum())));
        }
    }

    private List<Integer> createRandomLottoNum() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
    }

    public List<Lotto> getLottoNumber() {
        return number;
    }

    public int getBuyerMoney() {
        return money;
    }
}

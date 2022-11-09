package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public static final String INVALID_MONEY_INPUT =
            "구매 금액은 1,000 단위로 나누어 떨어져야 합니다.";
    public static final String INVALID_STRING_INPUT =
            "숫자만 입력할 수 있습니다.";

    public static final Integer LOTTO_PRICE = 1000;
    private Integer money;


    public Integer inputMoney() {
        String money = Console.readLine();
        validateMoney(money);
        this.money = Integer.parseInt(money);
        return this.money;
    }

    private void validateMoney(String money) {
        try {
            Integer nMoney = Integer.parseInt(money);
            if (nMoney % LOTTO_PRICE != 0) {
                LottoError.illegalArgumentException(INVALID_MONEY_INPUT);
            }
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE);
    }

    private Lotto createLotto() {
        return new Lotto(createLottoNumbers());
    }

    public List<Lotto> sellLotto() {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    public void printSellLotto(List<Lotto> lotto) {
        System.out.println("\n" + lotto.size() + "개를 구매했습니다.");
        for (Lotto l : lotto) {
            System.out.println(l);
        }
    }


}

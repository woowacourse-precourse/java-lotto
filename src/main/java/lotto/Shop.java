package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Shop {

    private static final String INVALID_MONEY_INPUT =
            "구매 금액은 1,000 단위로 나누어 떨어져야 합니다.";
    private static final String INVALID_STRING_INPUT =
            "숫자만 입력할 수 있습니다.";
    private Integer money;
    private List<Lotto> lottos;

    public void inputMoney() {
        String money = Console.readLine();
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        try {
            Integer nMoney = Integer.parseInt(money);
            if (nMoney % 1000 != 0) {
                LottoError.illegalArgumentException(INVALID_MONEY_INPUT);
            }
        } catch (NumberFormatException ignored) {
            LottoError.illegalArgumentException(INVALID_STRING_INPUT);
        }
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}

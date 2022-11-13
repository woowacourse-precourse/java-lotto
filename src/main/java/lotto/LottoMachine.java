package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private List<Lotto> lottoList;
    private long investment;

    private static int lottoPrice = 1000;

    public void buyLotto(String input) {
        validatePrice(input);
        lottoList = new ArrayList<>();
        for (int i = 0; i < investment / lottoPrice; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private void validatePrice(String price) {
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
            }
        }
        investment = Long.parseLong(price);
        if (investment % lottoPrice != 0 || investment / lottoPrice <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 " + lottoPrice +
                    "원 이상의 " + lottoPrice + "원 단위 금액이어야 합니다.");
        }
    }

    public int getLottoCount() {
        return lottoList.size();
    }
}

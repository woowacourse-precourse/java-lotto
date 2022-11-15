package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;

public class Prize {

    static final String ENTER_MONEY = "구매금액을 입력해 주세요.";
    static final String PURCHASE_LOTTO = "%d개를 구매했습니다.";
    static final int LOTTO_COUNT = 1000;

    public Prize() {
        Integer lottoCount = purchaseLotto();
        System.out.printf(PURCHASE_LOTTO, lottoCount);
        makeMyLotto();
    }

    public Integer purchaseLotto(){
        System.out.println(ENTER_MONEY);
        String inputMoney = Console.readLine();
        validateMoney(inputMoney);
        int money = Integer.parseInt(inputMoney);
        return money / LOTTO_COUNT;
    }

    public void makeMyLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(numbers);
    }

    private void validateMoney(String moneyValue) {
        if (Objects.equals(moneyValue, "")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 입력해 주세요.");
        }

        try {
            Integer.parseInt(moneyValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }

        int money = Integer.parseInt(moneyValue);
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 최소 단위는 1,000원 입니다.");
        }
    }
}

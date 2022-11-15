package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.BoughtLotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<BoughtLotto> lottos;
    private static final Integer LOTTO_PRICE = 1000;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void buyLottos() {
        int money = inputMoney();
        int countOfBuyLotto = money / LOTTO_PRICE;
        for (int i = 0; i < countOfBuyLotto; i++) {
            lottos.add(new BoughtLotto());
        }
    }

    private void validateMoney(String money) {
        if (!checkInputInteger(money)) {
            throw new IllegalArgumentException("[ERROR] 금액은 자연수여야 합니다.");
        }
        if (!checkInputNumber(money)) {
            throw new IllegalArgumentException("[ERROR] 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
        }
    }

    public void printLottos() {
        int countOfLotto = lottos.size();
        System.out.println(countOfLotto + "개를 구매했습니다.");
        for (BoughtLotto lotto : lottos) {
            printOneLotto(lotto);
        }
    }

    private void printOneLotto(BoughtLotto lotto) {
        lotto.printLottoNumber();
    }

    public List<BoughtLotto> getLottos() {
        return lottos;
    }

    private int inputMoney() {
        printInputMessage();
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    private void printInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private boolean checkInputInteger(String money) {
        try {
            Integer.parseInt(money);

        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private boolean checkInputNumber(String money) {
        return Integer.parseInt(money) % LOTTO_PRICE == 0;
    }
}

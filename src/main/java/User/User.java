package User;

import camp.nextstep.edu.missionutils.Console;
import lotto.BoughtLotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<BoughtLotto> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void buyLottos() {
        int money = inputMoney();
        if (!validateMoney(money)) {
           throw new IllegalArgumentException("[ERROR] 금액은 1000원단위여야 합니다.");
        }
        int countOfBuyLotto = money / 1000;
        for (int i = 0; i < countOfBuyLotto; i++) {
            lottos.add(new BoughtLotto());
        }
    }

    private boolean validateMoney(int money) {
        return money % 1000 == 0;
    }

    public void printLottos() {
        int countOfLotto = lottos.size();
        System.out.println(String.valueOf(countOfLotto) + "개를 구매했습니다.");
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
}

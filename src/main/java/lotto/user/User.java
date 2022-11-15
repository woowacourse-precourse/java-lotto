package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.BoughtLotto;
import lotto.user.validation.ValidationPurchasePrice;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final Integer LOTTO_PRICE = 1000;

    List<BoughtLotto> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public void buyLottos() {
        long money = inputPurchasePrice();
        long countOfBuyLotto = money / LOTTO_PRICE;
        for (int i = 0; i < countOfBuyLotto; i++) {
            lottos.add(new BoughtLotto());
        }
    }

    private void printInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private long inputPurchasePrice() {
        printInputMessage();
        String input = Console.readLine();
        validatePurchasePrice(input);
        return Long.parseLong(input);
    }

    private void validatePurchasePrice(String money) {
        ValidationPurchasePrice validationPurchasePrice = ValidationPurchasePrice.validate(money);
        if (validationPurchasePrice.getIsThrow()) {
            String errorMessage = validationPurchasePrice.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void printLottos() {
        int countOfLotto = lottos.size();
        System.out.println("\n" + countOfLotto + "개를 구매했습니다.");
        for (BoughtLotto lotto : lottos) {
            printOneLotto(lotto);
        }
        System.out.println();
    }

    private void printOneLotto(BoughtLotto lotto) {
        lotto.printLottoNumber();
    }

    public List<BoughtLotto> getLottos() {
        return lottos;
    }
}

package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;

public class UserService {
    LottoService lottoService = new LottoService();

    public User buyLotto() {
        int purchaseMoney = scanPayMoney();
        int purchaseLottoPiece = purchaseMoney / LOTTO_PRICE;
        List<Lotto> purchaseLotto = issueLotto(purchaseLottoPiece);
        return new User(purchaseMoney, purchaseLottoPiece, purchaseLotto);
    }

    private List<Lotto> issueLotto(int purchaseLottoNum) {
        List<Lotto> tempGeneratedLotto = new ArrayList<>();
        for (int buy = 0; buy < purchaseLottoNum; buy++) {
            Lotto issuedLotto = lottoService.issueLotto();
            tempGeneratedLotto.add(issuedLotto);
        }
        return tempGeneratedLotto;
    }

    public void printBoughtLotto(User user) {
        StringBuilder printString = new StringBuilder();
        printString.append(BLANK_BR); //한줄 공백
        printString.append(user.getPurchaseLottoPiece()).append(PURCHASE_MSG).append("\n");
        for (Lotto now : user.getPurchaseLotto()) {
            printString.append(now).append("\n");
        }
        System.out.println(printString);
    }

    public int scanPayMoney() {
        System.out.println(START_MSG);
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        return money;
    }

    public void validateMoney(int money) {
        if (money % LOTTO_PRICE == 0) return;
        throw new IllegalArgumentException(PAY_MONEY_ERROR);
    }

}

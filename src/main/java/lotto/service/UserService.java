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

    public int scanPayMoney() {
        System.out.println(START_MSG);
        int money = stringToInter(Console.readLine());
        validateMoney(money);
        return money;
    }

    public int stringToInter(String scanNum) {
        int money;
        try {
            money = Integer.parseInt(scanNum);
        } catch (Exception NumberFormatException) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR);
        }
        return money;
    }

    public void validateMoney(int money) {
        if (0 <= money && money % LOTTO_PRICE == 0) {
            return;
        }
        throw new IllegalArgumentException(PAY_MONEY_ERROR);
    }

    public List<Lotto> issueLotto(int purchaseLottoPiece) {
        List<Lotto> tempIssuedLottos = new ArrayList<>();
        for (int buy = 0; buy < purchaseLottoPiece; buy++) {
            Lotto issuedLotto = lottoService.issueLotto();
            tempIssuedLottos.add(issuedLotto);
        }
        return tempIssuedLottos;
    }

    public void printBoughtLottos(User user) {
        StringBuilder printBoughtLotto = new StringBuilder();
        printBoughtLotto.append(BLANK_BR); //한줄 공백
        printBoughtLotto.append(user.getPurchaseLottoPiece()).append(PURCHASE_CNT_MSG).append(BLANK_BR);
        for (Lotto lotto : user.getPurchaseLotto()) {
            printBoughtLotto.append(lotto).append("\n");
        }
        System.out.println(printBoughtLotto);
    }

}

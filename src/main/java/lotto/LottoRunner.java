package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoChecker;
import lotto.domain.Seller;
import lotto.domain.User;

public class LottoRunner {

    private final LottoChecker lottoChecker;
    private final Seller seller;

    public LottoRunner(LottoChecker lottoChecker, Seller seller) {
        this.lottoChecker = lottoChecker;
        this.seller = seller;
    }

    public void run() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            User user = new User(Console.readLine());
            seller.sellLotto(user);
            lottoChecker.decideAnswerLotto();
            lottoChecker.checkUserLottoList(user);
            lottoChecker.tellAnswerToUser(user);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}

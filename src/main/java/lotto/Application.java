package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoGame;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        int lottoCost = user.receiveInput();
        if (lottoCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }

        LottoGame lottoGame = new LottoGame();
        int lottoNumber = lottoGame.countLotto(lottoCost);
        System.out.println(lottoNumber+"개를 구매했습니다.");
    }
}

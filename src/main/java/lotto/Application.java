package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCost = Integer.parseInt(Console.readLine());

        LottoGame lottoGame = new LottoGame();
        int lottoNumber = lottoGame.countLotto(lottoCost);
        System.out.println(lottoNumber+"개를 구매했습니다.");

    }
}

package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LotteryShop;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int totalPayment = Integer.parseInt(readLine());

        LotteryShop lotteryShop = new LotteryShop();
        int totalLottoCnt = lotteryShop.countLotto(totalPayment);
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(totalLottoCnt + "개를 구매했습니다.");
        for (int i = 0; i < totalLottoCnt; i++) {
            List<Integer> lottoNum = lotteryShop.makeLotto();
            lottos.add(new Lotto(lottoNum));
            System.out.println(lottoNum);
        }
    }
}

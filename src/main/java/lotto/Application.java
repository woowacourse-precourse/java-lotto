package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Correct;
import lotto.domain.Draw;
import lotto.domain.LotteryShop;
import lotto.domain.Lotto;
import lotto.domain.RateOfProfit;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(readLine());

        LotteryShop lotteryShop = new LotteryShop();
        int totalLottoCnt = lotteryShop.countLotto(amount);
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(totalLottoCnt + "개를 구매했습니다.");
        for (int i = 0; i < totalLottoCnt; i++) {
            List<Integer> lottoNum = lotteryShop.makeLotto();
            lottos.add(new Lotto(lottoNum));
            System.out.println(lottoNum);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winNum = Arrays.asList(readLine().split(","));

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(readLine());

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i).getNumbers();
            Correct correctType = (Correct) Draw.findCorrectType(lotto, winNum, bonusNum);
            correctType.setCnt(correctType.getCnt() + 1);

        }
        System.out.println("3개 일치 (5,000원) - " + Correct.THREE.getCnt() + "개");
        System.out.println("4개 일치 (50,000원) - " + Correct.FOUR.getCnt() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + Correct.FIVE.getCnt() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Correct.FIVE_BONUS.getCnt() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Correct.SIX.getCnt() + "개");
        System.out.println(String.format("%,.2f%%입니다.", RateOfProfit.calculate(amount)));
    }
}

package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Confirm;
import lotto.domain.CorrectNum;
import lotto.domain.Draw;
import lotto.domain.LotteryShop;
import lotto.domain.Lotto;
import lotto.domain.RateOfProfit;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Confirm.validateDigit(readLine()));
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
                CorrectNum correctNumType = (CorrectNum) Draw.findCorrectType(lotto, winNum, bonusNum);
                correctNumType.setCnt(correctNumType.Cnt() + 1);
            }
            System.out.println("3개 일치 (5,000원) - " + CorrectNum.THREE.Cnt() + "개");
            System.out.println("4개 일치 (50,000원) - " + CorrectNum.FOUR.Cnt() + "개");
            System.out.println("5개 일치 (1,500,000원) - " + CorrectNum.FIVE.Cnt() + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + CorrectNum.FIVE_BONUS.Cnt() + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + CorrectNum.SIX.Cnt() + "개");
            System.out.println(String.format("총 수익률은 %.1f%%입니다.", RateOfProfit.calculate(amount)));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

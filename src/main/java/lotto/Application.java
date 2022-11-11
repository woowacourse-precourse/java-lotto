package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        String input = readLine();
        Exception.validatePayMoney(input);
        long payMoney = Long.parseLong(input);

        long number = payMoney / 1000;
        System.out.println("\n" + number + "개를 구매했습니다.");

        List<Lotto> myLottos = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            List<Integer> myLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(myLotto);
            myLottos.add(new Lotto(myLotto));
        }

        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        input = readLine();
        Exception.validateComputerLotto(input);
        Lotto computerLotto = new Lotto(Arrays.asList(input.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList()));

        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        input = readLine();
        Exception.validateBonusBall(input, computerLotto);
        int bonus = Integer.parseInt(input);


        System.out.println("\n" + "당첨 통계" + "\n" + "---");
        Referee referee = new Referee();
        for(Lotto myLotto : myLottos) {
            int correctNumberCount = referee.getCorrectNumberCount(computerLotto, myLotto);
            referee.plusCorrectNumberCount(correctNumberCount, myLotto, bonus);
        }

        Calculate calculate = new Calculate();
        DecimalFormat decFormat = new DecimalFormat("###,###");
        for(Rank rank : Rank.values()) {
            if(rank.getMatchNumber() == 5 && rank.getPrize() == 30000000) {
                System.out.println(rank.getMatchNumber() + "개 일치, 보너스 볼 일치 (" + decFormat.format(rank.getPrize()) + "원) - " + rank.getCount() + "개");
            }
            System.out.println(rank.getMatchNumber() + "개 일치 (" + decFormat.format(rank.getPrize()) + "원) - " + rank.getCount() + "개");
        }
        long lotteryWinningPrize = calculate.getLotteryWinningPrize();
        double totalLotteryWinningPrizeProfit = calculate.getTotalLotteryWinningPrizeProfit(lotteryWinningPrize, payMoney);
        System.out.println("총 수익률은 " + totalLotteryWinningPrizeProfit + "%입니다.");
    }
}

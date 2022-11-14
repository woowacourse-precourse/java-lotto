package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.Validator;

public class GameConsole {

    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public int inputPurchase(){
        notice(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        Validator.purchase(purchase);

        return Integer.parseInt(purchase);
    }

    public List<Integer> inputWinningNumber(){
        notice(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        Validator.winningNumbers(winningNumber);

        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void notice(String inputMessage) {
        System.out.println(inputMessage);
    }

    public int inputBonusNumber(){
        notice(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        Validator.bonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void outputLottos(int lottoCount, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputResult(Result result){
        outputGameResult(result);
        outputWinningAmount(result);
    }

    private void outputGameResult(Result result) {
        System.out.println("\n당첨 통계\n---");

        Map<Rank, Integer> rankInfo = result.sortedRankInfo();
        rankInfo.remove(Rank.NONE);

        for (Rank rank : rankInfo.keySet()) {
            System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            if (rank == Rank.SECOND){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
            }
        }
    }

    private void outputWinningAmount(Result result) {
        System.out.printf("총 수익률은 %.1f%%입니다.", result.getWinningAmount());
    }
}

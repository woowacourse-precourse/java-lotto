package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Play {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_MESSAGE = "당첨 통계\n" +"---";
    private static final String RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private Purchase purchase = new Purchase();
    private LottoNumbers lottoNumbers = new LottoNumbers();
    private WinningNumber winningNumber = new WinningNumber();
    private Result result = new Result();
    private int total;
    private int prize;
    private String bonus;

    public void startPlay(){
        try {
            inputAmount();
            List<Lotto> lottos = generateLotto();
            List<Integer> winningLottos = inputWinningNumber();
            bonus = inputBonusNumber();
            Map<ResultType,Integer> totalResults = makeResult(lottos, winningLottos, bonus);
            printResult(totalResults);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void printResult(Map<ResultType, Integer> totalResult) {
        System.out.println("\n"+WINNING_MESSAGE);
        result.printResult(totalResult);
        double profit = result.calculateProfit(total,prize);
        System.out.printf(RATE_MESSAGE, profit);
    }

    private Map<ResultType, Integer> makeResult(List<Lotto> lottos, List<Integer> winLotto, String bonus) {
        Map<ResultType, Integer> totalResults = result.calculateLotto(lottos, winLotto, bonus);
        prize = result.makePrize(totalResults);
        return totalResults;
    }

    private String inputBonusNumber() {
        System.out.println("\n"+INPUT_BONUS_MESSAGE);
        bonus = Console.readLine();
        winningNumber.checkBonus(bonus);
        return bonus;
    }

    private List<Integer> inputWinningNumber() {
        System.out.println("\n"+INPUT_WINNING_MESSAGE);
        String winning = Console.readLine();
        return winningNumber.saveWinningNumber(winning);
    }

    private List<Lotto> generateLotto() {
        List<Lotto> lottos = lottoNumbers.printLotto(total/1000);
        lottoNumbers.displayLotto(lottos);
        return lottos;
    }

    private void inputAmount() {
        System.out.println(START_MESSAGE);
        String amount = Console.readLine();
        total = purchase.checkAmount(amount);
        System.out.println("\n"+(total/1000)+CHECK_MESSAGE);
    }

}

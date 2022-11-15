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
    private List<Lotto> lotto;
    private List<Integer> winLotto;
    private Map<ResultType,Integer> totalResult;

    public void startPlay(){
        try {
            result.calculateProfit(12000, 5000);
            inputAmount();
            generateLotto();
            winLotto = inputWinningNumber();
            bonus = inputBonusNumber();
            totalResult = makeResult(winLotto, bonus);
            printResult(totalResult);
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

    private Map<ResultType, Integer> makeResult(List<Integer> winLotto, String bonus) {
        totalResult = result.calculateLotto(lotto, winLotto, bonus);

        prize = result.makePrize(totalResult);
        return totalResult;
    }

    private String inputBonusNumber() {
        System.out.println("\n"+INPUT_BONUS_MESSAGE);
        String bonus = Console.readLine();
        winningNumber.checkBonus(bonus);
        return bonus;
    }

    private List<Integer> inputWinningNumber() {
        System.out.println("\n"+INPUT_WINNING_MESSAGE);
        String winning = Console.readLine();
        List<Integer> winLotto = winningNumber.saveWinningNumber(winning);
        return winLotto;
    }

    private void generateLotto() {
        lotto = lottoNumbers.printLotto(total/1000);
        lottoNumbers.displayLotto(lotto);
    }

    private void inputAmount() {
        System.out.println(START_MESSAGE);

        String amount = Console.readLine();
//        try{
//            total = purchase.checkAmount(amount);
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        total = purchase.checkAmount(amount);
        System.out.println("\n"+(total/1000)+CHECK_MESSAGE);
    }


}

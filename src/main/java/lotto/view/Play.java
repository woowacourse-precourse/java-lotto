package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
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
    private List<Lotto> lotto = new ArrayList<>();
    private WinningNumber winningNumber = new WinningNumber();
    private String[] savedWinningNumber = new String[6];
    private Result result = new Result();
    private int total = 0;

    public void startPlay(){
        System.out.println(START_MESSAGE);

        String amount = Console.readLine();
        try{
            total = purchase.calculateAmount(amount);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n"+(total/1000)+CHECK_MESSAGE);
        lotto = lottoNumbers.printLotto(total/1000);
        lottoNumbers.displayLotto(lotto);

        System.out.println("\n"+INPUT_WINNING_MESSAGE);
        String winning = Console.readLine();

        Lotto winningLotto = new Lotto(winningNumber.numberToString(winning));

        List<Integer> winLotto = winningNumber.numberToString(winning);

        System.out.println("\n"+INPUT_BONUS_MESSAGE);
        String bonus = Console.readLine();
        winningNumber.checkBonus(bonus);


        Map<ResultType,Integer> totalResult = result.calculateLotto(lotto,winLotto,bonus);


//        System.out.println(result.makePrize(totalResult));
        int prize = result.makePrize(totalResult);

        System.out.println("\n"+WINNING_MESSAGE);
        result.printResult(totalResult);
        double profit = result.calculateRate(total,prize);
        System.out.printf(RATE_MESSAGE, profit);

    }


}

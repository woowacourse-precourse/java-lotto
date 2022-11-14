package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Play {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_MESSAGE = "당첨 통계\n" +"---";
    private static final String RATE_MESSAGE = "총 수익률은 %f%입니다.";

    private Purchase purchase = new Purchase();
    private LottoNumbers lottoNumbers = new LottoNumbers();
    private List<Lotto> lotto = new ArrayList<>();
    private WinningNumber winningNumber = new WinningNumber();
    private String[] savedWinningNumber = new String[6];
    private Result result = new Result();

    public void startPlay(){
        System.out.println(START_MESSAGE);

        String amount = Console.readLine();
        int total = 0;
        try{
            total = purchase.calculateAmount(amount);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n"+total+CHECK_MESSAGE);
        lotto = lottoNumbers.printLotto(total);
        lottoNumbers.displayLotto(lotto);

        System.out.println("\n"+INPUT_WINNING_MESSAGE);
        String winning = Console.readLine();

        Lotto winningLotto = new Lotto(winningNumber.numberToString(winning));
        System.out.println(winningLotto.getLotto());

        List<Integer> winLotto = winningNumber.numberToString(winning);

        System.out.println("\n"+INPUT_BONUS_MESSAGE);
        String bonus = Console.readLine();
        winningNumber.checkBonus(bonus);


        Map<ResultType,Integer> totalResult = result.calculateLotto(lotto,winLotto,bonus);

        result.printResult(totalResult);

        System.out.println(result.makePrize(totalResult));
        int prize = result.makePrize(totalResult);
        System.out.println("\n"+WINNING_MESSAGE);

        System.out.println(result.calculateRate(total,prize));

    }


}

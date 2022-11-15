package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class DrawLotto {

    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    private static final String WIN_STATISTIC = "당첨 통계\n---\n";

    private static final String[] MATCH_STRING = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    };

    private static final LottoNumber lottoNumber = new LottoNumber();
    private static final WinningNumber winningNumber = new WinningNumber();
    private static final LottoStatus lottoStatus = new LottoStatus();

    private static Exception exception;

    public void init(){
        int userMoney = getUserMoney();
        List<List<Integer>> lottoNumberLists;
        lottoNumberLists = lottoNumber.getLottoNumberList(getUserLottoCount(userMoney));
        lottoNumber.outputLottoNumberList(getUserLottoCount(userMoney), lottoNumberLists);

        List<Integer> winningNumbers;
        winningNumbers = winningNumber.initWinningNumber();
        Integer bonusNumber = winningNumber.initBonusNumber();

        int[] result = lottoStatus.countTheNumberOfWinning(getUserLottoCount(userMoney), lottoNumberLists, winningNumbers, bonusNumber);
        double winRate = getRateOfReturn(userMoney, result);

        showResult(result, winRate);
    }

    private static int getUserMoney(){
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        try {
            exception.checkMoneyIncludeString(money);
            exception.checkMoney(money);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(money);
    }

    private static int getUserLottoCount(int money){
        return (money/LOTTO_PRICE);
    }

    // 수익률 계산 로직
    private static double getRateOfReturn(int userMoney, int[] result){
        int[] winAmount = {5000, 50000, 1500000, 30000000, 2000000000};
        double amountMoney = 0;
        for(int i=0; i<5; i++){
            amountMoney += (winAmount[i] * result[i]);
        }

        return (double)Math.round((amountMoney/userMoney)*1000)/10;
    }

    private static void showResult(int[] result, double winRate){
        StringBuilder sb = new StringBuilder();
        sb.append(WIN_STATISTIC);
        for(int i=0; i<5; i++){
            sb.append(MATCH_STRING[i] + result[i] + "개\n");
        }
        sb.append("총 수익률은 " + winRate + "%입니다.");
        System.out.println(sb);
    }
}
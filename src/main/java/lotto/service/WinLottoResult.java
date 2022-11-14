package lotto.service;

import lotto.Data.LottoEnum;
import lotto.Data.UserMoney;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.List;

public class WinLottoResult {
    InputBonusNumber inputBonusNumber = new InputBonusNumber();
    public static int profitMoney;
    public void checkWinLottoResult(List<Integer> answerLotto, List<List<Integer>> lottoList) {
        Output output = new Output();

        output.winStatistics();
        int[] checkWinPrice = new int[lottoList.size()];
        for(int i = 0; i < lottoList.size(); i++){
            checkWinPrice[i] = compareLottos(answerLotto, lottoList.get(i));
        }
        lottoResultChart(checkWinResult(checkWinPrice));
    }

    private int[] checkWinResult(int[] checkWinPrice) {
        int[] checkWinResult = new int[LottoEnum.values().length];

        for(int i = 0; i < checkWinPrice.length; i++){
            if(checkWinPrice[i]%10 == 3){ checkWinResult[0] += 1;}
            if(checkWinPrice[i]%10 == 4){ checkWinResult[1] += 1;}
            if(checkWinPrice[i] == 5){ checkWinResult[2] += 1;}
            if(checkWinPrice[i] == 15){ checkWinResult[3] += 1;}
            if(checkWinPrice[i]%10 == 6){ checkWinResult[4] += 1;}
        }
        return checkWinResult;
    }

    private int compareLottos(List<Integer> answerLotto, List<Integer> lottoList ) {
        int count = 0;
        for(int i = 0; i < lottoList.size(); i++){
            if(lottoList.get(i) == Integer.parseInt(inputBonusNumber.INPUT_BONUS_NUMBER)) {
                count += 10;
            }
            if(answerLotto.contains(lottoList.get(i))) count++;

        }
        return count;
    }
    public void lottoResultChart(int[] lottoResult) {
        Output output = new Output();

        output.fifthPlace(lottoResult[0]);
        output.fourthPlace(lottoResult[1]);
        output.thirdPlace(lottoResult[2]);
        output.secondPlace(lottoResult[3]);
        output.firstPlace(lottoResult[4]);
    }
    public void calBenefit(int profitMoney, UserMoney userMoney) {
        Output output = new Output();
        double userInputMoney = userMoney.getMoney();
        double answer = (profitMoney) / userInputMoney;

        double yield = Math.round(answer*1000)/10.0;

        output.totalBenefit(yield);
    }
}

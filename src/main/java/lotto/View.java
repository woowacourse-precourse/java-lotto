package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import lotto.LottoEnum.LottoReward;

public class View {
    public static String Input() {
        return Console.readLine();
    }

    public static void Output(String message) {
        System.out.println(message);
    }

    public static void OutputArrayList(ArrayList<Integer> arraylist) {
        for (Integer I : arraylist) {
            System.out.println(I);
        }
    }

    public static void PrintResult(LinkedHashMap<Integer, Integer> lottoResult) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        for (int i = 5; 0 < i; i--) {
            Integer correctNumber = LottoReward.GetCorrectNumberByRank(i);
            Integer result = lottoResult.get(i);
            Integer reward = LottoReward.GetRewardByRank(i);

            // 3자리마다 콤마
            String rewardPrint = formatter.format(reward);

            if (i == 2) {
                View.Output(correctNumber + "개 일치, 보너스 볼 일치 (" + rewardPrint + "원) - " + result + "개");
            }

            if (i != 2) {
                View.Output(correctNumber + "개 일치 (" + rewardPrint + "원) - " + result + "개");
            }
        }
    }
}

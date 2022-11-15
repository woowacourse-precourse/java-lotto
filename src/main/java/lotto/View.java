package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.LottoEnum.LottoReward;

public class View {
    public static String Input() {
        return Console.readLine();
    }

    public static void OutputString(String message) {
        System.out.println(message);
    }

    public static void OutputListIntegerInList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    /**
     * 당첨 통계 내역을 출력하는 메소드
     * @param lottoResult 로또 번호 분석 결과
     */
    public static void PrintResult(LinkedHashMap<Integer, Integer> lottoResult) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        for (int i = 5; 0 < i; i--) {
            Integer correctNumber = LottoReward.GetCorrectNumberByRank(i);
            Integer result = lottoResult.get(i);
            Integer reward = LottoReward.GetRewardByRank(i);

            // 3자리마다 콤마
            String rewardPrint = formatter.format(reward);

            if (i == 2) {
                View.OutputString(correctNumber + "개 일치, 보너스 볼 일치 (" + rewardPrint + "원) - " + result + "개");
            }

            if (i != 2) {
                View.OutputString(correctNumber + "개 일치 (" + rewardPrint + "원) - " + result + "개");
            }
        }
    }
}

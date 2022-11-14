package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Auto;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {

    public String getUserInput(String changeWord) {
        System.out.println("\n" + changeWord);
        return Console.readLine();
    }

    public void showAutoLottos(List<List<Integer>> autoLottos, int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (List<Integer> autoLotto : autoLottos) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(autoLotto.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n3개 일치 (5,000원) - " + Rank.FIFTH.getCount() + "개\n4개 일치 (50,000원) - " + Rank.FOURTH.getCount() + "개\n5개 일치 (1,500,000원) - " + Rank.THIRD.getCount() + "개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Rank.SECOND.getCount() + "개\n6개 일치 (2,000,000,000원) - " + Rank.FIRST.getCount() + "개\n");
        sb.append("총 수익률은 " + String.format("%.1f", Auto.YIELD) + "%입니다.");
        System.out.println("\n" + sb);
    }
}

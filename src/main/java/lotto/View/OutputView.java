package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoResult;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printTotalLotto(List<Lotto> totalLotto) {
        System.out.println(totalLotto.size() + "개를 구매했습니다.");

        for (Lotto lotto : totalLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningResult(Map<Integer, Integer> resultMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoResult lottoResult : LottoResult.values()) {
            String result = createResult(lottoResult, resultMap);
            stringBuilder.append(result)
                    .append('\n');
        }

        System.out.print(stringBuilder.toString());
    }

    private String createResult(LottoResult lottoResult, Map<Integer, Integer> resultMap) {
        String result = "";
        int key = lottoResult.getValue();

        result = lottoResult.getMessage();
        if (resultMap.containsKey(key)) {
            int value = resultMap.get(key);
            result += " - " + value + "개";
        }

        if (!resultMap.containsKey(key)) {
            result += " - " + 0 + "개";
        }

        return result;
    }

    public void printEarningRate(double rate) {
        System.out.print("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}

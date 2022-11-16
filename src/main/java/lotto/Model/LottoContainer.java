package lotto.Model;

import java.util.List;
import java.util.ArrayList;

public class LottoContainer {

    private static List<Lotto> lottoBundle;

    public LottoContainer(List<Lotto> lottoBundle) {
        LottoContainer.lottoBundle = lottoBundle;
    }

    public List<Integer> getAnswerCompareResult(Lotto answer) {
        List<Integer> returnResult = new ArrayList<>();

        for (Lotto lotto : lottoBundle) {
            returnResult.add(LottoCalculator.getCountOfSameNumber(lotto, answer));
        }
        return returnResult;
    }

    public List<Integer> getBonusCompareResult(Lotto bonus) {
        List<Integer> returnBonusResult = new ArrayList<>();

        for (Lotto lotto : lottoBundle) {
            returnBonusResult.add(LottoCalculator.getCountOfSameNumber(lotto, bonus));
        }
        return returnBonusResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto chunk : lottoBundle) {
            sb.append(chunk.toString()).append("\n");
        }
        return sb.toString();
    }
}

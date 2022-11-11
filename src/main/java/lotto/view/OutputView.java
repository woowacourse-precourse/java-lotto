package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.*;

public class OutputView {

    public void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            printLottos(lottoNumbers);

        }
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResultCount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    printLottoResultPresent(lottoResultCount, rank);
                    printLottoResultNotPresent(lottoResultCount, rank);
                });
    }

    private static void printLottoResultNotPresent(Map<LottoRank, Integer> lottoResultCount, LottoRank rank) {
        if (!isContainRank(lottoResultCount, rank)) {
            System.out.println(rank.getLabel() + "0개");
        }
    }

    private static void printLottoResultPresent(Map<LottoRank, Integer> lottoResultCount, LottoRank rank) {
        if (isContainRank(lottoResultCount, rank)) {
            System.out.println(rank.getLabel() + lottoResultCount.get(rank) + "개");
        }
    }

    private static boolean isContainRank(Map<LottoRank, Integer> lottoResultCount, LottoRank rank) {
        return lottoResultCount.containsKey(rank);
    }


    private static void printLottos(List<Integer> lottoNumbers) {
        printLeftBorder();
        printLotto(lottoNumbers);
        printRightBorder();
    }

    private static void printLotto(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.print(lottoNumbers.get(i));
            printComma(lottoNumbers, i);

        }
    }

    private static void printComma(List<Integer> lottoNumbers, int i) {
        if (i == lottoNumbers.size() - 1) {
            return;
        }
        System.out.print(", ");
    }

    private static void printLeftBorder() {
        System.out.print("[");
    }

    private static void printRightBorder() {
        System.out.println("]");
    }
}

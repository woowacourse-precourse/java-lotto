package lotto.view;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String LOTTO_ISSUE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_FRAME = "[%s]";

    public static void printNumberOfIssuedLotto(int lottoNumbers) {
        printEmptyLine();
        System.out.println(String.format(LOTTO_ISSUE_MESSAGE, lottoNumbers));
    }

    public static void printLottosInformation(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            sortLottoNumbers(lottoNumbers);
            printLottoInformation(lottoNumbers);
        }
        printEmptyLine();
    }

    private static void printLottoInformation(List<Integer> lottonumbers) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lottonumbers.size(); i++) {
            int number = lottonumbers.get(i);
            if (i == lottonumbers.size() - 1) {
                result.append(number);
                continue;
            }
            result.append(number);
            result.append(", ");
        }
        System.out.println(String.format(LOTTO_FRAME, result));
    }

    private static void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}

package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;

public class OutputView {

    public static void printBuyHistory(List<Lotto> lottos) {
        // TODO: Parser 로 옮기기
        String start = "[";
        String end = "]";
        String delimiter = ", ";

        int amount = lottos.size();
        System.out.println(String.format("%d개를 구매했습니다.", amount));
        for (Lotto lotto : lottos) {
            String lottoStr = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(delimiter));
            System.out.println(start + lottoStr + end);
        }
    }

}
package lotto;

import java.util.EnumMap;
import java.util.List;

public class PrintController {

    public void print(List<Lotto> lottoNumbers) {

        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        lottoNumbers.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public void print(EnumMap<WinPrize, Long> map) {

        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(String.format("3개 일치 (5,000원) - %d개", map.getOrDefault(WinPrize.FIVE_GRADE, 0L)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", map.getOrDefault(WinPrize.FOUR_GRADE, 0L)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", map.getOrDefault(WinPrize.THREE_GRADE, 0L)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", map.getOrDefault(WinPrize.TWO_GRADE, 0L)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", map.getOrDefault(WinPrize.ONE_GRADE, 0L)));


    }

    public void print(double prizeRate) {

        // 소수점 둘째 자리에서 반올림
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", prizeRate * 100));
    }
}

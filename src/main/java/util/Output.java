package util;

import lotto.Lotteries;

public class Output {
    public static void printCountOfLotteries(int lottoNum) {
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public static void printAllLotteries(Lotteries lotteries) {
        System.out.println(lotteries.getLottoNumbers());
    }
}

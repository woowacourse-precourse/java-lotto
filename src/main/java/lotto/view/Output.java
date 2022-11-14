package lotto.view;

import lotto.enums.LottoRanking;

import java.util.List;

public class Output {
    private static final String END_GAME = "당첨 통계\n---";
    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void rateOfReturnOutput(Integer userMoney) {
        System.out.println(END_GAME);
        statisticalOutput();
        Integer sum = 0;
        LottoRanking[] grades = LottoRanking.values();
        for (LottoRanking grade : grades) {
            if (grade.count != 0) {
                sum += grade.prizeMoney;
            }
        }
        System.out.println(String.format(RATE_OF_RETURN, Math.round(((sum * 100.0) / userMoney) * 10) / 10.0));

    }

    public static void statisticalOutput() {
        LottoRanking[] grades = LottoRanking.values();
        for (LottoRanking grade : grades) {
            System.out.println(grade.getValue());
        }
    }
    public static void printLotto(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}

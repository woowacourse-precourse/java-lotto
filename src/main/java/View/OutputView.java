package View;

import Controller.Constant;
import Domain.Lotto;
import Domain.LottoList;
import Domain.Prize;

import java.text.DecimalFormat;

public class OutputView {
    private static final String PRINT_NUMBER_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String PRINT_EACH_LOTTO_NUMBER_START = "[";
    private static final String PRINT_EACH_LOTTO_NUMBER_END = "]";
    private static final String PRINT_EACH_LOTTO_NUMBER_SEPARATOR = ", ";
    private static final String PRINT_LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_SAME_NUMBER_COUNT = "%d개 일치";
    private static final String PRINT_CHECK_BONUS_BALL = ", 보너스 볼 일치";
    private static final String PRINT_REWARD_MONEY = " (%s원) - ";
    private static final String PRINT_MY_RESULT_COUNT = "%d개\n";
    private static final String PRINT_REWARD_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final double PERCENT = 100.0;
    public static void printNumberOfLotto(LottoList lottoList){
        System.out.printf(PRINT_NUMBER_OF_LOTTO_MESSAGE, lottoList.getAvailableLottoPlayNumber());
        printEachLottoNumber(lottoList);
    }

    public static void printEachLottoNumber(LottoList lottoList){
        for(Lotto lotto : lottoList.getLottoList()){
            System.out.print(PRINT_EACH_LOTTO_NUMBER_START);
            int lottoLength = lotto.getLottoNumbers().size();
            for(int index=0; index<lottoLength-1; index++){
                System.out.print(lotto.getLottoNumbers().get(index) + PRINT_EACH_LOTTO_NUMBER_SEPARATOR);
            }
            System.out.print(lotto.getLottoNumbers().get(lottoLength-1));
            System.out.println(PRINT_EACH_LOTTO_NUMBER_END);
        }
        System.out.println();
    }

    public static void printLottoResult(int[] countList, LottoList lottoList, int myReward){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(PRINT_LOTTO_RESULT_MESSAGE);
        for(Prize p : Prize.values()){
            System.out.printf(PRINT_SAME_NUMBER_COUNT, p.getCount());
            if(p.getBonusCheck())
                System.out.print(PRINT_CHECK_BONUS_BALL);
            System.out.printf(PRINT_REWARD_MONEY, decimalFormat.format(p.getPrizeMoney()));
            System.out.printf(PRINT_MY_RESULT_COUNT, countList[p.getRank()]);
        }
        printRewardRate(lottoList.getAvailableLottoPlayNumber(), myReward);
    }

    public static void printRewardRate(int numberOfLotto, int myReward){
        System.out.printf(PRINT_REWARD_RATE_MESSAGE, (myReward * PERCENT) / (numberOfLotto * Constant.LOTTO_PRICE));
    }

}

package ui;

import camp.nextstep.edu.missionutils.Console;
import config.ErrorConstants;
import config.PrintConstants;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoStatistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");

    /**
     * 사용자로부터 구입금액을 입력받는다.
     * @return 구입금액
     * @throws IllegalArgumentException 구입금액이 숫자가 아니거나, 1000의 배수가 아닌 경우 예외 발생
     */
    public static int readPayment() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_PAYMENT);
        String line = Console.readLine();
        try {
            int payment = Integer.parseInt(line);
            if (payment < 1000 || payment % 1000 != 0) {
                throw new IllegalArgumentException(ErrorConstants.LESS_THAN_MINIMUM_UNIT);
            }
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
        }
    }

    /**
     * 사용자로부터 당첨 번호를 입력받는다.
     * 각 번호는 ','로 구분되며 6개의 정수를 입력하여야 한다.
     * @return 당첨번호
     * @throws IllegalArgumentException 숫자가 아니거나, 로또번호로 생성될 수 없는 경우 예외 발생
     */
    public static Lotto readLuckyNumbers() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_LUCKY_NUMBERS);
        String[] tokens = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
            }
        }

        return new Lotto(numbers);
    }

    /**
     * 보너스 번호를 입력 받습니다.
     * @return 보너스 번호
     * @throws IllegalArgumentException 숫자가 아닌 경우 예외 발생
     */
    public static int readBonusNumber() throws IllegalArgumentException {
        System.out.println(PrintConstants.INPUT_BONUS_NUMBER);
        String line = Console.readLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.NOT_NUMBER_INPUT);
        }
    }

    /**
     * 당첨 통계를 정해진 포맷으로 출력합니다.
     * @param statistics 통계 정보
     */
    public static void printStatistics(LottoStatistics statistics) throws IllegalArgumentException {
        System.out.println(PrintConstants.START_PRINT_STATISTICS);
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getRank() == 0)
                continue;
            System.out.println(getFormedRankLine(rank, statistics.getNumOfRank(rank)));
        }
        System.out.println(getFormedYield(statistics.getYield()));
    }

    /**
     * 구매한 로또 번호들을 출력합니다.
     * @param lotteries 로또번호들의 목록
     */
    public static void printBoughtLotteries(List<Lotto> lotteries) {
        System.out.println("\n" + String.format(PrintConstants.BUY_COMPLETE, lotteries.size()));
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }

    /**
     * 정해진 형태로 오류의 메시지를 사용자에게 출력합니다.
     * 출력 후에는 오류 스택을 모두 출력합니다.
     * @param e 예외
     */
    public static void printError(Exception e) {
        System.out.println(ErrorConstants.ERROR_PREFIX + " " + e.getMessage());
        e.printStackTrace();
    }

    /**
     * 각 로또 등수의 정보에 대해서 문자열 형태로 반환합니다.
     * ex) 6개 일치 (2,000,000,000원) - 1개
     * ex) 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     * @param rank 로또 등수
     * @param nums 등수별 당첨 횟수
     * @return 로또 등수 정보
     */
    private static String getFormedRankLine(LottoRank rank, int nums) {
        return String.format(PrintConstants.RANK_INFORMATION, rank.getDescription(), decimalFormat.format(rank.getPrize()), nums);
    }

    /**
     * 정해진 포맷의 문자여로 수익률을 반환합니다.
     * ex) 총 수익률은 62.5%입니다.
     * @param yield 수익률
     * @return 소수점 1의 자리까지 반올림된 수익률과 기타 포맷
     */
    private static String getFormedYield(double yield) {
        return String.format(PrintConstants.PRINT_YIELD_FORMAT, yield);
    }
}

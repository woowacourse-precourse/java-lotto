package lotto.view;

import lotto.model.LottoRankingType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class UserOutput {
    private static final String OUTPUT_BUY_LOTTO = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.%s";
    private static final String OUTPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String OUTPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
    private static final String OUTPUT_BORDER_LINE = "---";
    private static final String OUTPUT_WINNING_HISTORY = "%d개 일치 (%s원) - %d개%s";
    private static final String OUTPUT_WINNING_HISTORY_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%s";
    private static final DecimalFormat INT_DECIMAL_FORMAT_BY_KOREA_MONEY = new DecimalFormat("###,###");
    private static final DecimalFormat DOUBLE_DECIMAL_FORMAT_BY_KOREA_MONEY = new DecimalFormat("#,##0.0");
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %s%%입니다.%s";

    public UserOutput() {

    }

    public void lineBreak() {
        System.out.println();
    }

    public void buyLotto() {
        System.out.println(OUTPUT_BUY_LOTTO);
    }

    public void lottoCount(int lottoCount) {
        System.out.printf(OUTPUT_LOTTO_COUNT, lottoCount, System.lineSeparator());
    }

    public void lottoNumbers(ArrayList<ArrayList<Integer>> displayLottoNumbers) {
        for (ArrayList<Integer> lottoNumbers : displayLottoNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public void winningNumbers() {
        System.out.println(OUTPUT_WINNING_NUMBERS);
    }

    public void bonusNumber() {
        System.out.println(OUTPUT_BONUS_NUMBER);
    }

    public void winningStatistics() {
        System.out.println(OUTPUT_WINNING_STATISTICS);
    }

    public void borderLine() {
        System.out.println(OUTPUT_BORDER_LINE);
    }

    public void winningHistory(Map<LottoRankingType, Integer> lottoRankingTypes) {
        fifthPlaceHistory(lottoRankingTypes.get(LottoRankingType.FIFTH_PLACE).intValue());
        fourthPlaceHistory(lottoRankingTypes.get(LottoRankingType.FOURTH_PLACE).intValue());
        thirdPlaceHistory(lottoRankingTypes.get(LottoRankingType.THIRD_PLACE).intValue());
        secondPlaceHistory(lottoRankingTypes.get(LottoRankingType.SECOND_PLACE).intValue());
        firstPlaceHistory(lottoRankingTypes.get(LottoRankingType.FIRST_PLACE).intValue());
    }

    public void rateOfReturn(double rateOfReturn) {
        System.out.printf(OUTPUT_RATE_OF_RETURN
                , DOUBLE_DECIMAL_FORMAT_BY_KOREA_MONEY.format(rateOfReturn)
                , System.lineSeparator());
    }

    private void fifthPlaceHistory(int count) {
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FIFTH_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FIFTH_PLACE.getWinningAmount())
                , count
                , System.lineSeparator());
    }

    private void fourthPlaceHistory(int count) {
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FOURTH_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FOURTH_PLACE.getWinningAmount())
                , count
                , System.lineSeparator());
    }

    private void thirdPlaceHistory(int count) {
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.THIRD_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.THIRD_PLACE.getWinningAmount())
                , count
                , System.lineSeparator());
    }

    private void secondPlaceHistory(int count) {
        System.out.printf(OUTPUT_WINNING_HISTORY_WITH_BONUS
                , LottoRankingType.SECOND_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.SECOND_PLACE.getWinningAmount())
                , count
                , System.lineSeparator());
    }

    private void firstPlaceHistory(int count) {
        System.out.printf(OUTPUT_WINNING_HISTORY
                , LottoRankingType.FIRST_PLACE.getMatchedNumberCount()
                , INT_DECIMAL_FORMAT_BY_KOREA_MONEY.format(LottoRankingType.FIRST_PLACE.getWinningAmount())
                , count
                , System.lineSeparator());
    }
}

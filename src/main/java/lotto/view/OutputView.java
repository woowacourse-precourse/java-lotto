package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoRanksDTO;
import lotto.dto.LottosDTO;
import lotto.exception.ViewClassCreateException;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PAYMENT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    
    private OutputView() {
        throw new ViewClassCreateException();
    }
    
    public static void printPaymentInputMessage() {
        System.out.println(PAYMENT_INPUT_MESSAGE);
    }
    
    public static void printWinningLottoNumbersInputMessage() {
        System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
    }
    
    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }
    
    public static void printLottoIssuanceResults(final LottosDTO lottosDTO) {
        final List<List<Integer>> lottos = lottosDTO.getLottos();
    
        System.out.printf("%n%d개를 구매했습니다.%n", lottos.size());
        System.out.println(parseLottosIssuanceResults(lottos));
    }
    
    private static String parseLottosIssuanceResults(final List<List<Integer>> lottos) {
        return lottos.stream()
                .map(OutputView::parseLottoIssuanceResults)
                .collect(Collectors.joining("\n"));
    }
    
    private static String parseLottoIssuanceResults(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
    
    public static void printWinningStats(final LottoRanksDTO lottoRanksDTO) {
        final List<LottoRank> lottoRanks = lottoRanksDTO.lottoRanks();
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(Arrays.stream(LottoRank.values())
                .filter(Predicate.not(LottoRank::isMiss))
                .sorted(Comparator.reverseOrder())
                .map(lottoRank -> parsePerWinningStats(lottoRanks, lottoRank))
                .collect(Collectors.joining("\n")));
    }
    
    private static String parsePerWinningStats(final List<LottoRank> lottoRanks, final LottoRank lottoRank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        final int countOfSameLottoNumber = lottoRank.countOfSameLottoNumber();
        final int prizeMoney = lottoRank.prizeMoney();
        final String prizeMoneyDisplay = decimalFormat.format(prizeMoney);
        final int countOfMatchingLottoRank = countOfMatchingLottoRank(lottoRanks, lottoRank);
        
        if (lottoRank.isSecond()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", countOfSameLottoNumber, prizeMoneyDisplay, countOfMatchingLottoRank);
        }
        return String.format("%d개 일치 (%s원) - %d개", countOfSameLottoNumber, prizeMoneyDisplay, countOfMatchingLottoRank);
    }
    
    private static int countOfMatchingLottoRank(final List<LottoRank> lottoRanks, final LottoRank lottoRankToCompare) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> lottoRank == lottoRankToCompare)
                .count();
    }
    
    public static void printYield(final double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}

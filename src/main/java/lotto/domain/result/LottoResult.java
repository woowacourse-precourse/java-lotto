package lotto.domain.result;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE_OF_CONSTRUCTOR;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;

public class LottoResult {

  public static final String LINE_BREAK = "\n";
  public static final String OUTPUT_MESSAGE_OF_LOTTO_RESULT = "당첨 통계";
  public static final String OUTPUT_MESSAGE_OF_DIVIDING_LINE = "---";
  public static final String OUTPUT_MESSAGE_OF_LOTTO_RANKING = "%d개 일치";
  public static final String COUNT = "개\n";
  public static final String OUTPUT_MESSAGE_OF_EARNING_RATE = "총 수익률은 ";
  public static final String OUTPUT_MESSAGE_OF_MAMOOREE = "%입니다.\n";


  public static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - ";
  public static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
  public static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
  public static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
  public static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";

  private LottoResult() {
    throw new UnsupportedOperationException( ERROR_MESSAGE_OF_CONSTRUCTOR );
  }

  public static void makeStringResultOfEveryLottoList(List<List<Integer>> numbers) {
    for ( List<Integer> lotto : numbers ) {
      System.out.println(lotto);
    }
  }

  public static String makeLottoStaticResult() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(OUTPUT_MESSAGE_OF_LOTTO_RESULT).append(LINE_BREAK);
    stringBuilder.append(OUTPUT_MESSAGE_OF_DIVIDING_LINE).append(LINE_BREAK);

    stringBuilder.append(OUTPUT_MESSAGE_OF_LOTTO_RANKING);
    return stringBuilder.toString();
  }

  public static String getLottoStatisticInfo(Map<LottoRank, Integer> map) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(FIFTH_MESSAGE).append(map.get(LottoRank.FIFTH)).append(COUNT);
    stringBuilder.append(FOURTH_MESSAGE).append(map.get(LottoRank.FOURTH)).append(COUNT);
    stringBuilder.append(THIRD_MESSAGE).append(map.get(LottoRank.THIRD)).append(COUNT);
    stringBuilder.append(SECOND_MESSAGE).append(map.get(LottoRank.SECOND)).append(COUNT);
    stringBuilder.append(FIRST_MESSAGE).append(map.get(LottoRank.FIRST)).append(COUNT);
    return stringBuilder.toString();
  }

  public static String getRevenuePercentageInfo(Double rate) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(OUTPUT_MESSAGE_OF_EARNING_RATE).append( rate ).append( OUTPUT_MESSAGE_OF_MAMOOREE );
    return stringBuilder.toString();
  }
}
package lotto;

import java.util.List;

public class OutputMessage {

  private static final String BUY_MESSAGE = "%d개를 구매했습니다.\n";
  private static final String STATISTICS_MESSAGE = "당첨 통계\n---";
  private static final String LOTTO_RESULT_MESSAGE= "%s - %d개\n";
  private static final String EARNING_MESSAGE = "총 수익률은 %.1f%%입니다.\n";


  public static void messageStatisticsMessage(int[] ranking, Float earning){
    System.out.println();
    System.out.println(STATISTICS_MESSAGE);
    messageLottoResult(ranking);
    System.out.printf(EARNING_MESSAGE, earning);
  }

  public static void messageGenerateLottoRepository(Integer ableCount, List<List<Integer>> lottoRepository){
    System.out.println();
    System.out.printf(BUY_MESSAGE, ableCount);

    for (List<Integer> lotto : lottoRepository){
      System.out.println(lotto);
    }
  }

  public static void messageLottoResult(int[] ranking){
    System.out.printf(LOTTO_RESULT_MESSAGE, Grade.FIFTH.getOutput(), ranking[5]);
    System.out.printf(LOTTO_RESULT_MESSAGE, Grade.FOURTH.getOutput(), ranking[4]);
    System.out.printf(LOTTO_RESULT_MESSAGE, Grade.THIRD.getOutput(), ranking[3]);
    System.out.printf(LOTTO_RESULT_MESSAGE, Grade.SECOND.getOutput(), ranking[2]);
    System.out.printf(LOTTO_RESULT_MESSAGE, Grade.FIRST.getOutput(), ranking[1]);
  }

}

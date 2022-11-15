package lotto;

public class LottoResult {

  private long prizeMoney = 0;
  private final int[] count = new int[5];

  public LottoResult() {
  }

  public void updateResult(int idx, long money) {
    prizeMoney += money;
    count[idx]++;
  }

  public void printResult(int useMoney) {
    System.out.printf("3개 일치 (5,000원) - %d개 \n", count[4]);
    System.out.printf("4개 일치 (50,000원) - %d개 \n", count[3]);
    System.out.printf("5개 일치 (1,500,000원) - %d개 \n", count[2]);
    System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", count[1]);
    System.out.printf("6개 일치 (2,000,000,000원) - %d개 \n", count[0]);
    System.out.printf("총 수익률은 %.1f%%입니다.", (float) prizeMoney/ useMoney * 100);
  }
}

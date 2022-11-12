package lotto;

import java.util.Map;

public class Print {
    public static void money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseLotto(int lottoTickets, Lottos lottos) {
        newLine();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        newLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        newLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void winningResult(int lottoTickets, Map<LottoOperator, Integer> winningResult) {
        newLine();
        System.out.println("당첨 통계\n" + "---");
        for (LottoOperator lottoOperator : winningResult.keySet()) {
            if (lottoOperator == LottoOperator.FIVE_BONUS) {
                System.out.println(
                        lottoOperator.getCount() + "개 일치, 보너스 볼 일치 (" +
                                lottoOperator.getWinningAmount() + "원) - " +
                                winningResult.get(lottoOperator) + "개");
                continue;
            }
            System.out.println(
                    lottoOperator.getCount() + "개 일치 (" +
                            lottoOperator.getWinningAmount() + "원) - " +
                            winningResult.get(lottoOperator) + "개"
            );
        }
    }

    private static void newLine() {
        System.out.println();
    }
}

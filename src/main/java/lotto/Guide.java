package lotto;

public class Guide {
    public void printPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printConfirmPurchase(Purchase purchase) {
        System.out.println("\n" + purchase.getLottoNumber() + "개를 구매했습니다.");
    }

    public void printMyLotto(MyLotto myLotto) {
        for (Lotto lotto : myLotto.getMyLotto()) {
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }

    public void requestWinLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMyLottoResult(MyLotto myLotto) {
        System.out.println("당첨 통계\n---");

        for (Rank rank : Rank.values()) {
            if (rank.getCorrectNumbers() == 0) {
                continue;
            }
            System.out.println(
                    rank.getRankDescription() + myLotto.getEachLottoRank().get(rank.name()) + "개");
        }
    }

    public void printProfit(MyLotto myLotto) {
        System.out.print("총 수익률은 " + String.format("%.1f", myLotto.getProfit()) + "%입니다.");
    }
}

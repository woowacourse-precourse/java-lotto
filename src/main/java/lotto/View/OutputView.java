package lotto.View;

import java.util.List;

public class OutputView {
    public void askPurchasePrice(){
        System.out.print("구매 금액을 입력해 주세요.");
    }

    public void showPurchasedLotto(int purchasedCount, List<List<Integer>> purchasedLottoNumber){
        System.out.print(purchasedCount + "개를 구매했습니다.");
        for(List<Integer> lottoNumbers : purchasedLottoNumber){
            System.out.println(lottoNumbers.toString());
        }
    }

    public void askWinnerNumber(){System.out.print("당첨 번호를 입력해 주세요.");}

    public void askBonusNumber(){System.out.print("보너스 번호를 입력해 주세요.");}

    public void showLottoPrize(List<Integer> prize, List<Integer> winCount){
        final int FIRSTRANK = 4, SECONDRANK = 3, THIRDRANK = 2, FOURTHRANK = 1, FIFTHRANK = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + prize.get(FIFTHRANK) + ") - " + winCount.get(FIFTHRANK));
        System.out.println("4개 일치 (" + prize.get(FOURTHRANK) + ") - " + winCount.get(FOURTHRANK));
        System.out.println("5개 일치 (" + prize.get(THIRDRANK) + ") - " + winCount.get(THIRDRANK));
        System.out.println("5개 일치, 보너스 볼 일치 (" + prize.get(SECONDRANK) + ") - " + winCount.get(SECONDRANK));
        System.out.println("6개 일치 (" + prize.get(FIRSTRANK) + ") - " + winCount.get(FIRSTRANK));
    }

    public void showYield(double yield){
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
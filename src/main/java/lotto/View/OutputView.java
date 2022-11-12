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
}
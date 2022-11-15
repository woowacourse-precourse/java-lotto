package lotto;

import java.util.List;

public class Output {

    public void userBuyLottoNumbers(List<Lotto> userLottoNumbers){
        int amount = userLottoNumbers.size();
        System.out.println(amount + "개를 구매했습니다.");

        for(Lotto lotto : userLottoNumbers){
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public void lottoMatchResult(List<Integer> result){
        System.out.println("당첨통계\n" + "------");
        for(MatchLotto matchLotto : MatchLotto.values()){
            System.out.println(matchLotto.getResult() + result.get(matchLotto.getMatchNumber())+ "개");
        }
    }
    public void printRateOfReturn(double rate){
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }


}

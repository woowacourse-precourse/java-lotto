package lotto;

import java.util.List;

public class OutputView {
    public static final String PERCHASED_LOTTOS = "개를 구매했습니다.";
    public static final String WINNING_STATETISTICS = "당첨통계";
    public static final String HYPHEN = "------";
    public static final String NUMBER_OF = "개";
    public static final String GROSS_RETRUN = "총 수익률은 ";
    public static final String IS = "%입니다";

    public void printUserBuyLottoNumbers(List<Lotto> userLottoNumbers){
        int amount = userLottoNumbers.size();
        System.out.println(amount + PERCHASED_LOTTOS);

        for(Lotto lotto : userLottoNumbers){
            System.out.println(lotto.getNumbers().toString());
        }
    }
    public void printUserLottoMatchResult(List<Integer> result){
        System.out.println(WINNING_STATETISTICS+"\n"+ HYPHEN);
        for(MatchLotto matchLotto : MatchLotto.values()){
            System.out.println(matchLotto.getResult() + result.get(matchLotto.getMatchNumber())+ NUMBER_OF);
        }
    }
    public void printRateOfReturn(double rate){
        System.out.println(GROSS_RETRUN + rate + IS);
    }
}

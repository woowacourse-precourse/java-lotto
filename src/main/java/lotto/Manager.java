package lotto;

import java.util.*;
import lotto.Lotto;
import lotto.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class Manager {
    public final int LOTTO_MIN = 1;
    public final int LOTTO_MAX = 45;
    public final int LOTTO_LENGTH = 6;
    public final int RANK_LENGTH = 6;

    public final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public final String PURCHASE_MENT = "개를 구매했습니다.";
    public final String INPUT_WINNING = "당첨 번호를 입력해 주세요.";
    public final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    public final String INIT_RESULT = "당첨 통계\n---\n";
    public final String INIT_WINNING_RATE = "총 수익률은 ";
    public final String CLOSE_WINNING_RATE = "%입니다.";
    public final String LOTTO_UNIT = "개";

    public boolean isNumber(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }

    public boolean ValidityOfNumber(List<String> list){
        for(int i=0; i<list.size(); i++){
            if(isNumber(list.get(i))) continue;
            return false;
        }
        return true;
    }

    public boolean ValidRangeOfLottoNumber(List<Integer> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) < LOTTO_MIN || list.get(i) > LOTTO_MAX) return false;
        }
        return true;
    }

    public boolean OverlapOfLottoNumber(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        return set.size() != LOTTO_LENGTH;
    }

    public Lotto makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_LENGTH);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void PrintLotto(List<Lotto> list){
        for(int i=0; i<list.size(); i++){
            list.get(i).Print();
        }
    }
    public int getMatchCount(List<Integer> lotto, List<Integer> winning){
        int match = 0;
        for(int i=0; i<lotto.size(); i++){
            if(winning.contains(lotto.get(i)))
                match += 1;
        }
        return match;
    }
    public int[] calculateResult(List<Lotto> lottos, List<Integer> winning, int bonus){
        int[] frequency = new int[RANK_LENGTH];
        for(int freq : frequency)
            freq = 0;
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            int matchCount = getMatchCount(numbers, winning);
            int bonusCount = 0;
            if(matchCount == 5 && numbers.contains(bonus)){
                bonusCount = 1;
            }
            Constants res = Constants.calc(matchCount, bonusCount);
            frequency[res.getRank()] += 1;
        }
        return frequency;
    }

    public void calculateReturnRate(int purchase, int money){
        double rate = (double)money / (double)purchase;
        System.out.print(INIT_WINNING_RATE);
        System.out.print(String.format("%.2f", rate));
        System.out.println(CLOSE_WINNING_RATE);
    }

    public void PrintGameResult(List<Lotto> lottos, List<Integer> winning, int bonus){
        int[] frequency = calculateResult(lottos, winning, bonus);
        System.out.print(INIT_RESULT);
        for(int i=1;i<frequency.length;i++){
            System.out.print(Constants.invert(i).getGameResult());
            System.out.print(" - ");
            System.out.println(frequency[i]+LOTTO_UNIT);
        }
    }
}

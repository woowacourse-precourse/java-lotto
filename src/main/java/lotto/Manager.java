package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Manager {
    public final int LOTTO_MIN = 1;
    public final int LOTTO_MAX = 45;
    public final int LOTTO_LENGTH = 6;
    public final int RANK_LENGTH = 6;
    public final int LOTTO_PRICE = 1000;
    public final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public final String PURCHASE_MENT = "개를 구매했습니다.";
    public final String INPUT_WINNING = "당첨 번호를 입력해 주세요.";
    public final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    public final String INIT_RESULT = "당첨 통계\n---\n";
    public final String INIT_WINNING_RATE = "총 수익률은 ";
    public final String CLOSE_WINNING_RATE = "%입니다.";
    public final String LOTTO_UNIT = "개";

    public  String Error_message;
    public String getError_message(){
        return this.Error_message;
    }
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

    public void QuitProgram(String message){
        this.Error_message = message;
        throw new IllegalArgumentException();
    }

    public int checkPurchaseMoney(String input){
        if(!isNumber(input))
            QuitProgram("[ERROR] 금액은 숫자로만 구성된 문자열이어야 합니다.");
        int money = Integer.parseInt(input);
        if(money < LOTTO_PRICE)
            QuitProgram("[ERROR] 최소 1000원 이상의 금액을 입력해주세요.");
        if(money % LOTTO_PRICE != 0)
            QuitProgram("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        return money;
    }

    public List<Integer> checkWinningNumber(String input){
        String[] arr = input.split(",");
        if(arr.length != LOTTO_LENGTH)
            QuitProgram("[ERROR] 당첨번호는 쉼표(,)를 기준으로 6개로 구분되어야 합니다.");
        List<String> list = Arrays.asList(arr);
        if(!ValidityOfNumber(list))
            QuitProgram("[ERROR] 당첨번호는 반드시 숫자로만 이루어져야 합니다.");
        List<Integer> winnings = new ArrayList<>();
        for(String s : list)
            winnings.add(Integer.parseInt(s));
        if(!ValidRangeOfLottoNumber(winnings))
            QuitProgram("[ERROR] 당첨번호는 1 ~ 45 범위에 해당하는 숫자여야 합니다.");
        if(OverlapOfLottoNumber(winnings))
            QuitProgram("[ERROR] 6개의 당첨번호는 모두 다른 숫자여야 합니다.");
        return winnings;
    }

    public int checkBonusNumber(String input, List<Integer> winning){
        if(!isNumber(input))
            QuitProgram("[ERROR] 보너스번호는 반드시 숫자로만 이루어져야 합니다.");
        List<Integer> list = new ArrayList<>();
        int bonus = Integer.parseInt(input);
        list.add(bonus);
        if(!ValidRangeOfLottoNumber(list))
            QuitProgram("[ERROR] 보너스번호는 1 ~ 45 범위에 해당하는 숫자여야 합니다.");
        if(winning.contains(bonus))
            QuitProgram("[ERROR] 보너스 번호는 입력한 당첨 번호와 중복되서는 안됩니다.");
        return bonus;
    }

    public Lotto makeLotto(){
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_LENGTH);
        List<Integer> numbers = new ArrayList<>();
        for(Integer elem : temp)
            numbers.add(elem);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void PrintLotto(List<Lotto> list){
        System.out.println("\n" + list.size() + PURCHASE_MENT);
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

    public int calculateTotalMoney(List<Lotto> lottos, List<Integer> winning, int bonus){
        int[] frequency = calculateResult(lottos, winning, bonus);
        int total = 0;
        for(int i=1;i<frequency.length;i++){
            Constants c = Constants.invert(i);
            total += c.getMoney() * frequency[i];
        }
        return total;
    }

    public void PrintReturnRate(int purchase, int money){
        double rate = (double)money / (double)purchase;
        rate *= 100;
        System.out.print(INIT_WINNING_RATE);
        System.out.print(String.format("%.1f", rate));
        System.out.println(CLOSE_WINNING_RATE);
    }

    public void PrintGameResult(List<Lotto> lottos, List<Integer> winning, int bonus){
        int[] frequency = calculateResult(lottos, winning, bonus);
        System.out.print(INIT_RESULT);
        for(int i=frequency.length-1; i>=1; i--){
            System.out.print(Constants.invert(i).getGameResult());
            System.out.print(" - ");
            System.out.println(frequency[i]+LOTTO_UNIT);
        }
    }
}

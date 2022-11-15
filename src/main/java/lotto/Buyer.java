package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enums.ErrorMessage;
import lotto.Enums.Reward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Utils.printResult;
import static lotto.Utils.printYield;

public class Buyer {

    private final int purchase;
    private int reward;

    private List<Lotto> purchasedLottos;
    private List<Integer> results;

    public Buyer(int purchase){
        validate(purchase);
        this.purchase = purchase;
        this.purchasedLottos = putchaseLottos(purchase/1000);
        this.reward = 0;
        this.results = new ArrayList<>(List.of(0,0,0,0,0,0));
    }

    private void validate(int purchase){
        if(purchase%1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_MOD.getMessage());
        }
    }

    private List<Lotto> putchaseLottos(int cnt){
        List<Lotto> purchasedLottos = new ArrayList<>();

        System.out.println(cnt+"개를 구매했습니다.");
        for(int i=0;i<cnt;i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            System.out.println(numbers);
            purchasedLottos.add(new Lotto(numbers));
        }

        return purchasedLottos;
    }


    public void simulate(Winning winning){
        for(Lotto lotto:purchasedLottos){
            int grade = compare(winning, lotto);
            results.set(grade, results.get(grade)+1);
        }
        printResult(results);
        calReward();
        double yield = calYield();
        printYield(yield);
    }

    private int compare(Winning winning, Lotto lotto){
        int matchingCnt = countMatchingNum(winning.getLotto(), lotto);

        if(matchingCnt == 6) return 1;
        if(matchingCnt == 5) {
            if(matchingBonus(winning.getBonusNum(), lotto)) return 2;
            return 3;
        }
        if(matchingCnt == 4) return 4;
        if(matchingCnt == 3) return 5;

        return 0;
    }

    private int countMatchingNum(Lotto winning, Lotto lotto){
        int cnt = 0;
        List<Integer> numbers = lotto.getNumbers();

        for(int num:winning.getNumbers()){
            if(numbers.contains(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean matchingBonus(int bonus, Lotto lotto){
        if(lotto.getNumbers().contains(bonus)){
            return true;
        }
        return false;
    }

    private void calReward(){
        reward += Reward.FIRST.getReward() * results.get(1);
        reward += Reward.SECOND.getReward() * results.get(2);
        reward += Reward.THIRD.getReward() * results.get(3);
        reward += Reward.FORTH.getReward() * results.get(4);
        reward += Reward.FIFTH.getReward() * results.get(5);
    }

    private double calYield(){
        return (double) reward/purchase*100;
    };

}

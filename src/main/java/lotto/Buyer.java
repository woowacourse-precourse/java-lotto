package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final int purchase;
    private int reward;

    private List<Lotto> purchasedLottos;
    private List<Integer> results;

    public Buyer(int purchase){
        validate(purchase);
        this.purchase = purchase;
        this.purchasedLottos = putchaseLottos(purchase/1000);
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
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
            purchasedLottos.add(new Lotto(numbers));
        }

        return purchasedLottos;
    }


    public void getResult(Winning winning){
        for(Lotto lotto:purchasedLottos){
            int grade = compare(winning, lotto);
        }

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
        this.reward = 0;
    }

}

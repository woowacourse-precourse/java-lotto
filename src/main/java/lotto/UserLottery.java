package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class UserLottery {
    private final int purchase_lottery_count;
    private List<Integer>[] user_lotterys;

    public UserLottery(int purchase_lottery) {
        this.purchase_lottery_count=(int)purchase_lottery/1000;
        createUserLotterys();
        printUserLottery();
    }

    public List<Integer>[] getUserLotterys(){
        return user_lotterys;
    }

    private void createUserLotterys(){
        user_lotterys=new ArrayList[5000];
        for(int i=0;i<purchase_lottery_count;i++){
            user_lotterys[i]=new ArrayList<>();
            if(isOverlapLottery(i)){
                i--;
                continue;
            }
            user_lotterys[i].addAll(getRandomLottery());
        }
    }

    private void printUserLottery(){
        System.out.println("\n"+purchase_lottery_count+"개를 구매했습니다.");
        for(int i=0;i<purchase_lottery_count;i++){
            System.out.print("[");
            for(int j=0;j<LottoRange.LOTTERY_MAX.getValue()-1;j++) {
                System.out.print(user_lotterys[i].get(j) + ", ");
            }
            System.out.println(user_lotterys[i].get(LottoRange.LOTTERY_MAX.getValue()-1)+"]");
        }
    }

    private List<Integer> getRandomLottery(){
        List<Integer> numbers= Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> random_lottery=new ArrayList<>();
        random_lottery.addAll(numbers);
        Collections.sort(random_lottery);
        return random_lottery;
    }

    private boolean isOverlapLottery(int size){
        for(int i=0;i<size-1;i++){
            if(user_lotterys[i].containsAll(user_lotterys[size-1])){
                return true;
            }
        }
        return false;
    }

}

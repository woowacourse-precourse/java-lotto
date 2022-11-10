package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        user_lotterys=new ArrayList[LottoRange.LOTTERY_MAX.getValue()];
        for(int i=0;i<LottoRange.LOTTERY_MAX.getValue();i++){
            user_lotterys[i]=new ArrayList<>();
            if(isOverlapLottery(i)){
                i--;
                continue;
            }
            user_lotterys[i]=getRandomLottery();
        }
    }

    private void printUserLottery(){
        System.out.println("\n"+purchase_lottery_count+"개를 구매했습니다.");
        for(int i=0;i<user_lotterys.length;i++){
            System.out.print("[");
            for(int j=0;j<LottoRange.LOTTERY_MAX.getValue()-1;j++) {
                System.out.print(user_lotterys[i].get(j) + ",");
            }
            System.out.println(user_lotterys[i].get(LottoRange.LOTTERY_MAX.getValue()-1)+"]");
        }
    }

    private List<Integer> getRandomLottery(){
        List<Integer> random_lottery=new ArrayList<>();
        while(random_lottery.size()<LottoRange.LOTTERY_MAX.getValue()){
            int random_number= Randoms.pickNumberInRange(1,45);
            if(!random_lottery.contains(random_number)){
                random_lottery.add(random_number);
            }
        }
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

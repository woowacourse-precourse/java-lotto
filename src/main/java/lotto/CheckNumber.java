package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNumber {
    static void check_bonus(Lotto lotto,int bonus){
        //보너스 번호가 당첨번호와 겹치는지 확인
        lotto.check_bonus(bonus);
    }
    static boolean check_second(List<Integer> lotto_num, int bonus){
        if(lotto_num.contains(bonus)) return true;
        return false;
    }

    static float check_same_num(Lotto lotto,List<Integer> lotto_num,int bonus){
        float result;
        result = lotto.check_rank(lotto_num);
        if(result == 5f){
            if(check_second(lotto_num,bonus)) result = result + 0.5f;
        }
        return result;
    }

    static void check_result(Lotto lotto, List<List<Integer>> lotto_nums, int bonus,int money){
        List<Integer> count_rank = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
        float result;
        int price = 0;
        List<Integer> temp;

        for (int i = 0;i < lotto_nums.size();i++){
            temp = lotto_nums.get(i);
            result = check_same_num(lotto,temp,bonus);
            count_rank = count_result(count_rank,result);
            price = sum_price(price,result);
        }
        ShowResult.write_result(count_rank);
        ShowResult.calculate_price(price,money);
    }

    static List<Integer> count_result (List<Integer> count_rank, float result){
        int index_temp;
        int count_temp;

        for(LottoRank.RankType r: LottoRank.RankType.values()){
            if(r.getNum()==result){
                index_temp = r.getCheck();
                count_temp = count_rank.get(index_temp);
                count_rank.set(index_temp, count_temp + 1);
            }
        }
        return count_rank;
    }

    static int sum_price(int price,float result){
        for(LottoRank.RankType r: LottoRank.RankType.values()){
            if(r.getNum()==result){
                price += r.getPrice();
            }
        }
        return price;
    }
}

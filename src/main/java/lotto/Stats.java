package lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class Stats {
    public static DecimalFormat decimalFormat = new DecimalFormat("###,###");
    public static List<Integer> targets ;
    static final int first = 2000000000;
    static final int second = 30000000;
    static final int third = 1500000;
    static final int fourth = 50000;
    static final int fifth =5000;

    public static HashMap<Integer,Integer> get_rank(List<Lotto> users, Lotto target, int bonus){
        HashMap<Integer,Integer> result = new HashMap<>();
        for(int i=3; i<=7; i++){
            result.put(i,0);
        }
        for(Lotto a: users){
            int tmp = compare(a,target);
            if(tmp==5 && a.numbers.contains(bonus)){
                result.put(7,result.getOrDefault(7,0)+1);
            }else{
            result.put(tmp,result.getOrDefault(tmp,0)+1);
            }
        }
        return result;
    }
    public static void get_yield(int input, int output){
        String result ;
        float tmp = ((float) output/(float) input) *100;
        result = String.format("%.1f",tmp);
        System.out.println("총 수익률은 "+result+"%입니다.");
    }
    public static int total_cost(HashMap<Integer,Integer> map){
        int total_cost= 0;
        total_cost += map.get(3)*fifth;
        total_cost += map.get(4)*fourth;
        total_cost += map.get(5)*third;
        total_cost += map.get(6)*first;
        total_cost += map.get(7)*second;

        return total_cost;
    }
    public static void print_result(HashMap<Integer,Integer> map){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 ("+decimalFormat.format(fifth)+"원) - "+map.get(3)+"개");
        System.out.println("4개 일치 ("+decimalFormat.format(fourth)+"원) - "+map.get(4)+"개");
        System.out.println("5개 일치 ("+decimalFormat.format(third)+"원) - "+map.get(5)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 ("+decimalFormat.format(second)+"원) - "+map.get(7)+"개");
        System.out.println("6개 일치 ("+decimalFormat.format(first)+"원) - "+map.get(6)+"개");

    }
    public static int compare(Lotto user, Lotto target){
        int result =0;
        targets = target.numbers;
        for(int a: user.numbers){
            if(targets.contains(a)){
                result++;
            }
        }
        return result;
    }
}

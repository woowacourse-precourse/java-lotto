package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfitRate {
    final Integer input;
    final List<Integer> output;
    final Integer size ;

    static List<Integer> profitList = Arrays.asList(
            5000,50000,1500000,30000000,2000000000
    );

    static Integer profit ;

    static float profitRate = 0;

    public ProfitRate(Integer input, List<Integer> output){ //input - 구입 가격 , output - correctList
        this.input = input;
        this.output = output;
        this.size = output.size();
        this.profit = 0;
        check();
    }

    private void check() {
        for(int i=0; i<size; i++){
            Integer corrects = output.get(i);
            if(corrects>=3){
                calculate(corrects);
            }
        }
        totalProfitRate();
    }

    private void calculate(Integer corrects) {
        int idx = corrects-3;
        Integer val = profitList.get(idx);
        profit += val;
    }

    public float totalProfitRate() {
        float in = input.floatValue();
        float out = profit.floatValue();
        System.out.println("profit = " + profit);
        if(out>=in)
        {float rate = Math.round(out*100/in);
        System.out.println("in = " + in);
        System.out.println("out = " + out);
        System.out.println("rate = " + rate);
        profitRate = rate;
        return rate;
        }
        System.out.println(" 이득 없음 ");
        return 0;
    }





}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Integer> result;
    private List<Integer> money;

    public Result() {
        result = new ArrayList<>();
        for(int i=0;i<6;i++) {
            result.add(0);
        }
        money = List.of(0, 5000, 50000, 1_500_000, 30_000_000, 2_000_000_000);
    }

    public void record(Integer duplicatedCnt, boolean hasBonusNumber) {
        if(duplicatedCnt == 6) {
            result.set(5, result.get(5) + 1);
        } else if(duplicatedCnt == 5) {
            if (hasBonusNumber) {
                result.set(4, result.get(4) + 1);
            } else {
                result.set(3, result.get(3) + 1);
            }
        } else if(duplicatedCnt == 4) {
            result.set(2, result.get(2) + 1);
        } else if(duplicatedCnt == 3) {
            result.set(1, result.get(1) + 1);
        } else {
            result.set(0, result.get(0) + 1);
        }
    }

    @Override
    public String toString() {
        String str = "3개 일치 (5,000원) - "+result.get(1)+"개\n";
        str += "4개 일치 (50,000원) - "+result.get(2)+"개\n";
        str += "5개 일치 (1,500,000원) - "+result.get(3)+"개\n";
        str += "5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.get(4)+"개\n";
        str += "6개 일치 (2,000,000,000원) - "+result.get(5)+"개\n";
        return str;
    }

    public double calculateYield() {
        Integer totalOutcome = 0;
        Integer totalInput = 0;
        for(int i=0; i<result.size();i++ ){
            totalOutcome += result.get(i) * money.get(i);
            totalInput += result.get(i) * 1000;
        }

        double yield = ((double) totalOutcome / totalInput) * 100;
        return Math.round(yield * 100) / 100.0;
    }
}

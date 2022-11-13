package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculater {

    public int caculateRevenue(List<Integer> correctNumberList) {

        List<Integer> revenueList = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));
        CompareHowManyCorrect compareHowManyCorrect = new CompareHowManyCorrect();
        int revenue = 0;

        for (int i = 0; i < correctNumberList.size(); i++) {
            int index = correctNumberList.get(i) - 3;
            if(index >= 0){
                revenue += revenueList.get(index);
            }
        }
        return revenue;
    }

    public int caculateRevenue(int inputMoney, int revenue) {

        return 0;
    }

}

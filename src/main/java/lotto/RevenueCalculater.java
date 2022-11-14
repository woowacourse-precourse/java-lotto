package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevenueCalculater {
    private static final List<Integer> REVENUELIST = new ArrayList<>(
            Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));

    private int index = 0;

    public int caculateRevenue(List<Integer> correctNumberList) {
        int revenue = 0;
        for (int i = 0; i < correctNumberList.size(); i++) {
            index = correctNumberList.get(i) - 3;
            if (index >= 0) {
                revenue += REVENUELIST.get(index);
            }
        }
        return revenue;
    }


}

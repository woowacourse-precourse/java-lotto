package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RevenueCalculaterTest {

    @DisplayName("맞춘 로또에 따른 상금을 구하고, 더한다.")
    @Test
    void calculateRevenue() {
        RevenueCalculater revenueCalculater = new RevenueCalculater();

        List<Integer> correctAmountList1 = new ArrayList<>(Arrays.asList(7,6,4,3,2));
        List<Integer> correctAmountList2 = new ArrayList<>(Arrays.asList(5,6,3,3,2));
        assertAll(
                ()->assertEquals(revenueCalculater.caculateRevenue(correctAmountList1),2030055000),
                ()->assertEquals(revenueCalculater.caculateRevenue(correctAmountList2),31510000)
        );


    }

}
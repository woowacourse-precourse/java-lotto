package lotto.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReportTest {


    @Test
    public void interestTest() throws Exception {
        Report report = new Report();
        String str = report.TotalInterest(8000);
        System.out.println("str = " + str);

    }

}

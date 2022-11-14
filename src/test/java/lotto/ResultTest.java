package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {
    private Result testResult;

    @BeforeAll
    void setUp() {
        this.testResult = new Result(List.of(0, 0, 3, 0, 0, 6), new PurchaseAmount(1000));
    }

    @Test
    public void createPrizePerPurchaseAmount() {
        System.out.println(testResult.getPrizePerPurchaseAmount());
    }
}

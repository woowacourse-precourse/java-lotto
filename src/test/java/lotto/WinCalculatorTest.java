package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinCalculatorTest {
    private WinCalculator winCalculator;

    @BeforeEach
    void init() {
        winCalculator = new WinCalculator();
    }

    @Test
    void secondPlaceTest() {
        HashMap <String, Integer> calculatedPrize;
        Lotto oneTicket = new Lotto(List.of(3, 12, 15, 24, 35, 40));
        Lotto winningNumbers = new Lotto(List.of(3, 12, 15, 24, 30, 40));
        List<Lotto> tickets = new ArrayList<>();
        int bonusNumber = 35;

        tickets.add(oneTicket);
        calculatedPrize = winCalculator.getEachPrize(tickets, winningNumbers, bonusNumber);
        System.out.println(calculatedPrize);
    }


}

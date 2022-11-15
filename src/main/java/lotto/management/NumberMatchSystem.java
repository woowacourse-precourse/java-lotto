package lotto.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberMatchSystem {
    private final int INDEX_ADJUSTMENT_VALUE = 3;
    private final int INIT_VALUE = 0;
    private final int MINIMUM_QUALIFICATION = 3;
    private final int THREE_MATCH_INDEX = 0;
    private final int FOUR_MATCH_INDEX = 1;
    private final int FIVE_MATCH_INDEX = 2;
    private final int SIX_MATCH_INDEX = 3;
    private final int FIVE_AND_BONUS_MATCH_INDEX = 4;
    private final List<List<Integer>> numberIntegration;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private List<Integer> ticketResult;

    NumberMatchSystem(List<List<Integer>> numberIntegration, List<Integer> winningNumbers, int bonusNumber) {
        ticketResult = new ArrayList<>();
        init();
        this.numberIntegration = numberIntegration;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void init() {
        ticketResult = Arrays.asList(INIT_VALUE, INIT_VALUE, INIT_VALUE, INIT_VALUE, INIT_VALUE);
    }

    public List<Integer> getTicketsResult() {
        return ticketResult;
    }

    public void checkTicket() {
        for (List<Integer> oneTicket : numberIntegration) {
            int matchNumbers = countMatchNumbers(oneTicket);
            if (checkMinimumQualification(matchNumbers)) {
                putTicketResult(matchNumbers, oneTicket);
            }
        }
    }

    private int countMatchNumbers(List<Integer> oneTicket) {
        return oneTicket.stream()
                .filter(ticket -> winningNumbers.stream().anyMatch(Predicate.isEqual(ticket)))
                .collect(Collectors.toList())
                .size();
    }

    private void putTicketResult(int matchNumbers, List<Integer> oneTicket) {
        if (matchNumbers == 5) {
            checkBonusNumber(oneTicket);
        }
        int matchNumbersIndex = matchNumbers - INDEX_ADJUSTMENT_VALUE;
        ticketResult.set(matchNumbersIndex, ticketResult.get(matchNumbersIndex) + 1);
    }

    private boolean checkMinimumQualification(int matchNumbers) {
        if (matchNumbers >= MINIMUM_QUALIFICATION) {
            return true;
        }
        return false;
    }

    private void checkBonusNumber(List<Integer> fiveMatchTicket) {
        if (fiveMatchTicket.contains(bonusNumber)) {
            ticketResult.set(FIVE_AND_BONUS_MATCH_INDEX, ticketResult.get(FIVE_AND_BONUS_MATCH_INDEX) + 1);
            ticketResult.set(FIVE_MATCH_INDEX, ticketResult.get(FIVE_MATCH_INDEX) - 1);
        }
    }
}
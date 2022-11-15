package lotto.model.machine;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import lotto.io.Message;
import lotto.io.Output;

import lotto.model.Money;
import lotto.model.lucky.BonusNumber;
import lotto.model.lucky.WinningNumber;

public class NumbersMatchRepository {

    public static int MATCH_NUMBER_BOUNDARY_START = 3;
    public static int MATCH_NUMBER_BOUNDARY_END = 8;
    public static int PERCENTAGE = 100;
    public static int MATCH_FIVE = 5;
    public static int LUCKY = 7;
    public static Long NONE = 0L;
    public static Long ONE = 1L;
    private final HashMap<Integer, Long> ticketMatchTable;

    public NumbersMatchRepository() {
        ticketMatchTable = new HashMap<>();
    }

    public void compareLotto(List<LottoTicket> lottoTickets,
        WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (LottoTicket ticket : lottoTickets) {
            int matchCount = ticket.getLotto().compareTo(winningNumber);
            if (matchCount == MATCH_FIVE && ticket.getLotto().containsBonus(bonusNumber)) {
                checkTable(LUCKY);
            }
            checkTable(matchCount);
        }
        checkEmptyValue();
    }

    private void checkTable(int count) {
        if (!ticketMatchTable.containsKey(count)) {
            ticketMatchTable.put(count, ONE);
        } else if (ticketMatchTable.containsKey(count)) {
            Long integer = ticketMatchTable.get(count);
            integer++;
            ticketMatchTable.put(count, integer);
        }
    }

    private void checkEmptyValue() {
        IntStream.range(MATCH_NUMBER_BOUNDARY_START, MATCH_NUMBER_BOUNDARY_END)
            .filter(i -> !ticketMatchTable.containsKey(i))
            .forEach(i -> ticketMatchTable.put(i, NONE));
    }

    public void showWinningHistory(Output output) {
//        ticketMatchTable.keySet()
//            .stream()
//            .filter(Rank::isMatchCount)
//            .forEach(matchCount -> output.print(Message.getResultMessage(matchCount), ticketMatchTable.get(matchCount)));
//        output.print(Message.LOTTO_RESULT,
//            matchCount, Rank.getRankMoney(matchCount),ticketMatchTable.get(matchCount))

        output.print(Message.FIFTH_RESULT, ticketMatchTable.get(3));
        output.print(Message.FOURTH_RESULT, ticketMatchTable.get(4));
        output.print(Message.THIRD_RESULT, ticketMatchTable.get(5));
        output.print(Message.SECOND_RESULT, ticketMatchTable.get(LUCKY));
        output.print(Message.FIRST_RESULT, ticketMatchTable.get(6));

    }

    public void showYield(Output output, Money money) {
        float originalMoney = money.toFloat();
        AtomicReference<Float> earnedMoney = new AtomicReference<>((float) 0);

        ticketMatchTable.keySet()
            .stream()
            .filter(Rank::isMatchCount)
            .forEach(rank -> earnedMoney.updateAndGet(v -> v + addEarnedMoney(rank)));

        if (originalMoney == 0) {
            originalMoney = 1;
        }
        output.print(Message.YIELD, (earnedMoney.get() / originalMoney) * PERCENTAGE);
    }

    public float addEarnedMoney(Integer matchCount) {
        return ticketMatchTable.get(matchCount) * Rank.getRankMoney(matchCount);
    }
}


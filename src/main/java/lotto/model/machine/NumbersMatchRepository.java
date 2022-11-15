package lotto.model.machine;

import java.text.DecimalFormat;

import java.util.List;
import java.util.HashMap;

import java.util.stream.IntStream;

import java.util.concurrent.atomic.AtomicReference;

import lotto.io.Message;
import lotto.io.Output;

import lotto.model.Money;
import lotto.model.lucky.BonusNumber;
import lotto.model.lucky.WinningNumber;

public class NumbersMatchRepository {

    public static int MATCH_NUMBER_BOUNDARY_START = 3;
    public static int MATCH_NUMBER_BOUNDARY_END = 8;
    public static int PERCENTAGE = 100;
    public static int LUCKY = 7;
    public static float ZERO_FLOAT = 0;
    public static float ONE_FLOAT = 1;
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
            if ((matchCount == Rank.FIFTH.getMatchCount()) &&
                    ticket.getLotto().containsBonus(bonusNumber)) {
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
        output.print(Message.FIFTH_RESULT, ticketMatchTable.get(Rank.FIFTH.getMatchCount()));
        output.print(Message.FOURTH_RESULT, ticketMatchTable.get(Rank.FOURTH.getMatchCount()));
        output.print(Message.THIRD_RESULT, ticketMatchTable.get(Rank.THIRD.getMatchCount()));
        output.print(Message.SECOND_RESULT, ticketMatchTable.get(LUCKY));
        output.print(Message.FIRST_RESULT, ticketMatchTable.get(Rank.FIRST.getMatchCount()));
    }

    public void showYield(Output output, Money money) {
        float originalMoney = money.toFloat();
        AtomicReference<Float> earnedMoney = new AtomicReference<>((float) 0);

        ticketMatchTable.keySet()
                .stream()
                .filter(Rank::isMatchCount)
                .forEach(rank -> earnedMoney.updateAndGet(v -> v + addEarnedMoney(rank)));

        if (originalMoney == ZERO_FLOAT) {
            originalMoney = ONE_FLOAT;
        }
        outputComma(output, (earnedMoney.get() / originalMoney) * PERCENTAGE);
    }

    public float addEarnedMoney(Integer matchCount) {
        return ticketMatchTable.get(matchCount) * Rank.getRankMoney(matchCount);
    }

    public void outputComma(Output output, float yield) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        output.print(Message.YIELD.getMessage(), df.format(Float.parseFloat(Float.toString(yield))));
    }
}


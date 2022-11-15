package lotto.type;

import java.util.Optional;
import lotto.data.entity.Lotto;
import lotto.data.entity.WinNumber;
import lotto.data.repository.WinNumberRepository;
import utils.DecimalFormatter;

public enum LottoResultType {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean needBonusMatch;
    private final int amount;
    private final String viewMessage;

    LottoResultType(int matchCount, boolean needBonusMatch, int amount) {
        this.matchCount = matchCount;
        this.needBonusMatch = needBonusMatch;
        this.amount = amount;
        String conditionAdder = "";
        if (needBonusMatch) {
            conditionAdder = MessageType.BONUS_MATCH.getMessage();
        }
        this.viewMessage = String.format(MessageType.RESULT_COUNT.getMessage(),
                matchCount, conditionAdder, DecimalFormatter.formatNumber((double) amount), "%d");
    }

    public int getAmount() {
        return this.amount;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public boolean isAcquired(Lotto lotto, Long roundId) {
        boolean checkWinNumber = getMatches(lotto, roundId) >= matchCount;
        boolean checkBonus = !needBonusMatch || hasBonusNumber(lotto, roundId);
        return checkWinNumber && checkBonus;
    }

    private static final WinNumberRepository winNumberRepository = WinNumberRepository.getInstance();

    private static int getMatches(Lotto lotto, Long roundId) {
        WinNumber winNumber = findWinNumber(roundId);
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> winNumber.getWinNumbers().contains(number))
                .count();
    }

    private static boolean hasBonusNumber(Lotto lotto, Long roundId) {
        WinNumber winNumber = findWinNumber(roundId);
        return lotto.getNumbers().contains(winNumber.getBonusNumber());
    }

    private static WinNumber findWinNumber(Long roundId) {
        Optional<WinNumber> selectedWinNumber = winNumberRepository.findById(roundId);
        if (selectedWinNumber.isEmpty()) {
            throw new NullPointerException();
        }
        return selectedWinNumber.get();
    }
}

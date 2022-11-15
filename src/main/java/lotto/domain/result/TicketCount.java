package lotto.domain.result;

import lotto.exception.ticketCount.CountLessZeroException;
import lotto.exception.ticketCount.CountMoreMaxException;

public class TicketCount {
    private final int manualValue;
    private final int autoValue;

    private TicketCount(final int manualValue, final int autoValue) {
        validate(manualValue, autoValue);
        this.manualValue = manualValue;
        this.autoValue = autoValue;
    }

    public static TicketCount of(final int fullValue, final int manualValue) {
        return new TicketCount(manualValue, fullValue - manualValue);
    }

    private static void validate(final int manualValue, final int autoValue) {
        if (autoValue < 0) {
            throw new CountMoreMaxException(autoValue);
        }
        if (manualValue < 0 || manualValue + autoValue <= 0) {
            throw new CountLessZeroException(manualValue, autoValue);
        }
    }

    public int ofManual() {
        return manualValue;
    }

    public int ofAuto() {
        return autoValue;
    }
}

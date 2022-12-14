package lotto.domain;

import java.util.Objects;
import lotto.domain.enums.WinResultStatus;

public class WinningResult {
    private final WinResultStatus winResultStatus;
    private int winCount;

    public WinningResult(final WinResultStatus winResultStatus) {
        this.winResultStatus = winResultStatus;
    }

    public void increaseWinCount() {
        winCount++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningResult that = (WinningResult) o;
        return winResultStatus == that.winResultStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winResultStatus);
    }

    @Override
    public String toString() {
        return String.format(winResultStatus.getMessage(), winCount);
    }

    public boolean isNothing() {
        return winResultStatus == WinResultStatus.NOTHING;
    }

    public long getWinningPrice() {
        return winResultStatus.getWinPrice() * winCount;
    }
}

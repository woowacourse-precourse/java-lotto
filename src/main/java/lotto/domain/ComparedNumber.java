package lotto.domain;

import java.util.Objects;

public class ComparedNumber {
    private final int sameCount;
    private final boolean hasBonus;

    public ComparedNumber(int sameCount, boolean hasBonus) {
        this.sameCount = sameCount;
        this.hasBonus = hasBonus;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder().append(sameCount).append("개 일치");
        if (hasBonus) {
            sentence.append(", 보너스 볼 일치");
        }
        return sentence.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparedNumber that = (ComparedNumber) o;
        return sameCount == that.sameCount && hasBonus == that.hasBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameCount, hasBonus);
    }
}

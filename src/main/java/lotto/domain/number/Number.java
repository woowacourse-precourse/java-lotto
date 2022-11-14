package lotto.domain.number;

import lotto.resource.message.ErrorMessage;

import java.util.Objects;

public class Number {

    protected final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(String input) {
        validateNumeric(input);
        this.value = Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue()
            );
        }
    }

    public int getValueAsInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

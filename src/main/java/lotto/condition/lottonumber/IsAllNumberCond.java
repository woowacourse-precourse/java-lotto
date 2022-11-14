package lotto.condition.lottonumber;

import lotto.condition.Condition;

import java.util.Arrays;

public class IsAllNumberCond implements Condition {

    private static final Condition instance = new IsAllNumberCond();
    private static final String REGEX = "[\\d]+";

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        return Arrays.stream(input.split(",")).filter((String chunk) -> !chunk.matches(REGEX)).toArray().length != 0;
    }
}

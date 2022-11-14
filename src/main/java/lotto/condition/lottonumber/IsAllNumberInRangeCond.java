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
        System.out.println(input);
        Object[] objects = Arrays.stream(input.split(",")).filter((String chunk) -> !chunk.matches(REGEX)).toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        return objects.length == 0;
    }
}

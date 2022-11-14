package lotto.condition;

public interface Condition {

    Boolean isSatisfied(String input);

    String getErrorMessage();
}

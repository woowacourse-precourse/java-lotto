package lotto.domain;

public class Ticket {
    private int count;

    Ticket(String userInput) {
        validate(userInput);
        count = Integer.parseInt(userInput) / 1_000;
    }

    private void validate(String userInput) {

    }

    public int getCount() {
        return count;
    }
}

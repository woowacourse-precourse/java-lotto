package lotto;

import java.util.Arrays;
import java.util.List;

public class Client {

    private ClientInput clientInput;

    Client(ClientInput clientInput) {
        this.clientInput = clientInput;
    }

    public int buy() {
        String moneyAmountString = clientInput.get();

        int moneyAmount = parseStringToIntOrElseThrow(moneyAmountString);

        ThousandMultipleOrElseThrow(moneyAmount);

        return moneyAmount;
    }

    public List<Integer> mark() {
        String markedNumberString = clientInput.get();

        for (int i = 0; i < markedNumberString.length(); i++) {
            if (i % 2 == 0) {
                try {
                    markedNumberString.charAt(i);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                if (markedNumberString.charAt(i) != ',') {
                    throw new IllegalArgumentException();
                }
            }
        }

        List<Integer> numbers;
        try {
            numbers = List.of(
                    Arrays.stream(markedNumberString.split(","))
                            .map(number -> Integer.parseInt(number))
                            .toArray(Integer[]::new));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return numbers;
    }


    private int parseStringToIntOrElseThrow(String moneyAmountString) {
        int moneyAmount;
        try {
            moneyAmount = Integer.parseInt(moneyAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return moneyAmount;
    }

    private void ThousandMultipleOrElseThrow(int moneyAmount) {
        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

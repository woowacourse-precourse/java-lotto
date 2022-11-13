package lotto;

public class Client {

    private ClientInput clientInput;

    Client(ClientInput clientInput) {
        this.clientInput = clientInput;
    }

    public int buy() {
        String moneyAmountString = clientInput.get();

        int moneyAmount;
        try {
            moneyAmount = Integer.parseInt(moneyAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return moneyAmount;
    }
}

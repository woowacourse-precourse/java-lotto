package lotto;

public class Client {

    private ClientInput clientInput;

    Client(ClientInput clientInput) {
        this.clientInput = clientInput;
    }

    public int buy() {
        String moneyAmountString = clientInput.get();

        int moneyAmount = parseStringToInt(moneyAmountString);

        ThousandMultipleOrElseThrow(moneyAmount);

        return moneyAmount;
    }

    private int parseStringToInt(String moneyAmountString) {
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

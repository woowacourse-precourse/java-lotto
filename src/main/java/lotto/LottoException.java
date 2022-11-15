package lotto;

public class LottoException {

    public void inputException(int inputMoney) throws IllegalArgumentException {
        if (!isNumber(inputMoney)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(int inputMoney) {
        if (inputMoney < 0) {
            return false;
        }
        return true;
    }
}

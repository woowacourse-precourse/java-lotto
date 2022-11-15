package lotto;

public class Validation {

    public Validation() {

    }

    public boolean cashDivideValidate(int cash, int divide) {
        if (cash % divide == 0) return true;
        return false;
    }
}

package user;


import static message.ErrorMessage.INCORRECT_MONEY_UNIT;
import static message.ErrorMessage.MORE_MONEY;

public class BuyLotto {
    public int countHowMany(int cash) {
        if (cash < 1000) throw new IllegalArgumentException(MORE_MONEY.getStatus());
        if (cash % 1000 != 0) throw new IllegalArgumentException(INCORRECT_MONEY_UNIT.getStatus());

        int result = cash / 1000;
        return result;
    }
}

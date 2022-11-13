package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Service {

    private static final int LOTTERY_PRICE = 1000;
    private static final int LOTTERY_NUMBER_MAX = 45;
    private static final int LOTTERY_NUMBER_MIN = 1;
    private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    Exception exception = new Exception();
    LottoGroup lottoGroup = new LottoGroup();

    public int stringToInt(String string) {
        if(!isInteger(string)){
            exception.isNotIntegerException();
        }
        return Integer.parseInt(string);
    }

    public boolean isInteger(String string) {
        if(string.matches(NUMBER_REGEX) == false) {
            return false;
        }
        return true;
    }

    public boolean isDividedByLotteryPrice(int money) {
        if(money % LOTTERY_PRICE != 0) {
            return false;
        }
        return true;
    }

    public int numberOfLottery(int money) {
        if(!isDividedByLotteryPrice(money)) {
            exception.isMoneyUnitException();
        }
        int lotteryCount = money/LOTTERY_PRICE;
        return lotteryCount;
    }

    public List<Lotto> createLotteryTickets(int numberOfTickets) {
        for(int count = 0; numberOfTickets > count; count++) {
            lottoGroup.createLotto();
        }
        return lottoGroup.getAllLotteryTickets();
    }

}

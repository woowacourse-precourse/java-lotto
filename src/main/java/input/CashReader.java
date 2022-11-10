package input;

import camp.nextstep.edu.missionutils.Console;
import input.NumberGenerator;

public class CashReader {
    private NumberGenerator numberGenerator = new NumberGenerator();
    private int money = 0;
    private int lottoAmount = 0;


    private void validate(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }
    public CashReader(int money) {
        this.money = money;
        validate(money);
    }


}

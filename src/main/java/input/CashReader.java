package input;

import camp.nextstep.edu.missionutils.Console;
import input.NumberGenerator;

public class CashReader {

    private NumberGenerator numberGenerator = new NumberGenerator();
    private int lottoAmount = 0;
    private int money;

    private void validate(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }
    public CashReader(int money) { // 테스트를 위한 생성자
        this.money = money;
        validate(money);
    }
    public CashReader(){ }

}

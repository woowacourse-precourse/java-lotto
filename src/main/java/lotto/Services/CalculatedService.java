package lotto.Services;

import lotto.Dto.Money;
import lotto.Dto.Reword;

import java.util.Map;

public class CalculatedService {

    private int money;

    public int lottoSize(Money money){
        this.money = money.getMoney();
        if(this.money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 돈을 입력하시오");
        }
        return this.money / 1000;
    }

    public String calculatedYield(Map<String,Integer> lottoResult){
        float total = lottoResult.get(Reword.FIVE_WORD.word) * Reword.FIVE_WORD.money
                + lottoResult.get(Reword.FOUR_WORD.word) * Reword.FOUR_WORD.money
                + lottoResult.get(Reword.THREE_WORD.word) * Reword.THREE_WORD.money
                + lottoResult.get(Reword.TWO_WORD.word) * Reword.TWO_WORD.money
                + lottoResult.get(Reword.ONE_WORD.word) * Reword.ONE_WORD.money;

        return String.format("%.2f",total/money);
    }
}

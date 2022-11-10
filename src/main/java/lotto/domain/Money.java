package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Money {
    private Integer money;
    private Integer lottoCount;

    public Money(){
        Integer temp = askMoney();
        validate(temp);
        this.money = temp;
        this.lottoCount = money / 1000;
    }

    public Integer getLottoCount(){
        return lottoCount;
    }
    private Integer askMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private void validate(Integer money) {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}

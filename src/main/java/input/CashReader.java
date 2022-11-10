package input;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.List;
import java.util.ArrayList;

public class CashReader {
    private final int money;

    private void validate(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public CashReader(int money) { // 테스트를 위한 생성자
        this.money = money;
        validate(money);
    }

    public List<Lotto> publishLotto(){
        int amount = money / 1000;
        List<Lotto> lottoes = new ArrayList<>();
        for(int lotto = 0; lotto < amount; lotto ++ ){
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
            lottoes.get(lottoes.size()-1).printLotto();
        }
        return lottoes;
    }
}

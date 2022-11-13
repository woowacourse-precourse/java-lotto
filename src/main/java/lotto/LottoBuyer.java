package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static constant.LottoNumber.LOTTO_PRICE;
import static constant.LottoNumber.MIN_LOTTO_NUMBER;
import static constant.LottoNumber.MAX_LOTTO_NUMBER;
import static constant.LottoNumber.REQUIRE_LOTTO_NUMBER_COUNT;

public class LottoBuyer {
    private int money;
    private List<Lotto> buyersLotto;
    public LottoBuyer(){
        buyersLotto = new ArrayList<>();
    }
    public void getMoney(){
        String moneyInput = Console.readLine();
        InputUtility.isDigit(moneyInput);
        Integer buyerMoney = InputUtility.convertToInteger(moneyInput);
        canDivMoneyByPrice(buyerMoney);
        this.money = buyerMoney;
    }
    public void buyLotto(){
        int lottoCount = money/LOTTO_PRICE.getValue();
        for(int i=0; i<lottoCount; ++i){
            List<Integer> newLottoNumber = makeRandomLottoNumber();
            buyersLotto.add(new Lotto(newLottoNumber));
        }
    }
    private List<Integer> makeRandomLottoNumber(){
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(), REQUIRE_LOTTO_NUMBER_COUNT.getValue());
        lottoNumber.sort(null);
        return lottoNumber;
    }
    private void canDivMoneyByPrice(Integer money){
        if(money % LOTTO_PRICE.getValue() != 0){
            throw new IllegalArgumentException("[ERROR] : 돈이 "+LOTTO_PRICE.getValue()+"로 나누어 떨어지지 않습니다.");
        }
    }

}

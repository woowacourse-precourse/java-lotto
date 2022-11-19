package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


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
    public List<Lotto> giveLotto(){
        return buyersLotto;
    }
    public void getMoney(){
        String moneyInput = Console.readLine();
        InputUtility.isDigit(moneyInput);
        Integer buyerMoney = InputUtility.convertToInteger(moneyInput);
        isNotMinus(buyerMoney);
        canDivMoneyByPrice(buyerMoney);
        this.money = buyerMoney;
    }
    public void buyLotto(){
        int lottoCount = money/LOTTO_PRICE.getValue();
        System.out.println(lottoCount+"개를 구매했습니다.");
        for(int i=0; i<lottoCount; ++i){
            List<Integer> newLottoNumber = makeRandomLottoNumber();
            buyersLotto.add(new Lotto(newLottoNumber));
        }
        printLottos(buyersLotto);
    }
    private void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getLottoNumber());
        }
    }
    private List<Integer> makeRandomLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(), REQUIRE_LOTTO_NUMBER_COUNT.getValue());
        List<Integer> lottoNumber = new ArrayList<>(numbers);
        lottoNumber.sort(null);
        return lottoNumber;
    }
    private void isNotMinus(Integer number){
        if(number<0){
            throw new IllegalArgumentException("[ERROR] money의 값이 음수입니다.");
        }
    }
    private void canDivMoneyByPrice(Integer money){
        if(money % LOTTO_PRICE.getValue() != 0){
            throw new IllegalArgumentException("[ERROR] 돈이 "+LOTTO_PRICE.getValue()+"로 나누어 떨어지지 않습니다.");
        }
    }

}

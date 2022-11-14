package lotto;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        Price price = new Price();
        Number num = new Number();
        Lotto lotto = new Lotto(num.getWinningNumberList());
        List<Integer> moneyList = new ArrayList<>();

        for(int i=0; i< price.getLottoTickets(); i++){
            Generator generator =new Generator();
            Match match = new Match(lotto.getLottoNumbers(), generator.getlottoNumbers(), num.getBonusNumber());
            moneyList.add(match.getResults());
            View.lottoNumber(generator.getlottoNumbers());
        }
        View.prizes(moneyList);
        View.yield(calculateYield(price.getInputPrice(), moneyList.stream().reduce(Integer::sum).get()));
    }

    public static float calculateYield(int price, int income){
        return (float)income/price;
    }

}

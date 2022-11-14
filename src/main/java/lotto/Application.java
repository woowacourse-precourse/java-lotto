package lotto;

import lotto.Controller.Generator;
import lotto.Controller.Match;
import lotto.Model.Lotto;
import lotto.Model.Number;
import lotto.Model.Price;
import lotto.View.OutputView;

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
            OutputView.lottoNumber(generator.getlottoNumbers());
        }
        OutputView.prizes(moneyList);
        OutputView.yield(calculateYield(price.getInputPrice(), moneyList.stream().reduce(Integer::sum).get()));
    }

    public static float calculateYield(int price, int income){
        return (float)income/price;
    }

}

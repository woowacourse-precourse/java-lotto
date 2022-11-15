package lotto;

import lotto.domain.*;
import lotto.domain.Analyze;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Print print = new Print();

        UserNumber usernumber = new UserNumber();
        print.intputPrice();
        int price = 0;
        try{
            price = usernumber.inputPrice();
            usernumber.inputPriceZero(price);
            usernumber.inputPriceThousand(price);
        } catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }
        int lottoCount = usernumber.lottoCount(price);
        print.lottoCount(lottoCount);
        List<List> userLottos = usernumber.addLottos(lottoCount);
        print.lottoNumber(userLottos);

        PrizeNumber prizenumber = new PrizeNumber();
        print.inputLotto();
        List<Integer> numbers = new ArrayList<>();
        try{
            numbers = prizenumber.lottoNumber();
        } catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        try{
            Lotto checkLottoNumber = new Lotto(numbers);
        } catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        print.inputBonus();
        Integer bonus = 0;
        try{
            bonus = prizenumber.bonusNumber();
        } catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        try{
            Lotto checkBonus = new Lotto(numbers, bonus);
        } catch(IllegalArgumentException e){
            System.out.println(e);
            return;
        }

        Analyze analyze = new Analyze(numbers, bonus, userLottos);
        print.statistics();
        print.winningMoney(analyze.getMatchFrequency());
        print.profitRate(analyze.profit(lottoCount));
    }
}

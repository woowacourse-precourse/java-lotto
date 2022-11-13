package lotto;

import lotto.Domain.*;
import lotto.Input.InputNumber;
import lotto.Output.PublishedLottoOutput;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    private List<Integer> sixNum;
    private int bonusNum;
    private List<Set<Integer>> publishedLottos;

    public static void main(String[] args) {
        Application application = new Application();
        application.get_SixNum_BonusNum_PublishedLotto();
        //통계 내용출력
        Statistic statistic =
                new Statistic(application.getSixNum(), application.getBonusNum(), application.getPublishedLottos());
        Map<String,Integer> winningMap = statistic.getStatistic();
        //
        Profit profit = new Profit();
        profit.printProfit(winningMap,application.getPublishedLottos().size()*1000);



    }


    public void get_SixNum_BonusNum_PublishedLotto() {
        InputNumber inputNumber = new InputNumber();
        Money money = new Money(inputNumber.insertMoney());
        int userMoneyLottoNum = money.getUserlottonum();

        PublishLotto publishedLottos = new PublishLotto(userMoneyLottoNum);
        PublishedLottoOutput publishedLottoOutput =
                new PublishedLottoOutput(publishedLottos.getPublishedLotto(),userMoneyLottoNum);
        publishedLottoOutput.printPublishedLotto();

        Lotto sixNum = new Lotto(inputNumber.insertSixNum());
        Bonus bonusNum = new Bonus(inputNumber.insertOneNum(), sixNum.getNumbers());

        this.sixNum = sixNum.getNumbers();
        this.bonusNum = bonusNum.getNumber();
        this.publishedLottos = publishedLottos.getPublishedLotto();
    }

    public List<Integer> getSixNum() {
        return sixNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public List<Set<Integer>> getPublishedLottos() {
        return publishedLottos;
    }
}

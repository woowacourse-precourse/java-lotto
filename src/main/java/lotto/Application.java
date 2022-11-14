package lotto;

import lotto.Domain.MainValue.Bonus;
import lotto.Domain.MainValue.Lotto;
import lotto.Domain.MainValue.Money;
import lotto.Domain.MainValue.PublishLotto;
import lotto.Domain.Statistic.Statistic;
import lotto.Input.InputNumber;
import lotto.Output.Profit;
import lotto.Output.MainValue.PublishedLottoOutput;

import java.util.List;
import java.util.Set;

public class Application {
    public List<Integer> sixNum;
    public int bonusNum;
    public List<Set<Integer>> publishedLottos;

    public static final String ERROR = "[ERROR]";
    public static void main(String[] args) {
        try {
        Application application = new Application();
        application.get_SixNum_BonusNum_PublishedLotto();

        Statistic statistic =
                new Statistic(application.sixNum, application.bonusNum, application.publishedLottos);

        Profit profit = new Profit();
        profit.printProfit(statistic.prizeRanks,application.publishedLottos.size()*1000);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR+e.getMessage());
        }



    }


    public void get_SixNum_BonusNum_PublishedLotto() throws IllegalArgumentException {
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

}

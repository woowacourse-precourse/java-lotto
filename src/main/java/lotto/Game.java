package lotto;

import lotto.Domain.MainValue.Bonus;
import lotto.Domain.MainValue.Lotto;
import lotto.Domain.MainValue.Money;
import lotto.Domain.MainValue.PublishLotto;
import lotto.Input.InputNumber;
import lotto.Output.MainValue.PublishedLottoOutput;

import java.util.List;
import java.util.Set;

public class Game {
    public List<Integer> sixNum;
    public int bonusNum;
    public List<Set<Integer>> publishedLottos;
    public void play() throws IllegalArgumentException {
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

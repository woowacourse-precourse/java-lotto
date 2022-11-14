package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.PrintMachine;
import java.util.List;

public class LottoStore {
    private final int lottoPrice = 1000;
    public long validMoney;
    public List<LottoPaper> lottoPapers;

    public void insertMoney() {
        PrintMachine.askPriceToBuy();
        lottoTries(Console.readLine());
    }
    public void lottoTries(String money) {
        Validate validate = new Validate();
        validate.containOthers(money);
        validMoney = validate.validMoney(Long.parseLong(money));
        PrintMachine.volumeBuying(validMoney / lottoPrice);
    }
    public void getLottoPaper(){
        CreateRandomLotto createRandomNumber = new CreateRandomLotto();
        lottoPapers = createRandomNumber.randomLotto(validMoney / lottoPrice);
        PrintMachine.printLottoPapers(lottoPapers);
    }
}

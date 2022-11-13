package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoStore {
    private final int lottoPrice = 1000;
    public long validMoney;
    public List<LottoPaper> lottoPapers;

    public void insertMoney() {
        PrintMessenger.askPriceToBuy();
        lottoTries(Console.readLine());
    }
    public void lottoTries(String money) {
        Validate validate = new Validate();
        validate.containOthers(money);
        validMoney = validate.validMoney(Long.parseLong(money));
        PrintMessenger.volumeBuying(validMoney / lottoPrice);
    }
    public void getLottoPaper(){
        CreateRandomLotto createRandomNumber = new CreateRandomLotto();
        lottoPapers = createRandomNumber.randomLotto(validMoney / lottoPrice);
        printLottoPapers(lottoPapers);
    }
    public void printLottoPapers(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(lottoPaper.number);
        }
    }
}

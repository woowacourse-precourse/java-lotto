package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoStore {
    private final int lottoPrice = 1000;
    private long validMoney;
    private List<LottoPaper> lottoPapers;

    public void insert() {
        PrintMessenger.askPriceToBuy();
        lottoTries(Console.readLine());
    }
    public void lottoTries(String money) {
        Validate checkMoney = new Validate();
        checkMoney.isContainOthers(money);
        validMoney = checkMoney.validMoney(Long.parseLong(money));
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

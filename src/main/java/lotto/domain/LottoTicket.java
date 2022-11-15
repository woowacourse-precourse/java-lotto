package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.UserInputValidator;

public class LottoTicket {
    private final int ticketCount;
    private int purchaseMoney;
    private final List<Lotto> ticket;

    public LottoTicket(String inputMoney) {
        this.ticketCount = purchaseLottoCount(inputMoney);
        setPurchaseMoney(inputMoney);
        this.ticket = lottoTicketGenerate(this.ticketCount);
    }

    public List<Integer> lottoNumberGenerate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    public List<Lotto> lottoTicketGenerate(final int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(lottoNumberGenerate());
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }
        return lottos;
    }

    public int purchaseLottoCount(String inputMoney) {
        UserInputValidator.isNumValidate(inputMoney);

        int money = Integer.parseInt(inputMoney);
        UserInputValidator.moneyUnitValidate(money);

        return money / 1000;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<Lotto> getTicket() {
        return ticket;
    }

    public void setPurchaseMoney(String inputMoney) {
        purchaseMoney = Integer.parseInt(inputMoney);
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}

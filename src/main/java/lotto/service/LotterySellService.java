package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LotteryTicket;
import lotto.domain.User;
import lotto.domain.constant.LottoProperty;
import lotto.repository.LotteryTicketRepository;

import java.util.List;

public class LotterySellService {
    public void sell(User user) throws IllegalArgumentException {
        while (user.hasMoney()) {
            LotteryTicket lotteryTicket = createLotteryTicket();
            registerLotteryTicket(lotteryTicket);
            user.buyLotteryTicket(lotteryTicket);
        }
    }

    public LotteryTicket createLotteryTicket() throws IllegalArgumentException {
        List<Integer> lotteryNumbers = generateLotteryNumbers();
        return new LotteryTicket(lotteryNumbers);
    }

    private void registerLotteryTicket(LotteryTicket lotteryTicket) {
        LotteryTicketRepository repository = LotteryTicketRepository.getInstance();
        repository.addLotteryTicket(lotteryTicket);
    }

    private List<Integer> generateLotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoProperty.MIN_NUMBER.getProperty(),
                LottoProperty.MAX_NUMBER.getProperty(),
                LottoProperty.LENGTH.getProperty()
        );
    }
}

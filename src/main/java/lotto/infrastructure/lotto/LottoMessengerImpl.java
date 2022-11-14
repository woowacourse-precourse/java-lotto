package lotto.infrastructure.lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.service.LottoMessenger;
import lotto.global.message.TextMessage;
import lotto.global.utils.console.Console;

public class LottoMessengerImpl implements LottoMessenger {

    @Override
    public String requestMoney() {
        System.out.println(TextMessage.REQUEST_MONEY);
        return Console.readLine();
    }

    @Override
    public void sendLottosInfo(Lottos lottos) {
        System.out.println();
        System.out.println(TextMessage.sendLottosCount(lottos.size()));
        lottos.sendInfo();
    }

    @Override
    public String requestWinningNumbers() {
        System.out.println();
        System.out.println(TextMessage.REQUEST_WINNING_NUMBERS);
        return Console.readLine();
    }

    @Override
    public String requestBonusNumber() {
        System.out.println();
        System.out.println(TextMessage.REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}

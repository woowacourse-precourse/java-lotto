package lotto.domain.lotto.service;

import lotto.domain.lotto.Lottos;

public interface LottoMessenger {

    String requestMoney();

    void sendLottosInfo(Lottos lottos);
}

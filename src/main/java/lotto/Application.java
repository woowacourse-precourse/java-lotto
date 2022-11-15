package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Lotto> lotto = lottoPublisher.createLotto(1234);
    }
}

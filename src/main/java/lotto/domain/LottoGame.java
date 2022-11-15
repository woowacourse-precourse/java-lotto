package lotto.domain;// @ author ninaaano

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static List<Lotto> lotto;
    private final int LottoTicket;
    private static final int LOTTO_PRICE = 1000;

    public LottoGame(int money) {
        this.LottoTicket = money / LOTTO_PRICE;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> payForLotto(int money){
        lotto = new ArrayList<>();
        int LottoTicket = money / LOTTO_PRICE;
        System.out.println(LottoTicket + InputView.BUY_RESUIT_MESSAGE.getMessage());
        for (int i = 0; i < LottoTicket; i++) {
            List<Integer> createLottoNumber = createLottoNumber();
            lotto.add(new Lotto(createLottoNumber));
        }
        return lotto;
    }

    private List<Integer> sortNumbers(List<Integer> lotto){
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    public void printLotto(List<Lotto> lottoList) {
        for (Lotto number : lottoList) {
            System.out.println(number.getNumbers());
        }
    }


}

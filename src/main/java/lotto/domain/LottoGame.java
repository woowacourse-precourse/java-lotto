package lotto.domain;// @ author ninaaano

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static List<Lotto> lotto;
    private final int LottoTicket;
    private static final int LOTTO_PRICE = 1000;



    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public LottoGame(int money) {
        this.LottoTicket = money / LOTTO_PRICE;
    }

    public List<Lotto> createLotto() {
        lotto = new ArrayList<>();
        for (int i = 0; i < LottoTicket; i++) {
            lotto.add(new Lotto(createLottoNumber()));
        }
        return lotto;
    }

    public List<Lotto> payForLotto(int money){
        lotto = new ArrayList<>();
        int LottoTicket = money / LOTTO_PRICE;
        System.out.println(LottoTicket + InputView.BUY_RESUIT_MESSAGE.getMessage());

        for (int i = 0; i < LottoTicket; i++) {
            lotto.add(new Lotto(createLottoNumber()));
        }
        for(Lotto lotto : lotto) {
            System.out.println(lotto.getNumbers());
        }

        return lotto;
    }








}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static LottoSeller lottoSeller;

    private LottoSeller() {
    }

    public static LottoSeller getInstance() {
        if (lottoSeller == null) {
            lottoSeller = new LottoSeller();
        }
        return lottoSeller;
    }

    public List<Lotto> sellLotto() {
        List<Lotto> lottoTickets = generateTicket(chargeMoney());
        printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private int chargeMoney() {
        int money;

        System.out.println("구입금액을 입력해주세요.");

        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        validatePriceUnit(money);
        return money;
    }

    private void validatePriceUnit(int money) {
        if (money % Constants.LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + Constants.LOTTO_PRICE_UNIT + "원 단위로 입력해주세요.");
        }
    }

    private List<Lotto> generateTicket(int money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (money > 0) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER,
                    Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_COUNT)));
            money -= Constants.LOTTO_PRICE_UNIT;
        }
        return lottoTickets;
    }

    private void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
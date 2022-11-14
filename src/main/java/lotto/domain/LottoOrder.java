package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoOrder {
    private static final int LOTTO_PRICE = 1000; // 로또 1장의 가격
    private List<Lotto> lottoTickets;
    private int lottoCount;

    public LottoOrder(String moneyCommand) throws IllegalArgumentException {
        int lottoCount = calcLottoCount(moneyCommand);

        lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto(generateRandomLottoNumber()));
        }

        this.lottoCount = lottoCount;
    }

    /**
     * 로또 구입 금액 문자열에 해당하는 로또 구입 매수 반환
     *
     * @param moneyCommand 사용자가 입력한 로또 구입 금액 String
     * @return 구입해야 하는 로또 매수 int
     * @throws IllegalArgumentException 입력이 숫자가 아니거나 로또 1장 금액 단위의 숫자가 아닌 경우
     */
    private int calcLottoCount(String moneyCommand) throws IllegalArgumentException {
        int money = 0;

        try {
            money = Integer.parseInt(moneyCommand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_MONEY.toString());
        }

        if (money <= 0 || money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorCode.INVALID_MONEY.toString());
        }

        return money / LOTTO_PRICE;
    }

    /**
     * 로또 숫자 범위 중에서 중복되지 않는 숫자를 로또 한 세트의 개수만큼 뽑는다.
     *
     * @return 로또 숫자 범위에 해당하는 중복되지 않는 숫자들을 한 세트 뽑은 List
     */
    private List<Integer> generateRandomLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(
                Lotto.LOTTO_START_NUMBER, Lotto.LOTTO_END_NUMBER, Lotto.LOTTO_SIZE);

        return lottoNumber;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Lotto ticket : lottoTickets) {
            result.append(ticket.toString());
            result.append("\n");
        }

        return result.toString();
    }
}
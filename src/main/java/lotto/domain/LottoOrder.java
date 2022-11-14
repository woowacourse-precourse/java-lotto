package lotto.domain;

import java.util.List;

public class LottoOrder {
    private static final int LOTTO_PRICE = 1000; // 로또 1장의 가격
    private List<Lotto> lottoTickets;
    private int lottoCount;

    public LottoOrder(String moneyCommand) throws IllegalArgumentException {
        int lottoCount = calcLottoCount(moneyCommand);

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
}

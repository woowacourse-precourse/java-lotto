package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberCreator;

import java.util.List;

/**
 * 사용자에게 로또 구입과 발행을 관리
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class LottoStore {
    private final LottoNumberCreator lottoNumberCreator;

    public LottoStore(LottoNumberCreator lottoNumberCreator) {
        this.lottoNumberCreator = lottoNumberCreator;
    }

    /**
     * 구입 금액에 맞게 로또 구매
     */
    public List<Lotto> buyLotto(String buyAmountBill) {
        int buyAmount = validateConvertNumber(buyAmountBill);
        validateThousandUnits(buyAmount);

        int lottoQuantity = buyAmount / 1000;
        return lottoNumberCreator.createLottoNumber(lottoQuantity);
    }

    /**
     * 구입 금액이 숫자인지 검증
     */
    private int validateConvertNumber(String buyAmountBill) {
        try {
            return Integer.valueOf(buyAmountBill);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자를 입력하셔야 합니다.");
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 구입 금액이 1,000 단위인지 검증
     */
    private void validateThousandUnits(int buyAmount) {
        if (buyAmount % 1000 > 0) {
            System.out.println("[ERROR] 구입 금액은 1,000 단위로 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}

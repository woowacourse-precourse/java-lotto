package lotto;

import camp.nextstep.edu.missionutils.Console;

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
     * 사용자에게 로또 구입금액을 입력해 달라는 문구 출력
     */
    public void printBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /**
     * 구입금액에 맞게 로또 구매
     */
    public List<Lotto> buyLotto() {
        int buyAmount = inputBuyAmount();
        int lottoQuantity = buyAmount / 1000;
        List<Lotto> lotteries = lottoNumberCreator.createLottoNumber(lottoQuantity);
        printLottoAmountAndNumber(lotteries);
        return lotteries;
    }

    /**
     * 사용자에게 로또 구입금액 입력 받기
     */
    private int inputBuyAmount() {
        String buyAmountBill = Console.readLine();
        int buyAmount = validateConvertNumber(buyAmountBill);
        validateThousandUnits(buyAmount);
        return buyAmount;
    }

    /**
     * 로또 수량과 로또 번호 출력 하기
     */
    private void printLottoAmountAndNumber(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.toString());
        }
    }

    private int validateConvertNumber(String buyAmountBill) {
        try {
            return Integer.valueOf(buyAmountBill);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자를 입력하셔야 합니다.");
            throw new IllegalArgumentException(e);
        }
    }

    private void validateThousandUnits(int buyAmount) {
        if (buyAmount % 1000 > 0) {
            System.out.println("[ERROR] 구입 금액은 1,000 단위로 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}

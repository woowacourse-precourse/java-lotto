package lotto;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자에게 로또 구입과 발행을 관리
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class LottoStore {
    /**
     * 사용자에게 로또 구입금액을 입력해 달라는 문구 출력
     */
    public void printBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /**
     * 사용자에게 로또 구입금액 입력 받기
     */
    public int inputBuyAmount() {
        String buyAmountBill = Console.readLine();
        int buyAmount = validateConvertNumber(buyAmountBill);
        validateThousandUnits(buyAmount);
        return buyAmount;
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

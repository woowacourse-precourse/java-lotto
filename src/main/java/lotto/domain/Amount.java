package lotto.domain;

import java.text.DecimalFormat;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    /**
     * 구입 금액을 입력받아 저장하는 메소드
     */
    public static Amount pay(int amount) {
        validate(amount);
        return new Amount(amount);
    }

    /**
     * 총 당첨금의 합을 받아 수익률(소수점 둘째 자리에서 반올림)을 계산하여 반환하는 메소드
     */
    public String getYield(long sumOfMoney) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        return formatter.format(sumOfMoney / (double) amount * 100);
    }

    /**
     * 구매한 금액 만큼의 로또의 개수를 반환하는 메소드
     */
    public int getCount() {
        return amount / LOTTO_PRICE;
    }

    /**
     * 구매금액에 대한 유효성 검증과 예외처리를 하는 메소드
     */
    private static void validate(int amount) {
        if (!isOverPrice(amount)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d 이상의 양수여야 합니다.", LOTTO_PRICE));
        }
        if (!isDividedByPrice(amount)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 단위여야 합니다.", LOTTO_PRICE));
        }
    }

    /**
     * 입력한 문자열이 로또가격 이상의 양수인지 확인하는 메소드
     */
    private static boolean isOverPrice(int amount) {
        return amount >= LOTTO_PRICE;
    }

    /**
     * 입력한 문자열이 1000원으로 나누어 떨어지는지 확인하는 메소드
     */
    private static boolean isDividedByPrice(int amount) {
        return amount % LOTTO_PRICE == 0;
    }
}

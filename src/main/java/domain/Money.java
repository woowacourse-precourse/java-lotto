package domain;

public class Money {
    private final int userAmount;

    /**
     * 로또 구입 금액 입력받기
     * 구입 금액이 1000의 배수가 아니면 예외처리
     * 구입 금액이 1000의 배수라면 구입 금액에 맞게 로또 번호 발행
     */

    public Money(int userAmount) {
        validate(userAmount);
        this.userAmount = userAmount;
    }

    private void validate(int userAmount) {
        if (userAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }


}

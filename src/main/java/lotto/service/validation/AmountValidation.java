package lotto.service.validation;

public class AmountValidation {
    /*
    예외사항
    1. 유저가 입력한 가격이 1,000원 단위가 아닌 경우
    2. 숫자 외 값을 입력한 경우
    -> 2, 3번 처리: 정규식 사용하자 ~ 의미상 if문 쓰는게 더 나은듯
    3. 음수 값을 입력한 경우 ~ int 라서 애초에 방지해줌
    */

    private final int amount;
    private static final int UNIT_OF_AMOUNT = 1000;

    public AmountValidation(int amount) {
        this.amount = amount;
    }


    public boolean isValidAmount() {
        if(amount < UNIT_OF_AMOUNT) {
            return false;
        }
        return amount % UNIT_OF_AMOUNT == 0;
    }
}

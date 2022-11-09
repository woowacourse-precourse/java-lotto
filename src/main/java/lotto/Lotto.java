package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    static int amountToLottoCount(){
        Amount amount = new Amount(InputView.receiveAmount());
        if(!amount.isValidateAmount()) ResultView.exit("1000원 단위로 입력해주세요.");
        return amount.getLottoCount();
    }
}

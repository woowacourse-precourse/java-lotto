package lotto;

public class MoneyInputController extends InputController {

    public String input() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public void validate(Object input) {

        long price;

        try {
            price = Long.parseLong((String) input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 입력이 아니거나, 너무 큰 수입니다.");
        }

        if (price == 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력 가능합니다.");
        }
    }
}

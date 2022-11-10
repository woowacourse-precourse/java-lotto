package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        User user = new User();
        int amount = user.purchaseAmount();

    }
}

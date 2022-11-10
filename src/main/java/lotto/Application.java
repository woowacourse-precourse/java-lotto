package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        User user = new User();
        int amount = user.purchaseAmount();

        if (amountValidation(amount)) {

        }

    }

    private static boolean amountValidation(int amount) {

        try {
            if (amount % 1000 != 0 || amount == -1) {
                throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }
}

package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static boolean checkInputPurchaseMoney(String inputPurchaseMoney) {
        try {
            Validation.isIncludeNotNumber(inputPurchaseMoney);
            Validation.isMultipleOf1000(inputPurchaseMoney);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
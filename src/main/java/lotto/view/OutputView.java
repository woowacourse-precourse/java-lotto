package lotto.view;

public class OutputView {
    private static final String Lotto_Purchase_Quantity_Message = "개를 구매했습니다.";

    public static void OutputLottoPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.println(purchaseQuantity + Lotto_Purchase_Quantity_Message);
    }
}

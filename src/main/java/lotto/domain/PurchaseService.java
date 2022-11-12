package lotto.domain;

public class PurchaseService {
    int purchaseAmount;

    public void parsePurchaseInput(String input){
        isInteger(input);
        isNegative(purchaseAmount);
        isMultipleOf1000(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void isInteger(String input){
        try{
            purchaseAmount = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }
    private void isNegative(int input){
        if(input < 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 0 이상의 1000의 배수여야 합니다.");
        }
    }

    private void isMultipleOf1000(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("[ERROR} 구매 금액은 1000의 배수여야 합니다");
        }
    }

}

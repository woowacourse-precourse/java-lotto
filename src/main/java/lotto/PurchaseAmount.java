package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount {

    private final int purchaseInput;

    public PurchaseAmount(String purchaseInput) {
        validatePurchaseAmount(purchaseInput);
        validateThousandUnit(Integer.parseInt(purchaseInput));
        validCorrectRange(Integer.parseInt(purchaseInput));
        this.purchaseInput = Integer.parseInt(purchaseInput);
    }
    private void validatePurchaseAmount(String inputNumber) {
        try {
            int p = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("[ERROR} 숫자를 입력해주세요.");
        }
    }
    private void validateThousandUnit(Integer inputNumber) {
        if (inputNumber % 1000 !=0) {
            throw new IllegalArgumentException ("[ERROR] 입력은 1000원 단위의 숫자만 가능합니다.");
        }
    }
    private void validCorrectRange(Integer inputNumber){
        if(inputNumber < 1000) {
            throw new IllegalArgumentException ("[ERROR] 최소 1000원 이상은 구매하셔야 합니다.");
        }
    }
    private String getUserInput(){
        System.out.println("구매하실 금액을 입력해주세요");
        return Console.readLine();
    }

}


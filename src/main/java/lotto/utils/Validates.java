package lotto.utils;

public class Validates {
    public boolean validatePurchaseMoney(int purchaseMoney) {
        try{
            if(purchaseMoney % 1000 != 0) throw new IllegalArgumentException();

        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구입 금액이 올바르지 않습니다.");
            throw e;
        }
        return true;
    }

    public boolean validatePurchaseMoneyInt(int purchaseMoney) {
        try{
            if(purchaseMoney % 1000 != 0) throw new IllegalArgumentException();

        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 구입 금액이 올바르지 않습니다.");
            throw e;
        }
        return true;
    }
    private boolean validateLottoCount() {
        return true;
    }

    private boolean validateLottoBound() {
        return true;
    }

}

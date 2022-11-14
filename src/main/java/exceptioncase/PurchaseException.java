package exceptioncase;

import constant.ConstantLottoProgram;

public class PurchaseException {
    public static boolean inputMoneyException(String money) {
        if(money.length()!=money.replaceAll("[^\\d]", "").length()){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        }
        int intTypeMoney= Integer.valueOf(money);
        if(intTypeMoney%1000 !=0)
            return ConstantLottoProgram.ERROR_CODE.isErrorState();
        return true;
    }
}

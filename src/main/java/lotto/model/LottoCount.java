package lotto.model;

public class LottoCount {

//    private int lottoAmount;

//    public LottoCount(String moneyInput){
//        this.lottoAmount = countLotto(moneyInput);
//    }
    public int countLotto(String moneyInput){
        String moneyInputExceptThousand=moneyInput.substring(0,moneyInput.length()-3);
        return Integer.parseInt(moneyInputExceptThousand);
    }
}

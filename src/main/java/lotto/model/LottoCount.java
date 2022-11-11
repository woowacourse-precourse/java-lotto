package lotto.model;

public class LottoCount {
    public int countLotto(String moneyInput){
        String moneyInputExceptThousand=moneyInput.substring(0,moneyInput.length()-3);
        return Integer.parseInt(moneyInputExceptThousand);
    }
}

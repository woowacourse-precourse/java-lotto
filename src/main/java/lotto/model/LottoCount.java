package lotto.model;

public class LottoCount {

    private int lottoAmount;

    public LottoCount(String buyInput){
        this.lottoAmount = countLotto(buyInput);
    }
    public int countLotto(String buyInput){
        String buyInputExceptThousand=buyInput.substring(0,buyInput.length()-3);
        return Integer.parseInt(buyInputExceptThousand);
    }
}

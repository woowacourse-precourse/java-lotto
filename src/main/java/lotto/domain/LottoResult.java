package lotto.domain;

public class LottoResult {
    private LottoProperties lottoProperties;
    public LottoResult(Lotto currentLotto,Lotto awardLotto, int bonusNumber){
        int correct = numberCheck(currentLotto,awardLotto);
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        if (lottoProperties == LottoProperties.LOTTO_THIRDWINNER && isBonusCorrect(currentLotto,bonusNumber)){
            lottoProperties = LottoProperties.LOTTO_SECONDWINNER;
        }
        this.lottoProperties = lottoProperties;
    }
    public int numberCheck(Lotto currentLotto,Lotto awardLotto){
        int correct = 0;
        int i =0;
        int j =0;
        while (i<currentLotto.getNumbers().size() && j<awardLotto.getNumbers().size()) {
            if (currentLotto.getNumbers().get(i) == awardLotto.getNumbers().get(j)) {
                correct++;
                i++;
                j++;
                continue;
            }
            if (currentLotto.getNumbers().get(i) < awardLotto.getNumbers().get(j)) {
                i++;
                continue;
            }
            if (currentLotto.getNumbers().get(i) > awardLotto.getNumbers().get(j)) {
                j++;
                continue;
            }
        }
        return correct;
    }
    public Boolean isBonusCorrect(Lotto currentLotto,int bonusNumber){
        for(int i =0;i<currentLotto.getNumbers().size();i++){
            if (bonusNumber==currentLotto.getNumbers().get(i)){
                return true;
            }
        }
        return false;
    }
    public LottoProperties getLottoProperties(){
        return lottoProperties;
    }
}

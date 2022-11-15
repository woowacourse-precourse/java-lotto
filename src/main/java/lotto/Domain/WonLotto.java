package lotto.Domain;

public class WonLotto {
    private int lottoCount=0;
    private int bonusCount=0;

    public void addCount(int lottoCount,int bonusCount)
    {
        this.lottoCount=this.lottoCount+lottoCount;
        this.bonusCount=this.bonusCount+bonusCount;
    }

    @Override
    public String toString() {
        return "lottoCount : "+lottoCount+", bonusCount : "+bonusCount;
    }
}

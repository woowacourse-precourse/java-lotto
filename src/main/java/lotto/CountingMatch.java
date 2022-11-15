package lotto;

public class CountingMatch {

    private int sameCnt;
    private boolean bonusSame;

    CountingMatch(){
        sameCnt = 0;
        bonusSame = false;
    }

    public void addSameCnt(){
        sameCnt++;
    }

    public void sameBonus(){
        bonusSame = true;
    }

    public int getSameCnt(){
        return sameCnt;
    }

    public boolean isBonusSame(){
        return bonusSame;
    }
}

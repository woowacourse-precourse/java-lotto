package lotto;

public class MatchPair {
    private int matchNumbers;
    private boolean matchBonusNumber;

    public MatchPair(int matchNumbers, boolean matchBonusNumber) {
        this.matchNumbers = matchNumbers;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int calculateRanking(){
        if(this.matchNumbers == 6){
            return 1;
        }
        if(this.matchNumbers == 5 && this.matchBonusNumber == true){
            return 2;
        }
        if(this.matchNumbers <= 5 && this.matchNumbers >= 3){
            return (8-this.matchNumbers);
        }
        return -1;
    }


}

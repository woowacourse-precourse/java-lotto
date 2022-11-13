package lotto;

public class Match {
    public final static int NOTHING = 0;
    private int match = NOTHING;

    public Match(int match){
        if(match >= 3 && match <= 6) {
            this.match = match;
        }
    }

    public int getMatch(){
        return match;
    }
}

package lotto;

/* 당첨 번호와 일치하는 숫자의 갯수를 나타내는 Type으로 사용되는 클래스입니다 */

public class Match {
    public final static int NOTHING = 0;
    private int match = NOTHING;

    public Match(int match) {
        if (match >= 3 && match <= 6) {
            this.match = match;
        }
    }

    public int getMatch() {
        return match;
    }
}

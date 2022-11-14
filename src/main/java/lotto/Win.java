package lotto;

public enum Win {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    BLANK(0, 0);

    private final int cnt_match;
    private final int prize;

    private Win(int cnt_match, int prize) {
        this.cnt_match = cnt_match;
        this. prize = prize;
    }

    public int getCnt_match() {
        return cnt_match;
    }

    public int getPrize() {
        return prize;
    }

    public static Win ranking(int cnt_match, boolean bonus_number) {
        if(cnt_match == 6){
            return FIRST;
        }
        if(cnt_match ==5 && bonus_number == true){
            return SECOND;
        }
        if(cnt_match ==5 && bonus_number == false){
            return THIRD;
        }
        if(cnt_match ==4) {
            return  FOURTH;
        }
        if(cnt_match ==5){
            return  FIFTH;
        }
        return BLANK;
    }
}

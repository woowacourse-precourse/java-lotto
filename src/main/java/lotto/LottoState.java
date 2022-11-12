package lotto;

public enum LottoState {
    NONE(0),
    MATCH_ONE(1),
    MATCH_TWO(2),
    MATCH_THREE(3),
    MATCH_FOUR(4),
    MATCH_FIVE(5),
    MATCH_FIVE_WITH_BONUS(5.5),
    MATCH_SIX(6);

    LottoState(double howMuchYouHit){
    }
}

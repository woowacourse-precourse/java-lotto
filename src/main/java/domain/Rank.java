package domain;

// 일치하는 숫자의 개수에 따른 순위 정보를 담고있는 열거형 상수 클래스
public enum Rank {
    first(6, false, 1),
    second(5, true, 2),
    third(5, false, 3),
    fourth(4, false, 4),
    fifth(3, false, 5),
    nothing(0, false, 0);

    public final int matchCount;
    public final boolean checkBonusNumber;
    public final int ranking;

    Rank(int matchCount, boolean checkBonusNumber, int ranking) {
        this.matchCount = matchCount;
        this.checkBonusNumber = checkBonusNumber;
        this.ranking = ranking;
    }
}

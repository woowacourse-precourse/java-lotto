package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    DEFAULT(0, false, 0);


    private int hitCount;
    private boolean bonusHit;
    private int prizeMoney;


    Rank(int hitCount, boolean bonusHit, int prizeMoney) {
        this.hitCount = hitCount;
        this.bonusHit = bonusHit;
        this.prizeMoney = prizeMoney;
    }


        public static Rank getWinning(int hitCount, boolean bonusHit) {
            return Arrays.stream(Rank.values())
                    .filter(lottoResult -> lottoResult.hitCount == hitCount
                            && lottoResult.bonusHit == bonusHit)
                    .findAny()
                    .orElse(DEFAULT);
        }

    public static List<Rank> getNoDefault() {
        return Arrays.stream(Rank.values())
                .filter(rank -> (!rank.equals(DEFAULT)))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static Rank calculateRank(Lotto userLotto, WinningLotto winningLotto) {
        // 메소드 호출로 필드의 객체를 반환 -> 필드 값이 변경되어서는 안됨
        final List<Integer> userLottoNumbers = userLotto.getNumbers();
        final List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        int hitCount = ((int) userLottoNumbers.stream()
                .filter(number -> winningLottoNumbers.contains(number))
                .count());

        boolean bonusHit = false;
        if (userLottoNumbers.contains(bonusNumber)) {
            bonusHit = true;
        }

        return Rank.getWinning(hitCount, bonusHit);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getHitCount() {
        return this.hitCount;
    }

    public boolean getBonusHit() {
        return this.bonusHit;
    }

}
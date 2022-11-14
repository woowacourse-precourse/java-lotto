package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIFTH(5_000L,
            Arrays.asList(
                    new LottoHitsCountVO(3, true),
                    new LottoHitsCountVO(3, false)
            ),
            "3개 일치 (5,000원)"),
    FOURTH(50_000L,
            Arrays.asList(
                    new LottoHitsCountVO(4, true),
                    new LottoHitsCountVO(4, false)
            ),
            "4개 일치 (50,000원)"),
    THIRD(1_500_000L,
            Arrays.asList(
                    new LottoHitsCountVO(5, false)
            ),
            "5개 일치 (1,500,000원)"),
    SECOND(30_000_000L,
            Arrays.asList(
                    new LottoHitsCountVO(5, true)
            ),
            "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2_000_000_000L,
            Arrays.asList(
                    new LottoHitsCountVO(6, true),
                    new LottoHitsCountVO(6, false)
            ),
            "6개 일치 (2,000,000,000원)"),
    NOTHING(0L, new ArrayList<>(), "");

    private Long prize;
    private List<LottoHitsCountVO> availableHitsCounts;
    private String hitsCountMessage;

    LottoRank(Long prize, List<LottoHitsCountVO> availableHitsCounts, String hitsCountMessage) {
        this.prize = prize;
        this.availableHitsCounts = availableHitsCounts;
        this.hitsCountMessage = hitsCountMessage;
    }

    public static LottoRank findByLottoHitsCountVO(LottoHitsCountVO lottoHitsCountVO) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.hasLottoRank(lottoHitsCountVO))
                .findAny()
                .orElse(NOTHING);
    }

    private boolean hasLottoRank(LottoHitsCountVO lottoHitsCountVO) {
        return availableHitsCounts.stream()
                .anyMatch(availableHitsCount -> availableHitsCount.equals(lottoHitsCountVO));
    }

    public Long getPrize() {
        return prize;
    }

    public String getHitsCountMessage() {
        return hitsCountMessage;
    }
}

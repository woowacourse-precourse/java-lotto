package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    ZERO(0, 0, "");

    private final int count;
    private final long winnings;
    private final String message;

    Rank(int count, long winnings, String message){
        this.count = count;
        this.winnings = winnings;
        this.message = message;
    }

    public int getCount(){
        return count;
    }
    public long getWinnings(){
        return winnings;
    }
    public String getMessage(){
        return message;
    }

    public static int[] calculateRank(LottoTickets lottoTickets, Lotto winningLotto, int bonusNumber){
        List<Lotto> lottos = lottoTickets.getLottoTickets();
        int[] result = new int[7];
        for(int i = 0; i < lottos.size(); i++){
            Rank rank = Rank.getRank(lottos.get(i), winningLotto, bonusNumber);
            result[rank.count]++;
        }
        return result;
    }

    public static Rank getRank(Lotto lotto, Lotto winningNumber, int bonusNumber){
        int correctCount = calculateCorrectNumber(lotto, winningNumber);
        Rank candidate = Arrays.stream(Rank.values())
                .filter(rank -> rank.getCount() == correctCount).findAny().orElse(ZERO);
        if(candidate.getCount() == 5 && isCorrectBonusNumber(lotto, bonusNumber)){
            return SECOND;
        }
        return candidate;
    }

    public static int calculateCorrectNumber(Lotto lotto, Lotto winningLotto){
        List<Integer> lottoNumber = lotto.getLottoNumber();
        List<Integer> winningNumber = winningLotto.getLottoNumber();
        int correctCount = 0;
        for(int i = 0; i < 6; i++){
            if(winningNumber.contains(lottoNumber.get(i))){
                correctCount++;
            }
        }
        return correctCount;
    }

    public static boolean isCorrectBonusNumber(Lotto lotto, int bonusNumber){
        List<Integer> lottoNumber = lotto.getLottoNumber();
        return lottoNumber.contains(bonusNumber);
    }
}

package lotto.model;

import lotto.Constant;
import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draw {

    private Lotto winningLotto;
    private int bonusNum;
    private Map<Rank, Integer> winningStats; // <Rank, 결과 수> Map
    private Map<Integer,Rank> rankClassification; // <로또 일치 번호 수,Rank> Map

    public Draw(Lotto winningLotto, int bonusNum){
        validateBonusNumRange(bonusNum);
        validateBonusNumAndLottoOverlap(winningLotto, bonusNum);
        setRankClassification();
        setWinningStats();
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    // lottoPaper에 적힌 로또 번호를 winningLotto와 비교하여 winningStats에 결과 저장
    public Map<Rank,Integer> getWinningStats(List<Lotto> lottoPaper) {
        Map<Rank, Integer> winningStats = this.winningStats;
        Rank rank;

        for (Lotto tryLotto : lottoPaper) {
            rank = tryLottoRank(tryLotto);
            if (rank.equals(Rank.none)) {
                continue;
            }
            winningStats.compute(rank,(k,v) -> v+1);
        }
        return winningStats;
    }

    // rankClassification 초기화
    private void setRankClassification(){
        Map<Integer,Rank> rankClassification = new HashMap<>();
        rankClassification.put(Constant.firstRankNum,Rank.first);
        rankClassification.put(Constant.thirdRankNum,Rank.third);
        rankClassification.put(Constant.fourthRankNum,Rank.fourth);
        rankClassification.put(Constant.fifthRankNum,Rank.fifth);
        rankClassification.put(2,Rank.none);
        rankClassification.put(1,Rank.none);
        rankClassification.put(0,Rank.none);
        this.rankClassification = rankClassification;
    }

    // winningStats 초기화
    private void setWinningStats(){
        Map<Rank,Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.first,0);
        winningStats.put(Rank.second,0);
        winningStats.put(Rank.third,0);
        winningStats.put(Rank.fourth,0);
        winningStats.put(Rank.fifth,0);
        this.winningStats = winningStats;
    }

    // 개별 Lotto별 Rank 판별
    private Rank tryLottoRank(Lotto tryLotto) {
        int winningCount = winningNumSize(tryLotto);
        boolean bonusExist = isBonusExist(tryLotto,this.bonusNum);
        Rank rank = this.rankClassification.get(winningCount);

        if (rank.equals(Rank.third)) {
            if (bonusExist == true) {
                return Rank.second;
            }
        }
        return rank;
    }

    // tryLotto에서 winningLotto와 일치하는 번호의 개수 계산
    private int winningNumSize(Lotto tryLotto) {
        int winningCount = 0;
        Lotto winningLotto = this.winningLotto;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> tryLottoNumbers = tryLotto.getNumbers();

        for (Integer tryNumber : tryLottoNumbers) {
            if (winningLottoNumbers.contains(tryNumber)) {
                winningCount++;
            }
        }

        return winningCount;
    }

    // tryLotto에서 bonusNum가 있는지 확인
    private boolean isBonusExist(Lotto tryLotto, int bonusNum) {
        if (tryLotto.getNumbers().contains(bonusNum)) {
            return true;
        }
        return false;
    }
    
    private void validateBonusNumRange(int bonusNum) {
        if (!(bonusNum >= Constant.lottoRangeStartNum && bonusNum <= Constant.lottoRangeEndNum)) {
            System.out.println(Constant.errorBonusNumRange);
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumAndLottoOverlap(Lotto winningLotto, int bonusNum) {
        if(winningLotto.getNumbers().contains(bonusNum)) {
            System.out.println(Constant.errorBonusNumAndLottoOverlap);
            throw new IllegalArgumentException();
        }
    }

}

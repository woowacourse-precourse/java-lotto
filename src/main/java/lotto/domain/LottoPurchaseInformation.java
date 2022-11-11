package lotto.domain;

import lotto.constant.Rank;

import java.util.*;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private ValidationInDomain validator = new ValidationInDomain();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private Map<Rank, Integer> lottoResults = new EnumMap<>(Rank.class);
    private int numberOfTickets;
    private int purchaseAmount;
    private int totalWinningAmount;
    private double rateOfReturn;


    public LottoPurchaseInformation(int purchaseAmount){
        validator.checkDividedByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.numberOfTickets = this.purchaseAmount/THOUSAND;
    }
    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public void generateLottoTickets(){
        for(int i = 0; i < numberOfTickets; i++){
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

    public void compareLottoTicketsWith(List<Integer> winningNumbers, int bonusNumber){
        lottoResults.put(Rank.FIFTH, 0);
        lottoResults.put(Rank.FOURTH, 0);
        lottoResults.put(Rank.THIRD, 0);
        lottoResults.put(Rank.SECOND, 0);
        lottoResults.put(Rank.FIRST, 0);
        for(int i = 0; i < lottoTickets.size(); i++) {
            int count = lottoTickets.get(i).calculateCountOfMatchingNumbers(winningNumbers);
            String condition = count + "개 일치";
            if(count == 5 && lottoTickets.get(i).contains(bonusNumber)){
                condition += " 보너스 볼 일치";
            }
            sumLottoResults(condition);
        }
    }

    private void sumLottoResults(String condition){
        if(condition.equals(Rank.FIFTH.condition())){
            lottoResults.replace(Rank.FIFTH, lottoResults.get(Rank.FIFTH) + 1);
            return;
        }
        if(condition.equals(Rank.FOURTH.condition())){
            lottoResults.replace(Rank.FOURTH, lottoResults.get(Rank.FOURTH) + 1);
            return;
        }
        if(condition.equals(Rank.THIRD.condition())){
            lottoResults.replace(Rank.THIRD, lottoResults.get(Rank.THIRD) + 1);
            return;
        }
        if(condition.equals(Rank.SECOND.condition())){
            lottoResults.replace(Rank.SECOND, lottoResults.get(Rank.SECOND) + 1);
            return;
        }
        if(condition.equals(Rank.FIRST.condition())){
            lottoResults.replace(Rank.FIRST, lottoResults.get(Rank.FIRST) + 1);
            return;
        }
    }

    public Map<Rank, Integer> getLottoResults(){
        return lottoResults;
    }

    public void calculateTotalWinningAmount(){
        totalWinningAmount = 0;
        for(int i = 0; i < 5; i++){
            totalWinningAmount += lottoResults.get(Rank.get(i)) * Rank.get(i).winningAmount();
        }
    }

    public void calculateRateOfReturn(){
        double tmp = ((double)totalWinningAmount/purchaseAmount)*1000;
        rateOfReturn = Math.round(tmp)/10.0;
    }

    public double getRateOfReturn(){
        return rateOfReturn;
    }



}

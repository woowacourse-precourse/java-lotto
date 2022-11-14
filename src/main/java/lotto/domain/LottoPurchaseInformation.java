package lotto.domain;

import lotto.constant.Rank;
import lotto.validator.ValidationInDomain;

import java.util.*;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private final ValidationInDomain validator = new ValidationInDomain();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
    private int numberOfTickets;
    private int purchaseAmount;
    private int totalWinningAmount;
    private double rateOfReturn;


    public LottoPurchaseInformation(int purchaseAmount){
        validator.checkDividedByThousand(purchaseAmount);
        validator.checkNegativeNumber(purchaseAmount);
        validator.checkZero(purchaseAmount);
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

    private void initializeWinningStatistics(){
        winningStatistics.put(Rank.NOTHING, 0);
        winningStatistics.put(Rank.FIFTH, 0);
        winningStatistics.put(Rank.FOURTH, 0);
        winningStatistics.put(Rank.THIRD, 0);
        winningStatistics.put(Rank.SECOND, 0);
        winningStatistics.put(Rank.FIRST, 0);
    }

    public void compareLottoTicketsWith(List<Integer> winningNumbers, int bonusNumber){
        initializeWinningStatistics();
        for(int i = 0; i < lottoTickets.size(); i++) {
            Lotto lottoTicket = lottoTickets.get(i);
            Rank ticketRank = lottoTicket.compareNumbersWith(winningNumbers,bonusNumber);
            renewWinningStatistics(ticketRank);
        }
    }

    private void renewWinningStatistics(Rank ticketRank){
        for(int i =  0; i < Rank.size(); i++) {
            Rank winningRank = Rank.get(i);
            if (ticketRank.condition().equals(winningRank.condition())) {
                winningStatistics.replace(winningRank, winningStatistics.get(winningRank) + 1);
                return;
            }
        }
    }

    public Map<Rank, Integer> getWinningStatistics(){
        return winningStatistics;
    }

    public void calculateTotalWinningAmount(){
        totalWinningAmount = 0;
        for(int i = 0; i < Rank.size(); i++){
            totalWinningAmount += winningStatistics.get(Rank.get(i)) * Rank.get(i).winningAmount();
        }
    }

    public void calculateRateOfReturn(){
        final double DIVISOR = 10.0;
        double tmp = ((double)totalWinningAmount/purchaseAmount)*THOUSAND;
        rateOfReturn = Math.round(tmp)/DIVISOR;
    }

    public double getRateOfReturn(){
        return rateOfReturn;
    }
}

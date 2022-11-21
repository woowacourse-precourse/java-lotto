package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Ranking;
import lotto.domain.Lotto;
import lotto.domain.Profit;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private final List<Lotto> playerLotto;
    private final Profit playerProfit;
    private final Winning playerWinning;

    public Player(){
        playerLotto = new ArrayList<>();
        playerProfit = new Profit();
        playerWinning = new Winning();
    }

    public void buyTickets(long payment){
        payTickets(payment);
        makeTickets(countTickets(payment));
    }

    private void payTickets(long payment){
        playerProfit.checkPayment(payment);
    }

    private int countTickets(long payment){
        return (int)(payment / 1000L);
    }

    private void makeTickets(int ticketCount){
        for(int count = 0; count < ticketCount; count++){
            playerLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getPlayerLotto(){
        return playerLotto;
    }

    public HashMap<Ranking, Integer> showWinningStatistics(){
        return playerWinning.figureSameRanking();
    }

    public String showWinningProfit(){
        return playerProfit.getProfit();
    }

    public void addLottoRanking(Ranking lottoRanking){
        addPlayersTicketRank(lottoRanking);
        addPriceOfTicket(lottoRanking);
    }

    private void addPlayersTicketRank(Ranking lottoRanking){
        playerWinning.addRankingOfPlayer(lottoRanking);
    }

    private void addPriceOfTicket(Ranking lottoRanking){
        playerProfit.addPrice(lottoRanking.getWinningMoney());
    }
}

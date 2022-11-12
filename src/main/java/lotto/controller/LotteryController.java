package lotto.controller;

import lotto.model.Computer;
import lotto.model.Player;
import lotto.service.MatchLotteryService;
import lotto.view.ComputerView;
import lotto.view.PlayerView;
import lotto.view.RankingView;

public class LotteryController {

    private final Player player = new Player();
    private final Computer computer = new Computer();
    private final PlayerView playerView = new PlayerView();
    private final ComputerView computerView = new ComputerView();
    private final RankingView rankingView = new RankingView();


    public void createPlayer(){
        makeLottoForPlayer(takePlayersMoney());
        giveLottoToPlayer();
    }

    private String takePlayersMoney(){
        return playerView.payMoney();
    }

    private void makeLottoForPlayer(String playerMoney){
        player.buyTickets(Long.parseLong(playerMoney));
    }

    private void giveLottoToPlayer(){
        playerView.showPlayersLotto(player.getPlayerLotto());
    }

    public void insertWinningNumbers(){

    }

    private String typeWinningLottery(){
        return computerView.getNumbers();
    }

    private void insertWinningLottery(String winningLottoNumber){
        computer.saveWinningTicket(winningLottoNumber);
    }

    private String typeWinningBonusNumber(){
        return computerView.getBonusNumber();
    }

    private void insertWinningBonusNumber(String bonusNumber){
        computer.saveBonusNumber(bonusNumber);
    }

    private void matchPlayerLottoWithWinningNumbers(){

    }

    private void showPlayersResult(){

    }
}

package lotto.service;

import lotto.model.Computer;
import lotto.model.Player;

public class MatchLotteryService {

    private final Player player;
    private final Computer computer;

    public MatchLotteryService(Player player, Computer computer){
        this.player= player;
        this.computer = computer;
    }

    public void matchPlayerWithComputer(){

    }

    private int matchEachTicketWithComputer(){
        return 0;
    }

    private void convertCountToRanking(){

    }

    private boolean isFiveMatch(){
        return false;
    }

    private void separateByBonusNumber(){

    }

    public void makePlayerLottoByPayment(String payment){

    }

    public void saveComputerNumber(String lottoNumber, String bonusNumber){

    }

    public Player getPlayer(){
        return player;
    }

    public Computer getComputer(){
        return computer;
    }
}

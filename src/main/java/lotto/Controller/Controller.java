package lotto.Controller;

import lotto.Domain.Player;
import lotto.Domain.Rank;


public class Controller {
    private LottoService lottoService;
    private PlayerService playerService;
    private RankingService rankingService;

    public Controller() {
        Player player = new Player();
        Rank rank = new Rank();
        this.lottoService = new LottoService(player);
        this.playerService = new PlayerService(player, rank);
        this.rankingService = new RankingService(rank, player);
    }

    public void play() {
        try{
            this.lottoService.lottoService();
            this.playerService.winningNumberService();
            this.rankingService.rankService();
        } catch(IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
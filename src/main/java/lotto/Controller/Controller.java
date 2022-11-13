package lotto.Controller;

import lotto.Domain.Player;
import lotto.Domain.Rank;

public class Controller {
    LottoService lottoService;
    PlayerService playerService;
    RankingService rankingService;

    public Controller() {
        Player player = new Player();
        Rank rank = new Rank();
        this.lottoService = new LottoService(player);
        this.playerService = new PlayerService(player, rank);
        this.rankingService = new RankingService(rank, player);
    }

    public void play() throws IllegalArgumentException {
        this.lottoService.lottoService();
        this.playerService.winningNumberService();
        this.rankingService.rankService();
    }
}
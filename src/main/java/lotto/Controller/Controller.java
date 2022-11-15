package lotto.Controller;

import lotto.Domain.Player;
import lotto.Domain.Rank;


public class Controller {
    private LottoService lottoService;
    private WinningLottoService winningLottoService;
    private RankingService rankingService;

    public Controller() {
        Player player = new Player();
        Rank rank = new Rank();
        this.lottoService = new LottoService(player);
        this.winningLottoService = new WinningLottoService(player);
        this.rankingService = new RankingService(rank, player);
    }

    public void play() {
        try{
            this.lottoService.purchaseLottoService();
            this.winningLottoService.winningNumberService();
            this.rankingService.lottoRankingService();
        } catch(IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
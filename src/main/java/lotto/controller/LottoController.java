package lotto.controller;

import lotto.utils.enums.Rank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final List<List<Integer>> games;
    private final String input;
    private final int bonusNumber;

    public LottoController(List<List<Integer>> games, String input, int bonusNumber) {
        this.games = games;
        this.input = input;
        this.bonusNumber = bonusNumber;
    }

    public void printTotalYield(int budget){
        int totalReward = calculateReward();
        System.out.println(calculateYield(budget, totalReward));
    }

    public static String calculateYield(int budget, int totalReward){

        double totalYield = totalReward / ((double) budget) * 100.0;
        return String.format("총 수익률은 %.1f%%입니다.",totalYield);
    }

    private int calculateReward(){
        List<Lotto> lottos = createLottos(games);
        WinningLotto winningLotto = createWinningLotto(input, bonusNumber);
        lottos.forEach(i -> checkWinningLotto(i,winningLotto));
        return printRankReport();
    }

    private int printRankReport(){
        int totalReward = 0;
        for(Rank rank : Rank.values()){
            totalReward += rank.getReward() * rank.getCount();
            System.out.println(rank.toString());
        }
        return totalReward;
    }

    private void checkWinningLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchNumber = (int) lotto.getGame().stream().filter(i -> winningLotto.getGame().contains(i)).count();
        boolean matchBonusNumber = false;

        if(matchNumber == 5 && lotto.getGame().contains(winningLotto.getBounusNumber())){
            matchBonusNumber = true;
        }

        countUpRank(matchNumber,matchBonusNumber);
    }

    private void countUpRank(int matchNumber, boolean matchBonusNumber){
        Rank rank = Rank.findRank(matchNumber, matchBonusNumber);
        if(rank != null){
            rank.countUp();
        }
    }

    private List<Lotto> createLottos(List<List<Integer>> games){
        return games.stream().map(Lotto::new).collect(Collectors.toList());
    }

    private WinningLotto createWinningLotto(String input, int bonusNumber){
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return new WinningLotto(numbers, bonusNumber);
    }
}
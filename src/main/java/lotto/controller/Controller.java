package lotto.controller;

import lotto.enums.Rank;
import lotto.model.Draw;
import lotto.model.Lotto;
import lotto.model.Rate;
import lotto.model.Shop;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private View view;
    private Shop shop;
    private Draw draw;
    private Rate rate;

    // 요청 수행 method
    public List<Lotto> buyLotto() {
        int price = getPrice();
        shop = new Shop(price);
        shop.getLottoPayed();
        return shop.getLottoPayed();
    }

    public void getWinningNums() {
        draw = new Draw(getWinningLotto(),getBonusNum());
    }

    public Map<Rank,Integer> getWinningStat(List<Lotto> lottoPaper) {
        return draw.getWinningStats(lottoPaper);
    }

    public double getEarningRate(Map<Rank,Integer> winningStats) {
        rate = new Rate(winningStats);
        return rate.getEarningRate();
    }


    // 입력 method
    public int getPrice() {
        String price = readLine();
        return Integer.parseInt(price);
    }

    public Lotto getWinningLotto() {
        String winningLotto = readLine();
        List<Integer> winningLottoNumbers = Arrays.stream(winningLotto.split(","))
                .map(w -> Integer.parseInt(w))
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

    public int getBonusNum() {
        String bonusNum = readLine();
        return Integer.parseInt(bonusNum);
    }
}

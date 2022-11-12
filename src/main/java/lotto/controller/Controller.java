package lotto.controller;

import lotto.Validation;
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

    private View view = new View();
    private Validation validation = new Validation();
    private Shop shop;
    private Draw draw;
    private Rate rate;
    private int price;

    // 요청 수행 method
    public List<Lotto> buyLotto() throws IllegalArgumentException{
        this.price = getPrice();
        shop = new Shop(price);
        shop.getLottoPayed();
        return shop.getLottoPayed();
    }

    public void setWinningNums() throws IllegalArgumentException{
        draw = new Draw(getWinningLotto(),getBonusNum());
    }

    public Map<Rank,Integer> getWinningStat(List<Lotto> lottoPaper) throws IllegalArgumentException{
        return draw.getWinningStats(lottoPaper);
    }

    public double getEarningRate(Map<Rank,Integer> winningStats) throws IllegalArgumentException{
        rate = new Rate(winningStats,price);
        return rate.getEarningRate();
    }


    // 입력 method
    public int getPrice() throws IllegalArgumentException{
        view.printInputPrice();
        String price = readLine();
        validation.validatePriceFormat(price);
        return Integer.parseInt(price);
    }

    public Lotto getWinningLotto() throws IllegalArgumentException{
        view.printInputWinningLotto();
        String winningLotto = readLine();
        List<Integer> winningLottoNumbers = Arrays.stream(winningLotto.split(","))
                .map(w -> Integer.parseInt(w))
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

    public int getBonusNum() throws IllegalArgumentException{
        view.printInputBonusNum();
        String bonusNum = readLine();
        return Integer.parseInt(bonusNum);
    }
}

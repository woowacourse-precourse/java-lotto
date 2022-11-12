package domain;

import camp.nextstep.edu.missionutils.Console;
import common.Constant;

import java.util.*;

public class Player {

    private int lottoPrice = 0;
    private int lottoCount = 0;
    private boolean isBonusNumberIncludedWinningLottoNumber = false;
    private int lottoRevenue = 0;
    private List<Lotto> playerLottoPickNumbers = new ArrayList<>();

    private Map<LottoRank , Integer> winningLottoCount = new HashMap<>();

    public void inputPurchaseLottoPrice(int purchaseLottoPrice){
        this.lottoPrice = purchaseLottoPrice;
    }

    public void canDivideThousand(){
        if(this.lottoPrice% Constant.LOTTO_PRICE != 0)
            throw new IllegalArgumentException(Constant.NOT_VALID_PRICE_EXCEPTION);
    }
    public void countLottoNumber(){
        this.lottoCount = this.lottoPrice/Constant.LOTTO_PRICE;
    }

    public void addLottoCount(){
        this.lottoCount++;
    }

    public void minusLottoCount(){
        this.lottoCount--;
    }

    public void initializeLottoCount(){
        lottoCount = 0;
        isBonusNumberIncludedWinningLottoNumber = false;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getPlayerLottoPickNumbers() {
        return playerLottoPickNumbers;
    }

    public boolean getIsWinningLottoNumberBonusNumber() {
        return isBonusNumberIncludedWinningLottoNumber;
    }

    public int getLottoRevenue() {
        return lottoRevenue;
    }

    public Map<LottoRank, Integer> getWinningLottoCount() {
        return winningLottoCount;
    }
    public void setLottoPrice(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }
}

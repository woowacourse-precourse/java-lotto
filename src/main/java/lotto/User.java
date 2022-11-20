package lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class User {

    private static  final int UNIT_PRICE = 1000;
    private int purchasePrice;
    private List<List<Integer>> userLottos;
    private Map<LottoRanking, Integer> countRanking = new EnumMap<LottoRanking, Integer>(LottoRanking.class);

    User(int purchasePrice){
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;

        int count = purchasePrice / UNIT_PRICE;

        this.userLottos = purchaseLottos(count);
    }



    private void validate(int purchasePrice){
        if (purchasePrice % UNIT_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
        else if(purchasePrice <= 0){
            throw new IllegalArgumentException("[ERROR] 0원보다 큰 값을 입력해주세요.");
        }
    }



    private List<List<Integer>> purchaseLottos(int count){
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<List<Integer>> getUserLottos() {
        return new ArrayList<>(userLottos);
    }

    public BigDecimal caculateRateOfReturn(){
        BigInteger totalReturn = BigInteger.valueOf(0);
        for(LottoRanking lottoRanking : LottoRanking.values()){
            int count = countRanking.get(lottoRanking);
            totalReturn = totalReturn.add(BigInteger.valueOf((long) count * lottoRanking.getPrice()));
        }
        System.out.println(totalReturn);
        BigDecimal rateOfReturn = new BigDecimal(totalReturn);
//        rateOfReturn = rateOfReturn.subtract(BigDecimal.valueOf(purchasePrice));
        rateOfReturn = rateOfReturn.divide(BigDecimal.valueOf(purchasePrice), 5, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return rateOfReturn.setScale(1, RoundingMode.HALF_UP);
    }

    public void setCountRanking(Lotto lotto){
        initCountRanking();

        for(List<Integer> userLotto : userLottos) {
            LottoRanking lottoRanking = lotto.caculateRanking(userLotto);

            if(lottoRanking == null){
                continue;
            }
            int count = this.countRanking.get(lottoRanking);
            this.countRanking.put(lottoRanking, count+1);
        }
    }

    private void initCountRanking(){
        for(LottoRanking lottoRanking : LottoRanking.values()){
            countRanking.put(lottoRanking, 0);
        }
    }

    public Map<LottoRanking, Integer> getCountRanking() {
        return new EnumMap<LottoRanking, Integer>(countRanking);
    }


    //test를 위한 코드. 테스트에서만 이용.
    public void setUserLottos(List<List<Integer>> userLottos) {
        this.userLottos = userLottos;
    }
}

package lotto.domain;

import lotto.domain.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoLogic {

    static int lottoCount;
//    static Lotto getLotto = new Lotto();
    private static List<Lotto> lottos;

    private static int threeSame = 0;
    private static int fourSame = 0;
    private static int fiveSame = 0;
    private static int fiveSameBonus = 0;
    private static int sixSame = 0;

    private List<Integer> winningNumberList;
    private int bonusNumber;

    public void logicRank(String winningNumber, String bonusNumberStr){
        LottoInput lottoInput = new LottoInput();
        winningNumberList = lottoInput.stringToListIntegar(winningNumber);
        bonusNumber = lottoInput.parseStringToInt(bonusNumberStr);
        checkLottoNumber();
    }

    public static int compareLottoNumber(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.getLottoNumber().contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public static boolean compareBonusNumber(Lotto lotto, int bonusNumber) {
        boolean count = false;
        if (lotto.getLottoNumber().contains(bonusNumber)) {
            count = true;
        }
        return count;
    }

    public void checkLottoNumber(){
        for(Lotto lotto : lottos){
            int checkCount = compareLottoNumber(lotto, this.winningNumberList);
            boolean bonus = compareBonusNumber(lotto, this.bonusNumber);
            if (checkCount >= 3 && checkCount <= 6){
                compareSame(checkCount, bonus);
            }
        }
    }

    public void compareSame(int count, boolean bonus){
        if(count == 3){
            this.threeSame++;
        }
        if(count == 4){
            this.fourSame++;
        }
        if(count == 5 && !bonus){
            this.fiveSame++;
        }
        if(count == 5 && bonus){
            this.fiveSameBonus++;
        }
        if(count == 6){
            this.sixSame++;
        }
    }

    public int getThreeSame(){
        return this.threeSame;
    }
    public int getFourSame(){
        return this.fourSame;
    }
    public int getFiveSame(){
        return this.fiveSame;
    }
    public int getFiveBonusSame(){
        return this.fiveSameBonus;
    }
    public int getSixSame(){
        return this.sixSame;
    }

    public void logic(String lottoMoneyInput){
        LottoInput lottoInput = new LottoInput();
        validation(lottoMoneyInput);
        this.lottoCount = lottoInput.lottoCount(lottoMoneyInput); // 로또 개수
        buyLottos(this.lottoCount);

    }

    private final static String ERROR_MESSAGE = "[ERROR]";
    public void validation(String Money){
        try {
            Integer.parseInt(Money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자가 아닙니다.");
        }
    }


    public int getLottoCount(){
        return this.lottoCount;
    }

    public List<Integer> CreateLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void buyLottos(int lottoCount){
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++){
            this.lottos.add(new Lotto(CreateLottoNumber()));
        }
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }





}

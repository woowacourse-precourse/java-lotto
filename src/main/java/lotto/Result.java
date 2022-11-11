package lotto;

public class Result {

    public final int FIRST_PRIZE = 2_000_000_000;
    public final int SECOND_PRIZE = 30_000_000;
    public final int THIRD_PRIZE = 1_500_000;
    public final int FOURTH_PRIZE = 50_000;
    public final int FIFTH_PRIZE = 5000;

    int count=0;
    int bonus_index=0;
    double total_prize=0;
    int [] winning = new int[5];
    double earnRate = 0;

    Printer printer = new Printer();

    public Result() {

    }

    public void compareNumbers(Lottos userLottos, Lotto winningLotto, LottoNumber bonus) {
        for(int sheet=0;sheet<userLottos.size();sheet++){
            Lotto lotto = userLottos.get(sheet);
            compareEachLotto(winningLotto, bonus, lotto);
            compareResult();
            count=0;
            bonus_index=0;
        }
        calculateEarningRate(total_prize, Buyer.money);
    }

    private void calculateEarningRate(double total_prize, int money) {
        earnRate = total_prize/money*100;
        printer.printResult(winning, earnRate);
    }

    private void compareResult() {
        winFirst();
        winSecond();
        winThird();
        winFourth();
        winFifth();
    }

    private void winFifth() {
        if(count==3){
            winning[0]++;
            total_prize+=FIFTH_PRIZE;
        }
    }

    private void winFourth() {
        if(count==4){
            winning[1]++;
            total_prize+=FOURTH_PRIZE;
        }
    }

    private void winThird() {
        if(count==5&&bonus_index==0){
            winning[2]++;
            total_prize+=THIRD_PRIZE;
        }
    }

    private void winSecond() {
        if(count==5&&bonus_index==1){
            winning[3]++;
            total_prize+=SECOND_PRIZE;
        }
    }

    private void winFirst() {
        if(count==6){
            winning[4]++;
            total_prize+=FIRST_PRIZE;
        }
    }

    private void compareEachLotto(Lotto winningLotto, LottoNumber bonus, Lotto lotto) {
        for(int order = 0; order< lotto.size(); order++){
            if(winningLotto.contains(lotto.get(order))){
                count++;
            }
            if(lotto.get(order)== bonus){
                bonus_index=1;
            }
        }
    }
}

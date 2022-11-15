package lotto;

public class Application {

    public static void main(String[] args) {
        int payment = correctPayment(UserInputUi.ENTERCOST.getAnswer());
        if(payment == -1){
            return;
        }
        payment = getCountOfLotto(payment);

        LottoManager lottoManager = new LottoManager(payment);
        if(lottoManager.setWinningNumbers(UserInputUi.ENTERWINNINGNUMBER.getAnswer()) == -1){
            return;
        }

        if(lottoManager.setBonnusNumber(UserInputUi.ENTERBONNUSNUMBER.getAnswer()) == -1){
            return;
        }

        Prize prize = new Prize();
        lottoManager.winALotto(prize);
        prize.showRank(payment);
    }

    public static int getCountOfLotto(int payment){
        System.out.println((payment/1000)+"개를 구매했습니다.");
        return payment/1000;
    }

    public static int correctPayment(String payment){
        int cost;
        try{
            cost = Integer.parseInt(payment);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            return -1;
        }

        if(!(cost % 1000 == 0)){
            System.out.println("[ERROR] 천 원 단위만 입력해주세요.");
            return -1;
        }

        return cost;
    }
}
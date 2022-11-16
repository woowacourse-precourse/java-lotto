package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    int numOfLotto;
    int bonus;
    List<List<Integer>> buyerLotto;
    List<Integer> winningLotto;

    BuyerRequest buyerRequest = new BuyerRequest();
    WiningLottoRequest winingLottoRequest = new WiningLottoRequest();
    Lotto lotto;
    BonusNumber bonusNumber;

    public void printBuyerRequest(String input) {
        numOfLotto = buyerRequest.amountOfLotto(input); //로또 갯수
        System.out.println(numOfLotto+"개를 구매했습니다.");
        buyerLotto = buyerRequest.lottos(numOfLotto); //개수만큼 Lotto List 생성
        printBuyerLotto(buyerLotto);
    }

    public void printBuyerLotto(List<List<Integer>> lotto) {
        for(int i = 0 ; i < lotto.size(); i++) {
            System.out.println(lotto.get(i));
        }
    }
    public void lottoNumber(String number) {
        List<Integer> num = winingLottoRequest.winningNumber(number);
        lotto = new Lotto(num);
        winningLotto = lotto.getNumbers();
    }

    public void setBonusNumber(String number) {
        int num = winingLottoRequest.bonusNumber(number);
        bonusNumber = new BonusNumber(winningLotto, num);
        bonus = bonusNumber.getBonusNumbers();
    }

    public enum WinningMoney{
        First("6개 일치","2,000,000,000원", 2000000000),
        Second("5개 일치, 보너스 볼 일치", "30,000,000원", 30000000),
        Third("5개 일치", "1,500,000원", 1500000),
        Fourth("4개 일치", "50,000원", 50000),
        Fifth("3개 일치", "5,000원", 5000);

        private String correctNum;
        private String printMoney;
        private int money;

        WinningMoney(String correctNum, String printMoney, int money) {
            this.correctNum = correctNum;
            this.printMoney = printMoney;
            this.money = money;
        }

        public int getMoney() {
            return money;
        }

        public String toString() {
            return correctNum + " ("+ printMoney +") - ";
        }
    }

    public int[] winningAmount(List<List<Integer>> buyer, List<Integer> winning, int bonusNumber) {
        //5등, 4등, 3등, 1등, 2등
        int[] winningCount = new int[]{0, 0, 0, 0, 0};

        for(int i = 0 ; i < buyer.size(); i++) {
            int count = (int) buyer.get(i).stream()
                    .filter(element -> winning.contains(element))
                    .count();
            int bonusCount = (int) buyer.get(i).stream()
                    .filter(element -> element == bonusNumber)
                    .count();

            if (count < 3) {
                continue;
            }

            winningCount[count - 3] += 1;

            if (count == 5 && bonusCount == 1) {
                winningCount[2] -= 1; //3등에 카운트 된 것 취소
                winningCount[4] += 1; //2등 카운트 추가
            }
        }

        return winningCount;
    }

    public void earningRate() {
        int[] winningCount = winningAmount(buyerLotto, winningLotto, bonus);
        int earningMoney = winningCount[0]*WinningMoney.Fifth.getMoney()
                + winningCount[1]*WinningMoney.Fourth.getMoney()
                + winningCount[2]*WinningMoney.Third.getMoney()
                + winningCount[4]*WinningMoney.Second.getMoney()
                + winningCount[3]*WinningMoney.First.getMoney();

        String rate = String.format("%.1f",(((float)earningMoney/(float)(numOfLotto*1000))*100));

        System.out.println("총 수익률은 "+rate+"% 입니다");

    }

    public void printStatic() {
        int[] winningCount = winningAmount(buyerLotto, winningLotto, bonus);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(WinningMoney.Fifth.toString()+winningCount[0]);
        System.out.println(WinningMoney.Fourth.toString()+winningCount[1]);
        System.out.println(WinningMoney.Third.toString()+winningCount[2]);
        System.out.println(WinningMoney.Second.toString()+winningCount[4]);
        System.out.println(WinningMoney.First.toString()+winningCount[3]);
        earningRate();
    }

    public void lottoRun() {

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine(); //구입 금액
        printBuyerRequest(input);
        System.out.println("당첨 번호를 입력해 주세요.");
        input = Console.readLine();
        lottoNumber(input);
        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine();
        setBonusNumber(input);
        printStatic();

    }

    public static void main(String[] args) {
        Application application = new Application();
        application.lottoRun();
    }
}

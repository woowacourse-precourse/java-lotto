package lotto.doamin;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    public void start(){
        //구입 금액 입력
        int cost = costInput();
        int count = cost2count(cost);
        // 금액에 따라 개수가 정해지는 로또 뭉치 생성
        LottoBundle lb = new LottoBundle(count);

        //당첨번호 입력
        //Lotto win_lotto = lottoInput();

        //보너스 번호 입력
        //int bonus_num = bonusInput();



        //로또 번호를 비교해서 통계결과를 출력해주는 클래스 생성
        //LottoStatistic ls = LottoStatistic(lb,win_lotto, bonus_num);
        //System.out.println(ls);
    }
    private int costInput(){
        System.out.println("구입금액을 입력해 주세요.");
        String cost_str = readLine();
        try{
            return Integer.parseInt(cost_str);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private int cost2count(int cost){
        if(cost%1000!=0 || cost<0)
            throw new IllegalArgumentException();
        return cost/1000;
    }
}

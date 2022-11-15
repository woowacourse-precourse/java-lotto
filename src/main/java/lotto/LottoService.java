package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import static lotto.constant.Constant.*;

public class LottoService {

    float getMoney=0; //수익
    int [] match = new int[7];
    int ticket=0;
    LottoCalculator lottoCalculator = new LottoCalculator();

    public void play(){

        Player player = new Player();

        System.out.println( GETMONEY );
        String money = Console.readLine();

        ticket = player.putMoneyforLotto(money);
        System.out.println( ticket + TICKET );
        player.setLottos(ticket);

        List<Lotto> lottos = player.getLottos();
        printRandomLottos(lottos);

        System.out.println( WINNING );
        String input = Console.readLine();

        String[] winningNumber = input.split(",");
        List<Integer> win = new ArrayList<>();
        for(String s : winningNumber){
            //try catch
            win.add(Integer.parseInt(s));
            //try catch
        }
        player.setWinningNumber(win);
        System.out.println( BONUS );
        //try catch
        int bonus = Integer.parseInt(Console.readLine());
        //try catch
        player.setBonusNumber(bonus);


        for(Lotto l : lottos){
            int matchCnt=findMathrank(l, player);
            if(matchCnt>=3) {
                match[matchCnt] +=1;
            }
        }
        System.out.println(RATIO);
        printWinnningRatio();
    }

    private int findMathrank(Lotto l, Player player) {
        int matchCnt = lottoCalculator.countMatchNumber(l, player.getWinningNumber());
        if(matchCnt<3) return 0;

        else if(matchCnt==3) {
            getMoney+=Ranking.FIFTH.getMoney();
            return Ranking.FIFTH.getRanking();
        }
        else if(matchCnt==4) {
            getMoney+=Ranking.FOURTH.getMoney();
            return Ranking.FOURTH.getRanking();
        }
        else if(matchCnt==5) {
            boolean bonusSuccess = lottoCalculator.checkMatchBonus(l, player.getBonusNumber());
            if(bonusSuccess){

                getMoney+=Ranking.SECOND.getMoney();
                return Ranking.SECOND.getRanking();

            }else if(!bonusSuccess){
                getMoney+=Ranking.THIRD.getMoney();
                return Ranking.THIRD.getRanking();
            }
        }
        else if(matchCnt==6) {
            getMoney+=Ranking.FIRST.getMoney();
            return Ranking.FIRST.getRanking();
        }
        return -1;
    }

    private void printRandomLottos(List<Lotto> lottos) {
        for(Lotto l : lottos){
            List<Integer> lotto = l.getNumbers();
            System.out.println(String.format("[%d, %d, %d, %d, %d, %d]",
                    lotto.get(0),
                    lotto.get(1),
                    lotto.get(2),
                    lotto.get(3),
                    lotto.get(4),
                    lotto.get(5)));
        }
    }

    private void printWinnningRatio(){
            System.out.println(Ranking.FIFTH.getMatch()+" - "+match[Ranking.FIFTH.getRanking()]+"개");
            System.out.println(Ranking.FOURTH.getMatch()+" - "+match[Ranking.FOURTH.getRanking()]+"개");
            System.out.println(Ranking.THIRD.getMatch()+" - "+match[Ranking.THIRD.getRanking()]+"개");
            System.out.println(Ranking.SECOND.getMatch()+" - "+match[Ranking.SECOND.getRanking()]+"개");
            System.out.println(Ranking.FIRST.getMatch()+" - "+match[Ranking.FIRST.getRanking()]+"개");

            String ratio = String.format("%.1f",(getMoney*100)/(ticket*1000));
            System.out.println("총 수익률은 "+ratio+"%입니다.");
        }

    }

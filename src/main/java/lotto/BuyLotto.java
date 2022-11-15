package lotto;

import java.util.*;

public class BuyLotto {

    Scanner scan = new Scanner(System.in);
    int times = 0;
    int changes = 0;
    int price = 0;
    public void menu(){
        while(true){
            System.out.println("==========================");
            System.out.println("Lotto 프로그램");
            System.out.println("--------------------------");
            System.out.println("1.Lotto 구입");
            System.out.println("2.프로그램 종료");
            System.out.println("==========================");
            System.out.print("\n메뉴선택:");
            int input = scan.nextInt();
            switch(input){
                case 1:
                    lottoGame();
                    break;
                case 2:
                    System.out.println("\n감사합니다");
                    System.exit(0);
            }
        }
    }

    public void lottoGame(){
        System.out.println("\nLotto 구입 시작\n");
        System.out.println("(1000원에 로또번호 하나입니다.)");

        priceCheck();
        if(times==0 || times>100) return;
        System.out.println("\n행운의 로또번호는 아래와 같습니다.");
        for(int i=0; i<times; i++){
            System.out.print("로또번호"+(i+1)+" : ");
            getLotto();
        }

        System.out.println("\n받은 금액은 "+price+"원이고 거스름돈은 "+changes+"원입니다.\n");
    }

    public void priceCheck(){
        times = 0;
        changes = 0;
        System.out.print("금액 입력:");
        price = scan.nextInt();
        if(price < 1000) {
            System.out.println("\n입력 금액이 너무 적습니다. 로또번호 구입 실패!!!\n");
        }
        else if(price > 100000) System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!\n");
        else{
            times = price/1000;
            changes = price%1000;
        }
    }

    public void getLotto(){
        Set<Integer> lottoSet = new HashSet<>();
        while(lottoSet.size()<6){
            lottoSet.add((int)(Math.random()*45)+1);
        }
        List<Integer> lottoList = new ArrayList<>(lottoSet);
        Collections.sort(lottoList);
        for(int i=0; i<lottoList.size(); i++){
            if(i==lottoList.size()-1) {
                System.out.println(lottoList.get(i));
                break;
            }
            System.out.print(lottoList.get(i)+",");
        }
    }

    public static void main(String[] args) {
        new BuyLotto().menu();
    }

}

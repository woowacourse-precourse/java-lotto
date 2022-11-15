package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //System.out.println("[lotto 로또 프로그램 (랜덤 번호 생성 및 당첨 확인) - Random(임의)정수값 생성, while(true)로또 번호 저장, for문 당첨 확인 실시]");

        //로또번호 생성
        RandomNumberGenerator lottogen = new RandomNumberGenerator();
        List<Integer> lottoInit = lottogen.RndNumGen();//로또번호 생성
        Lotto lottonum = new Lotto(lottoInit);
        System.out.println("로또 당첨 번호 : " + lottoInit);
        System.out.println("보너스 번호 : " + lottoInit.get(6));

        // ArrayList를 배열로 변환
        int arrListSize = lottoInit.size();
        int lotto[] = lottoInit.stream().mapToInt(i->i).toArray();

        //랜덤 정수값을 생성하기 위해 Random 객체를 생성해줍니다
        Random random = new Random();

        //random 랜던 정수값을 담을 배열을 선언해줍니다
        int number[] = new int[6];
        Arrays.fill(number, 0); //배열에 초기 전체 데이터 0을 모두 대입시켜줍니다

        int idx = 0; //배열 번지 번호를 지정하기 위한 인덱스 변수값 생성
        while(true) {
            int zero = 0; //0이 아닌값이 정상적으로 모두 저장된것인지 확인 위해 변수 선언
            for(int i=0; i<number.length; i++) {
                if(number[i] == 0) { //배열 각 번지를 전체 확인 하면서 0 값이 있을 경우 zero 값을 증가시킴니다
                    zero ++;
                }
            }
            //zero 변수값이 카운트된게 없을 경우 정상적으로 값이 모두 대입된 것을 확인
            if(zero <= 0) {
                break; //while 무한 루프를 탈출합니다
            }
            else { //배열에 랜덤 정수값을 다 저장하지 않은 경우 수행합니다
                //랜덤 정수값 1부터 45범위까지 임의 정수를 저장합니다
                int random_number = random.nextInt(45)+1;
                //int random_number = number[i];

                //배열에 랜덤으로 생성된 값이 이미 저장되어 있으면 중복저장하지 않기위해 검사를 실시합니다
                int check = 0;
                for(int k=0; k<number.length; k++) {
                    if(number[k] == random_number) {
                        check ++; //배열 각 번지를 전체 확인 하면서 일치하는 정수값이 있을 경우 check 값을 증가시킴니다
                    }
                }

                //이미 저장된 값이 없을 경우 배열에 데이터를 저장시킵니다
                if(check <= 0) {
                    number[idx] = random_number;
                    idx ++; //저장을 수행하기 위한 배열 번지값을 증가시킨 후 다시 while문을 반복합니다
                }
            }
        }//while 문 종료

        System.out.println("사용자 로또 번호 : "+Arrays.toString(number));

        int count = 0;
        boolean bonum = false;
        for(int j=0; j<lotto.length; j++) { //로또 정답 배열
            for(int h=0; h<number.length; h++) { //사용자 로또 번호 배열
                if(lotto[j] == number[h]) {
                    count ++; //사용자 로또 배열 값이 로또 정답 배열 값이랑 같은게 있을 경우 count 증가
                }
                if(lotto[6] == number[h]) { //보너스 번호가 있는지 확인
                    bonum = true;
                }
            }
        }

        System.out.println("맞힌 개수 : "+count);

        if(count == 6) {
            System.out.println("등수 : "+"1등입니다 상금 2,000,000,000원");
        }
        else if(count == 5 && bonum == true){
            System.out.println("등수 : "+"2등입니다 상금 300,000,000원");
        }
        else if(count == 5) {
            System.out.println("등수 : "+"3등입니다 상금 1,500,000원");
        }
        else if(count == 4) {
            System.out.println("등수 : "+"4등입니다 상금 50,000원");
        }
        else if(count == 3) {
            System.out.println("등수 : "+"5등 입니다 상금 15,000원");
        }
        else {
            System.out.println("등수 : "+"꽝 ... 입니다");
        }

    }//메인 종료
}


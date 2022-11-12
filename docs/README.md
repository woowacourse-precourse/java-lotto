# 실행 흐름

1. "구입금액을 입력해 주세요."를 출력한다
    - [예외사항] 숫자만으로 이루어지지 않음
    - [예외사항] 1000으로 나누어 떨어지지 않음
2. "\n%d개를 구매했습니다.\n"를 출력함
3. n개에 해당하는 복권 번호를 출력함
4. "\n 당첨 번호를 입력해 주세요." 를 출력함
5. 당첨 번호를 입력받음
    - [예외사항] 숫자와, ","로 이루어지지 않음
    - [예외사항] ,로 구분했을 때 6개가 아님
    - [예외사항] 1부터 45까지가 아님
    - [예외사항] 중복되는 숫자가 있음
6. "보너스 번호를 입력해 주세요." 를 출력함
7. 보너스 번호를 입력받음
    - [예외사항] 숫자만으로 이루어지지 않음
    - [예외사항] 1부터 45가 아님
    - [예외사항] 당첨번호와 중복됨
8. "\n당첨 통계"를 출력함
9. "---"를 출력함
10. "3개 일치 (5,000원) - %d개\n"
11. "4개 일치 (50,000원) - %d개\n"
12. "5개 일치 (1,500,000원) - %d개\n"
13. "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
14. "6개 일치 (2,000,000,000원) - %d개\n"
15. "총 수익률은 %.2f%%입니다.\n"를 출력함

# 기능 목록

1. Lotto
   - 로또 하나를 담당하는 객체
   - List<Integer> 이 필요함
   - [예외사항] List<Integer>를 받을 때 6개가 아니면 예외
   - [예외사항] 중복이 있으면 예외
   - [예외사항] 로또 시작 숫자(1) 부터 로또 끝 숫자(45) 범위를 넘어가면 예외
   - String getLottoPrinting() 로또의 값을 주어진 형태로 만들어서 String 으로 반환해줌
   - boolean contains(int number) 로또 안에 특정 숫자가 있는지 확인함
   - int getSame(Lotto);
2. Money
    - 1000의 배수로 로또에 사용되는 돈을 관리하는 객체
    - [예외사항] 1000의 배수가 아니라면 예외
    - [예외사항] 음수라면 예외
3. LottoResult
    - 로또 당첨 결과를 관리하는 enum 객체
    - public static LottoResult from(int value)
    - 0개 일치, 1개일치, 2개일치, 3개일치, 4개일치, 5개일치, 5개+보너스 일치, 6개 일치를 다룸
4. Lottos
    - 생성된 로또들을 담당하는 객체
    - List<Lotto>가 필요함
    - 그냥 List<Lotto>를 반환하는 것 대신, Lottos 를 통해 반환하고, getLottos 를 한다면 immutable list 를 보냄
5. MissionRandom
   - 랜덤을 DI 하는 역할을 가지고 있음. 
   - 인터페이스를 통해 LottoCreator 에 주입됨
   - List<Integer> pickUniqueNumbersInRange(int startInclusive,int endInclusive, int count);
6. LottoCreator
    - 로또를 생성하는 역할을 가지고 있음
    - MissionRandom 이 필요함
    - static 메서드 Lottos createLottos(Money);
7. WinningLottery
   - 당첨 번호를 관리하고, 입력을 검증하는 역할을 가지고 있음
   - Lotto 와, int bonusNumber 이 필요함
   - WinningLottery(Lotto)
   - void setBonusNumber(int bonusNumber);
   - [예외사항] bonusNumber 이 범위에서 벗어남
   - [예외사항] bonusNumber 이 lotto 와 중복이 있음 
   - LottoResult getResult(Lotto)
8. LottoStatistic
    - 로또 통계 계산을 담당함
    - WinningLottery 와 Lottos 가 필요함 
    - LottoStatistic(WinningLottery,Lottos);
    - public LottoScoreDto getScore();
9. LottoScoreDto
    - 로또 점수를 전달함
    - 3개, 4개, 5개, 5개+보너스, 6개, 수익률이 필요함
    - long getThree()
    - long getFour()
    - long getFive()
    - long getFiveBonus()
    - double getRate() 가 필요함
10. InputHandler 
     - InputView 와 System 과의 의존성을 낮추는 중간 객체
     - String readLine() 가 필요함
11. InputValidator
    - View 를 도와주는 Utility 객체
12. InputView
     - 사용자의 입력을 담당하는 객체
     - inputHandler 가 필요함
     - int getAmount() 금액을 가져옴. 
     - [예외사항] 숫자만으로 이루어 지지 않음
     - List<Integer> getWinLotteryNumbers()
     - [예외사항] 숫자,숫자 형태로 이루어 지지 않음
13. OutputHandler
    - OutputView 와 System 과의 의존성을 낮추는 중간 객체
    - void printf(String format,Object ...args)
    - void println(String content)
14. OutputView
    - 사용자의 출력을 담당하는 객체
    - outputHandler 가 필요함
    - void printInputAmount() 금액을 입력하라는 내용
    - void printLottos(Lottos) 로또를 몇 개 구매했는지, 형식에 맞게 출력함
    - void printInputWinNumbers() 당첨 번호를 입력하라는 내용
    - void printInputBonusNumber() 보너스 번호를 입력하라는 내용
    - void printStatistics(LottoScoreDto) 통계를 추천하는 것
15. LottoMachine
    - 처음부터 끝까지 관리하는 컨트롤러의 역할을 함
    - view 가 필요함, MissionRandom 이 필요함

# 구현에서 신경쓸 부분

1. 만들었던 기능 목록 작성 순서를 따른다
2. 기능 목록을 객체별로 공개된 메서드를 생각한다
3. 단위 테스트를 공개된 메서드 단위로 생각해야 한다
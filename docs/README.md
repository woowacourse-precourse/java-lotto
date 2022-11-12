## A. 프로그램 기능 흐름도
<hr>

1. 사용자에게 초깃값을 입력 받는다. 
   1. 자바 내장 함수가 아닌, __camp.nextstep.edu.missionutils.Console__ 의 __readLine()__ 를 이용한다.
   2. 로또 구입 금액을 입력 받는다.
      * 구입 금액은 1,000원 단위로 입력 받는다.
      * 1,000원 단위로 나누어 떨어지지 않는 경우 __IllegalArgumentException__ 을 발생한다.
      * 값이 정수가 아니거나, 문자인 경우 __IllegalArgumentException__ 을 발생한다.
   3. 당첨 번호를 입력 받는다.
      * 번호는 (1 ~ 45) 사이의 정수형 숫자이며, 콤마(,)를 기준으로 구분한다.
      * 값이 (1 ~ 45) 사이의 정수형 숫자가 아니거나, 갯수가 6개 아닌 경우 __IllegalArgumentException__ 을 발생한다.
   4. 보너스 번호를 입력 받는다.
      * 번호는 (1 ~ 45) 사이의 정수형 숫자이며, 갯수는 1개이다.
      * 만약 (1 ~ 45) 사이의 정수형 숫자가 아니면 __IllegalArgumentException__ 을 발생한다.


2. 로또를 발행한다.
   1. 발행 갯수는 사용자가 입력한 금액에 비례한다.
      * (예. 1,000원: 1개, 56,000원: 56개)
   2. 로또는 (1 ~ 45) 사이의 정수형 숫자 6개로 이루어져 있다.
      * 각각의 숫자는 서로 중복되지 않는다.
      * 자바 내장 함수가 아닌, __camp.nextstep.edu.missionutils.Random__ 의 __pickUniqueNumbersInRange()__ 를 이용한다.


3. 발행한 로또 수량 및 번호를 출력한다.
   * 발행 순서대로 출력하며, 각 로또의 번호를 오름차순으로 출력한다.


4. 발행한 로또의 당첨 여부를 검사 후 출력한다.
   1. 당첨은 1 ~ 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
      * 1등: 6개 번호 일치 / 2,000,000,000원
      * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
      * 3등: 5개 번호 일치 / 1,500,000원
      * 4등: 4개 번호 일치 / 50,000원
      * 5등: 3개 번호 일치 / 5,000원
   2. 각각의 당첨 여부와, 당첨 금액을 저장한다.
   3. 로또 당첨 결과를 출력한다.
      * 당첨 결과는 5등부터 1등까지 순서대로 출력한다.


5. 로또의 수익률을 계산 및 출력한다.
   1. 로또의 수익률은 로또 구입 금액 대비 로또의 당첨 금액을 백분률화 한 값이다.
      * 로또의 수익률 = (로또 당첨 금액의 합 / 로또 구입 금액) * 100
   2. 로또의 수익률을 출력한다.
      * 수익률은 실수형 숫자이며, 소수점 둘째 자리에서 반올림한다.

#
## B. 프로그램 기능 구조도
<HR>

1. Models
   * Lotto
     - instances: (1 ~ 45)까지 정수형 숫자 6개를 가지는 List
     - methods:
       + getNumbers()
         * input: None
         * output: List<Integer> 해당 로또 숫자
       + getSameNum()
         * input: List<Integer> 다른 로또의 번호
         * output: int 해당 로또와 같은 숫자 갯수
   
   * Standard
      - 1 ~ 5등의 당첨 기준을 담는 Enum 객체
      - key: String 로또 등수 (FIRST, SECOND ...)
      - value: 당첨 기준 조건
   
   * Prize
     - 1 ~ 5등의 당첨액을 담는 Enum 객체
     - key: String 로또 등수 (FIRST, SECOND ...)
     - value: int 상금

   * Result
     - 로또 결과를 담는 객체
     - instance:
       + int totalPrize: 총 상금
       + Map winResult: 1 ~ 5등 당첨 갯수
     - methods:
       + Result()
         * input: Lotto winLotto, List<Lotto> lottoList
         * output: None
       + getTotalPrize()
         * input: None
         * output: int totalPrize
       + getResult()
         * input: None
         * output: Map winResult

   * ErrorMessages
     - 각종 입/출력에 필요한 메세지를 담는 Enum 객체
     - key: String 메세지 이름
     - value: String 메세지 내용


2. Views
   * inputView
     - 각종 입력 기능과 UI를 담당하는 view
     - methods:
       + static inputMoney()
         * input : None
         * output: int 입력한 돈 
         * except: 형 검사, 1000 나누어 떨어지는지 검사
       + static inputWin()
         * input: None
         * output: List<Integer> 입력한 당첨 로또
         * except: 범위/형 검사, 숫자 개수 검사
       + static inputBonus()
         * input: None
         * output: int 입력한 보너스 번호
         * excpet: 범위/형 검사, 숫자 개수 검사

   * outputView
     - 각종 출력 기능과 UI를 담당하는 view
     - methods:
       + static printLottoList()
         * input: List<Lotto> 로또 리스트
         * output: None
       + static printWin()
         * input: Map 당첨된 결과 리스트
         * output: None
       + static printBenefitRatio()
         * input: double 수익률
         * output: None
   

3. Controllers
   * mainController
     - methods:
       + static getLottoCount()
         * input: int 입력된 돈
         * output: int 만들 로또 갯수
       + static makeWinLotto()
         * input: List<Integer> 로또 숫자
         * output: Lotto 당첨 로또
       + static makeLotto()
         * input: int 만들 로또 갯수
         * output: List<Lotto> 만들어진 Lotto List
       + static calBenefitRatio()
         * input: int 입력된 돈, int 당첨 액수
         * output: String 2자리 수에서 반올림된 이익률
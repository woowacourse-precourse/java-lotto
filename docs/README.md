# 기능 구현 목록
>## Model : 데이터 관리
### ConstantDataStorage
- 1~45까지의 수를 포함하는 데이터 저장<br>
당첨 번호의 개수인 6 저장<br>
보너스 번호의 개수인 1 저장
### LottoTicketStorage
- 발행된 로또티켓들을 저장
### WinNumbersStorage
- 당첨 번호 저장
### BonusNumberStorage
보너스 번호 저장
### NumberOfCorrespondedNumberStorage
- 일치한 번호의 개수 저장
> ## View : 입출력 관리
### MoneyReceiver
- 금액을 입력받음
### LottoWinNumberReceiver
- 당첨번호를 입력받음
### BonusNumberReceiver
- 보너스번호를 입력받음
### ConstantMents
- 어플리케이션 진행중 사용되는 각종 출력 양식을 상수화
### IssuedLottoPrinter
- 발행한 로또들을 출력
### ResultPrinter
- WinResultManager로부터 받은 값을 출력
> ## Controller : 알고리즘 관리
### 도메인 로직
#### Casher
- 1000원 단위로 떨어지는 티켓수 발행
- 남은 금액은 예외처리 후 반환
#### WinResultManager
- 일치하는 번호의 개수, 금액을 반환
#### EarningRateCalculator
- 수익률 계산
### 예외처리 로직
> 예외 상황시 로그를 활용하여 반드시 앞에 [ERROR] 문구 출력
#### 내부 예외처리
- 티켓이 구입한 금액의 1000원 단위에 맞게 나왔는지 체크
- 1000원으로 나눠떨어지는지 확인후 잔돈이 생기는지 체크
#### IllegalArgumentException
- 로또 번호의 숫자 범위가 1~45인지 체크
- 숫자 중복 여부 체크
- 숫자의 자릿수(당첨 번호가 총 6개인지, 보너스번호는 1개인지) 체크
- 유저가 입력한 값이 숫자인지 확인
## 3주차 구현 기능 목록


### 로또
로또의 1번부터 45번까지 나올수있는 함수`lottoRandomNumber()`
사용자구매 = 로또 번호당첨번호 비교 한 뒤 당첨내역 및 수익률을 나오게 해주는 종료하는 메서드	`toResult ()`;
수익률 계산해주는 메서드 `decimalPointCirculator()`;
보너스 판단여부 `BonuseChoose(), BonusChooseList()`
몇개일치 판단여부 `ScoreNumber()`
금액일치 판단여부 `TotalNumber()`
총 맞은 개수 판단여부 `CountNumberMessage()`
금액을 한자리로 수로 바꾸어 *개를 구매하였습니다에 해당하는 *개를 나타내는 함수 `buyScuessCount()`

### 유저
1개의 로또를 만들어내는 함수 `userInputLotto()` - 1000원으로 나누어떨어지지않을 시 예외처리3

*구입금액을 입력하라는 매서드 `inputBuyPrice()`
중복되지않는 6개의 숫자를 뽑는 함수`lottoListSix()` ++ValidatorLottoInputList예외처리
*보너스번호를 입력하라는 매서드 `bonusNumber()`

### 출력

*구입금액을 입력해주세요 메세지를 나타내는 함수 `inputBuyPrice()`
*개를 구매했습니다라는 메세지를 나타내는 함수 `buySucess()`


### 예외사항

Class Validator포함

1번 부터 45번까지의 숫자입력
6개이상 이하번호를 입력할때
중복된 숫자가 있을때 
보너스 중복된 수
보너스 수 1부터 45
금액 1000단위, 금액 숫자만 가능판단 여부
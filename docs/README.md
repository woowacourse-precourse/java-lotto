<h1>로또 게임 기능 단위 목록 작성</h1>
<hr>

## Domain

### Lotto
-  getNumbers() : 로또 넘버 목록 반환해주는 메서드
-  getBonusNumber() : 보너스 넘버를 반환해주는 메서드
-  Lotto 생성자 : 입력한 당첨 번호와 보너스 넘버의 예외처리를 해주고 set 해주는 메서드


### User
-  user 생성자 : 유저가 입력한 값을 저장하고, 로또의 개수를 저장하고 초기 금액을 0으로 설정해주는 메서드
-  getPrice() : 입력한 가격을 반환해주는 메서드
-  setLottosCount : User가 구매한 로또의 넘버(1쌍에 6개)쌍을 lottoGenerater를 불러와서 저장해주는 메서드
-  getUserLottos() : User가 구매한 로또의 넘버(1쌍에 6개)쌍을 반환해주는 메서드

### Rank

- Rank : 순위 결정 : THIRD, FOURTH, FIFTH, FIFTH_WITH_BONUS, SIX

### UserLotto

- UserLotto 생성자 : List형 lottoNumbers 쌍을 저장해주는 생성자
- getLottoNumbers : List형 lottoNumbers 쌍을 반환해주는 메서드

### Constant 
-  필요한 상수 목록 정의 (로또의 최소 숫자, 로또의 최대 숫자, 숫자 정규식, 에러 메세지, 한 쌍에서의 로또의 개수)

## Service
### LottoCalculateService
-  calculateWinningCount() : 유저의 로또의 당첨 로또에서 매칭되는 숫자를 check 해주는 메서드
-  getTotalPrice() : 전체 당첨 금액을 반환해주는 메서드
-  calculateOfLottoAndUserNumber() : 로또 등수를 체크해주는 메서드
-  getEarningRate() : 수익률을 계산해주고 반환해주는 메서드
### LottoInputNumbersService
-  inputLottoNumbers() : 당첨로또의 리스트를 입력하고 보너스 번호를 입력해주는 메서드
-  parsingNumbers() : 입력받은 당첨로또 숫자를 "," 단위로 끊어서 parsing하여 int형 숫자를 반환해주는 메서드
-  parsingBonusNumber() : 입력받은 보너스 숫자를 int형으로 parsing하여 반환해주는 메서드


### UserInputNumbersService
-  inputUserNumbers() : 유저의 금액을 입력받고, 로또의 개수에 맞게 로또 리스트를 반환해주는 메서드 
-  parsingPrice() : String을 int형으로 parsing하여 로또 금액을 반환해주는 메서드 
-  getUserBuyingLottoPrice() : 유저가 구매한 로또 금액을 반환해주는 메서드


## Controller

### LottoGameController
- startGame() : 로또 게임을 실행시켜주는 메서드 


## View

### InputView
- askInputLottoBuyingPrice() : 유저가 구매한 로또 금액을 입력받고, 구매한 로또 가격을 리턴해주는 메서드
- askInputBonusNumber() : 보너스 넘버를 입력받는 메서드
- askInputLottoLuckyNumbers() : 당첨 로또 넘버를 입력받는 메서드

### OutputView 
- printAskBuyingLottoPriceMessage() : "구입 금액을 입력해 주세요." 메세지를 출력해주는 메서드
- printBuyingLottoQuantityMessage() : "로또를 구매한 개수에 대한 메세지"를 출력해주는 메서드
- printUserLottoNumber() : 유저에 대한 로또 리스트를 모두 출력해주는 메서드 
- printAskLottoNumberMessage() : "당첨 번호를 입력해 주세요." 메세지를 출력해주는 메서드
- printAskBonusNumberMessage() : "보너스 번호를 입력해 주세요" 메세지를 출력해주는 메서드
- printTotalResultMessage() : "당첨 통계"를 출력해주는 메서드
- printEarningRateOfLottoMessage() : "수익률"을 출력해주는 메서드
## Exception

### LuckyLottoNumberException
- checkLuckyLottoNumberExceptions() : 로또 당첨 번호에 대한 예외들을 모두 처리해주는 메서드
- checkLottoBonusNumberExceptions() : 로또 보너스 번호에 대한 예외들을 모두 처리해주는 메서드 
- checkDuplicatedLottoNumber() : 로또 당첨 번호 목록이 중복되었는지 check 해주는 메서드 
- checkLottoNumberBetweenOneAndFortyFive() : 로또 당첨 번호 목록이 1 ~ 45에 속하는지 포함된 메서드 
- checkDuplicatedLottoBonusNumber() : 로또 보너스 번호가 중복되었는지 check 해주는 메서드
- checkLottoBonusNumberBetweenOneAndFortyFive() : 로또 보너스 번호가 1 ~ 45에 속하는지 포함된 메서드

### UserException
- checkUserExceptions() : 유저가 입력한 값에 대한 예외들을 처리해주는 메서드 
- checkLottoPriceDividedByOneThousand() : 유저가 입력한 로또 금액에 대한 예외처리를 해주는 메서드
- checkUserLottoPriceAboutOnlyNumbers() : 유저가 입력한 로또 금액이 숫자로만 구성되었는지 check 해주는 메서드
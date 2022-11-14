# 기능 목록
## 요구사항
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다
- else 예약어를 사용하지 않는다
- Enum을 적용한다
- 도메인 로직에 단위 테스트를 구현해야 한다
## 개인 목표 사항
- 클래스를 패키지로 묶어 가독성을 높이자
## 기능 목록
- MVC Pattern을 적용해 문제를 해결합니다.M:Model, V:View, C:Controller E:ErrorCheck
- [x] M 로또 구매 금액을 입력받는다. - InputLotto#inputMoney()
  - [x] E 숫자를 입력했는지 확인한다. - ErrorControl#validateNumber
  - [x] E 1000으로 나워지는지 확인한다 -ErrorControl#validateDivideThousand()
- [x] M 구매 금액을 통해 구매할 로또 장수를 계산한다 - LottoData#LottoData() (생성자)
- [x] M 당첨 번호를 입력받는다 - InputLotto#inputWinNumber(), convertToWinNumber()
  - [x] E 쉼표를 기준으로 구분했는지, 숫자가 6개인지 확인한다. - ErrorControl#validateSeparatorAndSize()
  - [x] E 입력한게 숫자인지, 숫자가 1~45사이에 있는지 확인한다. - ErrorControl#validateNumberInRange()
  - [x] E 중복 숫자가 없는지 확인한다. - ErrorControl#validateDuplicateNumber()
- [x] M 보너스 번호를 입력받는다. - InputLotto#inputBonusNumber(), convertToBonusNumber()
  - [x] E 입력한게 숫자인지, 숫자가 1~45사이에 있는지 확인한다. - ErrorControl#validateNumberInRange()
  - [x] E 당첨 번호와 중복 없는지 확인한다. - ErrorControl#validateDuplicateNumber()
- [x] M 로또 번호를 랜덤으로 생성해 로또 객체를 생성하며 이 객체를 리스트에 담는다 - LottoData#makeLotto()
- [x] M ~~로또 객체의 번호와 당첨 번호, 보너스 번호를 비교해~~일치 개수, 보너스번호 일치 여부로 당첨 등수 산정한다. - LottoCalculate#calculatePrize()
  - [x] M 로또 번호, 당첨 번호를 비교해 일치 개수를 계산한다 - LottoCalculate#checkMatches()
  - [x] M 로또 번호, 보너스 번호를 비교해 일치 여부 확인한다 - LottoCalculate#checkBonusNumber()
- [x] M 수익률을 계산한다. (소수점 둘째 자리에서 반올림.) - LottoCalculate#calculatePercentageOfReturn()
- [x] M LottoCalculate 내 함수를 사용해 Lotto 객체에 로또 번호에 따른 등수 및 상금을 업데이트 한다. -LottoCalculate#calculateOverall()
- [x] M LottoData 에 등수, 상금 데이터를 추가한다 - LottoData#calculateallLotto()
- [x] M Lotto에 추가된 등수, 상금 데이터를 모아 저장한다 - LottoData#countPrize(), LottoData#sumPrizeMoney()
- [x] M Lotto 객체로 lottoNumber 를 출력할 수 있도록 toString 을 오버라이딩 한다 - Lotto#toString()
- [x] M LottoData 객체에 수익률을 저장할 수 있도록 한다. - LottoData 에 percentageOfReturn 변수 선언
- [x] E Lotto 객체에 매개변수로 들어오는 numbers 가 중복이 없는지 확인한다 - ErrorControl#validateDuplicateNumber()
- V 입력을 위한 문구를 출력한다. - InputView
  - [x] V 구입할 금액을 입력해주세요. - InputView#printHowMuch()
  - [x] V 당첨 번호를 입력해 주세요. - InputView#printInputWinNumber()
  - [x] V 보너스 번호를 입력해 주세요. - InputView#printInputBonusNumber()
- V 출력을 위한 문구를 출력한다. - OutputView
  - [x] V %d개를 구매했 습니다. - OutputView#printPurchaseAmount()
  - [x] V 구매한 로또 번호 출력 - OutputView#printPurchaseLottoNumber()
  - [x] V 당첨 통계 출력 - OutputView#printPrize()
  - [x] V 수익률 출력 - OutputView#printWinPersentage()
  - [x] V enum 을 통해 데이터를 가지고 올 수 있도록 변환해준다 - OutputView#getLottoPrizeMoney()
- C M,V 를 활용해 데이터의 흐름 조절한다 - LottoController
  - [x] C 구입 금액 입력 후 구매of 한 로또 번호 출력 - LottoController#buyLotto()
  - [x] C 당첨, 보너스 번호 입력 후 당첨 통계, 수익률 출력 - LottoController#checkLottoResult()
- [x] **Application 에서 최종 수행하기 - Application#main()**

## 삭제한 기능 목록
- ~~E 숫자가 총 6개인지 확인한다. - validateSize()~~
- ~~E 숫자가 1개인지 확인한다. - validateSize()~~
- ~~M 로또 구매 장수 만큼 로또 객체 생성해 리스트에 담는다 - LottoData#makeLottoList()~~
- ~~M 당첨 금액을 계산한다. - LottoCalculate#calculateWinMoney()~~
- ~~M Lotto 객체에 상금, 등수 정보를 저장할 수 있도록 메서드, 변수를 설정한다. - Lotto~~



## 기능 요구 사항
1. 구매 금액 입력받기 (1000원 단위)
2. 1번 구매 금액에 따라 구매한 로또 번호 생성 후 출력하기
3. 당첨 번호 입력받기 (번호는 쉼표(,)를 기준으로 구분한다.)
4. 보너스 번호 입력받기
5. 로또 번호와 당첨 번호, 보너스 번호 비교해 당첨 등수 산정 후 출력하기
6. 당첨 금액 계산해 수익률 체크 후 출력하기 (수익률은 소수점 둘째자리에서 반올림)

## 개선 필요 사항
- [x] **Lotto 클래스의 인스턴스 변수 삭제**
  - [x] prize 를 Lotto 클래스에 담지 말고, LottoData 클래스에 담기
  - [x] prizeMoney 를 Lotto 클래스에 담지 말고, LottoData 클래스에 누적시키기
- [x] error 검사 전용 클래스 생성
- [x] OutputView#getLottoPrizeMoney() 함수 클래스 이동 -> enum 클래스 생성
- [x] LottoInput 클래스 에 저장되는 데이터를 LottoData 클래스로 옮기기
- [x] enum 사용을 위한 LottoCalculate#calculatePrize() 메서드 간소화하기
- [x] LottoData 클래스에서 map 초기값 입력 간소화 혹은 map 말고 다른 자료형 사용하기
- [x] OutputView#printPercentageOfReturn() 에서 퍼센트 값이 클 때 E사용 안하고 출력하기
- [x] 하드코딩 제거, 상수 이름에 정보 추가하기
  - [x] OutputView
- [x] 당첨금을 1,2,3,4,5,6, 처럼 끝에 콤마를 추가로 입력했을 때 에러 발생시키기 -ErrorControl#validateNumberOfSeparate()
- [x] public ,private, 상수 정리 및 Java 컨벤선에 따라 위치 조정하기


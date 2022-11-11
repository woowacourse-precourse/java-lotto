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
- M [x] 로또 구매 금액을 입력받는다. - InputLotto#inputMoney()
  - E [x] 숫자를 입력했는지 확인한다. - validateNumber
  - E [x] 1000으로 나워지는지 확인한다 -validateDivideThousand()
- M [x] 구매 금액을 통해 구매할 로또 장수를 계산한다 - LottoData#LottoData() (생성자)
- M [x] 당첨 번호를 입력받는다 - InputLotto#inputWinNumber()
  - E [x] 쉼표를 기준으로 구분했는지, 숫자가 6개인지 확인한다. - validateSeparatorAndSize()
  - E [x] 입력한게 숫자인지, 숫자가 1~45사이에 있는지 확인한다. - validateNumberInRange()
  - ~~E [ ] 숫자가 총 6개인지 확인한다. - validateSize()~~
  - E [x] 중복 숫자가 없는지 확인한다. - validateDuplicateNumber()
- M [x] 보너스 번호를 입력받는다. - InputLotto#inputBonusNumber()
  - E [x] 입력한게 숫자인지, 숫자가 1~45사이에 있는지 확인한다. - validateNumberInRange()
  - ~~E [ ] 숫자가 1개인지 확인한다. - validateSize()~~
  - E [x] 당첨 번호와 중복 없는지 확인한다. - validateDuplicateNumber()
- M [x] 로또 번호를 랜덤으로 생성해 로또 객체를 생성하며 이 객체를 리스트에 담는다 - LottoData#makeLotto()
- ~~M [ ] 로또 구매 장수 만큼 로또 객체 생성해 리스트에 담는다 - LottoData#makeLottoList()~~
- M [x] ~~로또 객체의 번호와 당첨 번호, 보너스 번호를 비교해~~일치 개수, 보너스번호 일치 여부로 당첨 등수 산정한다. - LottoCalculate#calculatePrize()
  - M [x] 로또 번호, 당첨 번호를 비교해 일치 개수를 계산한다 - LottoCalculate#countMatches()
  - M [x] 로또 번호, 보너스 번호를 비교해 일치 여부 확인한다 - LottoCalculate#checkBonusNumber()
- M [x] 당첨 금액을 계산한다. - LottoCalculate#calculateWinMoney()
- M [ ] 수익률을 계산한다. (소수점 둘째 자리에서 반올림.) - LottoCalculate#calculateWinPersentage()
- V 입력을 위한 문구를 출력한다. - InputView
  - V [ ] 구입할 금액을 입력해주세요. - InputView#printHowMuch()
  - V [ ] 당첨 번호를 입력해 주세요. - InputView#printInputWinNumber()
  - V [ ] 보너스 번호를 입력해 주세요. - InputView#printInputBonusNumber()
- V 출력을 위한 문구를 출력한다. - OutputView
  - V [ ] %d개를 구매했 습니다. - OutputView#printPurchaseAmount()
  - V [ ] 구매한 로또 번호 출력 - OutputView#printPurchaseLottoNumber()
  - V [ ] 당첨 통계 출력 - OutputView#printPrize()
  - V [ ] 수익률 출력 - - OutputView#printWinPersentage()
- C M,V 를 활용해 데이터의 흐름 조절한다 - LottoController
  - C [ ] 구입 금액 입력 후 구매한 로또 번호 출력 - LottoController#buyLotto()
  - C [ ] 당첨, 보너스 번호 입력 후 당첨 통계, 수익률 출력 - LottoController#checkLottoResult()
- **[ ] Application 에서 최종 수행하기 - Application#main()**


## 기능 요구 사항
1. 구매 금액 입력받기 (1000원 단위)
2. 1번 구매 금액에 따라 구매한 로또 번호 생성 후 출력하기
3. 당첨 번호 입력받기 (번호는 쉼표(,)를 기준으로 구분한다.)
4. 보너스 번호 입력받기
5. 로또 번호와 당첨 번호, 보너스 번호 비교해 당첨 등수 산정 후 출력하기
6. 당첨 금액 계산해 수익률 체크 후 출력하기 (수익률은 소수점 둘째자리에서 반올림)

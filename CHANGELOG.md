#### 2022-11-15

##### Documentation Changes

* **README:**
  *  기능 목록 추가 작성 (4cc77fc5)
  *  기능 목록 추가 작성 (e3ef70e3)
  *  기능 목록 작성 (901c8d93)
  *  기능 목록 작성 (aba5dea0)
  *  기능 목록 작성 (a9b32c7f)
  *  기능 목록 작성 (0e0d0311)
* **CHANGELOG:**  create CHANGELOG.md file (3357c09c)

##### New Features

* **Rank:**  리스트 출력하는 기능 구현 (fe82803e)
* **RankMoney:**  순위 별 상금 모음 구현 (68b7e8ee)
* **LottoProgram:**
  *  예외처리 추가 (3a074f9a)
  *   당첨 통계를 보여주는 기능 구현 (f9e7d09f)
  *   당첨 로또를 입력 받는 기능 구현 (8766dcde)
  *   로또를 구매하는 기능 구현 (b79462c7)
* **ExceptionHandler:**  입력값이 없을 때 예외처리 구현 (9a810137)
* **Referee:**
  *  반환되는 문장 수정 (ff400aba)
  *  당첨번호와 로또번호를 비교하는 기능 구현 (043ae6f6)
* **WinLotto:**
  *  당첨 등수를 입력받을 때 예외처리 구현 (62fd2cbd)
  *  당첨 클래스 구현 (2ebf7ea9)
  *  당첨 클래스 구현 (a960ac12)
* **InputOutput:**
  *  당첨 기록 출력하는 기능 수정 (5e465ed2)
  *  로또 구입 갯수를 출력하는 기능 구현 (2d495bcd)
  *  예외처리 추가 (0d62f1fc)
  *  수익률을 출력하는 기능 구현 (5654b574)
  *  당첨 내역을 출력하는 기능 구현 (c9029f78)
  *  당첨 내역을 출력하는 기능 구현 (379e96c6)
  *  로또 보너스 번호를 입력 받는 기능 구현 (4b7609db)
  *  로또 당첨 번호를 입력 받는 기능 구현 (1c736856)
  *  로또 금액을 입력 받는 기능 구현 (187ead31)
* **Calculate:**
  *  수익률 계산하는 기능 수정 (e28644ea)
  *  수익률을 계산하는 기능 구현 (372a4a5c)
  *  수익률을 계산하는 기능 구현 (d2312ad9)
* **Lotto:**  로또 클래스 구현 (101a02fc)
* **LottoWin:**  당첨 클래스 구현 (64a5b749)
* **InformationLines:**  안내 문구 모아둔 기능 구현 (f7b03979)
* **NumberGenerator:**
  *  예외처리 추가 (aaad54ad)
  *  오름차순으로 정렬하는 기능 구현 (a3f116af)
  *  1부터 45까지의 서로 다른 수 6개를 생성하는 기능 구현 (81f61fa4)
* **Exception:**
  *   로또 보너스 번호를 입력 받을 때 예외처리 구현 (0474b10e)
  *   로또 당첨 번호를 입력 받을 때 예외처리 구현 (a8f72ba1)
  *   로또 번호를 생성할 때 예외처리 구현 (174371ba)
  *   로또 구입 금액을 입력 받을 때 예외처리 구현 (81619e35)
  *  1부터 45까지의 범위가 아닌 경우 예외처리 구현 (aa6dc7a2)
  *  콤마 사이의 글자가 숫자가 아닌 경우 예외처리 구현 (8b3fa2e2)
  *  서로 다른 수가 아닐 때 예외처리 구현 (5a7ecec6)
  *  로또 번호가 6개가 아닐 경우 예외처리 구현 (d719d83a)
  *  로또 구매 금액이 1000원이 아닐 경우 예외처리 구현 (66cdb5b7)
  *  입력값이 숫자가 아닐 경우 예외처리 구현 (f7682ad2)
* **Judgement:**
  *  보너스 숫자가 포함됐는지 알 수 있는 기능 구현 (093e6c56)
  *  몇 개의 수가 같은지 알 수 있는 기능 구현 (e52c3dd0)
* **LottoResult:**  로또 결과를 모아둔 파일 생성 (72af402d)
*  setup precourse lotto project (8e048b15)

##### Bug Fixes

* **NumberGenerator:**  리스트 초기화 관련 에러 해결 (ef4f8b91)

##### Refactors

* **WinLotto:**
  *  Rank의 getRankList를 이용해 코드 리팩토링 (c7b2efc9)
  *  if문 enum으로 구현 (d8fcf33a)
  *  LottoWin에서 WinLotto로 이름 변경 (f8c01203)
* **LottoProgram:**  오타 수정 (d35f6b33)
* **InputOutput:**  문장 추가 (45bc1833)
* **InformationLines:**  문장 수정 (004a681e)
* **Calcualte:**  타입 변경 (101fea81)
* **LottoWin:**  타입 변경 (b16f9141)
* **Referee:**  오타 수정 (a0ffb0b6)
*  refactor code style (53fa5ce6)
* **Lotto:**
  *  패키지 변경 (baf6105f)
  *  패키지 변경 (33f62ffb)

##### Tests

* **RefereeTest:**  compare() 기능 테스트 (93070177)
* **JudgementTest:**  sameNumberCount(), containBonusNumber() 기능 테스트 (15f115ff)
* **CalculateTest:**  calculateRateOfProfit() 기능 테스트 (a8eb3d77)
* **NumberGeneratorTest:**  createRandomNumbers(), sortAscendingOrder() 기능 테스트 (5ddfe19f)
* **ExceptionHandlerTest:**  예외처리 테스트 (e7e410dc)

#### 2022-11-15

##### Documentation Changes

* **README:**
  *  기능 목록 작성 (901c8d93)
  *  기능 목록 작성 (aba5dea0)
  *  기능 목록 작성 (a9b32c7f)
  *  기능 목록 작성 (0e0d0311)
* **CHANGELOG:**  create CHANGELOG.md file (3357c09c)

##### New Features

* **InputOutput:**
  *  당첨 내역을 출력하는 기능 구현 (379e96c6)
  *  로또 보너스 번호를 입력 받는 기능 구현 (4b7609db)
  *  로또 당첨 번호를 입력 받는 기능 구현 (1c736856)
  *  로또 금액을 입력 받는 기능 구현 (187ead31)
* **Referee:**  당첨번호와 로또번호를 비교하는 기능 구현 (043ae6f6)
* **Judgement:**
  *  보너스 숫자가 포함됐는지 알 수 있는 기능 구현 (093e6c56)
  *  몇 개의 수가 같은지 알 수 있는 기능 구현 (e52c3dd0)
* **LottoResult:**  로또 결과를 모아둔 파일 생성 (72af402d)
* **NumberGenerator:**
  *  오름차순으로 정렬하는 기능 구현 (a3f116af)
  *  1부터 45까지의 서로 다른 수 6개를 생성하는 기능 구현 (81f61fa4)
*  setup precourse lotto project (8e048b15)

##### Refactors

*  code style (50f4878b)
* **Lotto:**
  *  패키지 변경 (baf6105f)
  *  패키지 변경 (33f62ffb)

#### 2022-11-15

##### Documentation Changes

* **README:**
  *  기능 목록 작성 (901c8d93)
  *  기능 목록 작성 (aba5dea0)
  *  기능 목록 작성 (a9b32c7f)
  *  기능 목록 작성 (0e0d0311)
* **CHANGELOG:**  create CHANGELOG.md file (3357c09c)

##### New Features

* **InputOutput:**  로또 금액을 입력 받는 기능 구현 (187ead31)
*  setup precourse lotto project (8e048b15)

##### Refactors

* **Lotto:**  패키지 변경 (33f62ffb)

#### 2022-11-14

##### New Features

*  setup precourse lotto project (8e048b15)


####로또 프로젝트####
1. 사용자가 로또 번호와 받을 금액 단위를 입력하는 클래스 InputView를 생성한다.
* buyLottoTickets() 기능을 통해 받을 금액을 입력받고 이를 Integer로 변환한다.
* checkLottoTicket() 기능으로 들어온 금액의 단위가 잘 입력되었는지 체크한다.
* 사용자가 로또 번호를 입력하는 pressLottoNumber() 기능을 추가한다.
* 사용자가 입력한 로또 번호가 ,로 잘 구분되어있는지 확인한 후에 이를 Integer로 변환하는 checkStringToInt() 기능을 추가한다.
* 사용자가 로또 번호를 입력한 후에 pressBonusNumber() 기능을 통해 사용자가 로또 보너스 번호를 입력하게 한다.
* 들어온 로또 번호가 숫자인지 1~45사이에 있는지를 확인하는 checkBonusNumber() 기능을 추가한다.


2. 사용자가 입력한 로또 번호를 체크하는 클래스 Lotto에 기능을 추가한다.
* 기능 countOfMatch()를 통해 들어온 로또의 값을 비교한다.
* 들어온 로또 번호가 6자리인지, 중복되지는 않는지 validate()로 검증한다. 
* countOfBonus()를 통해 보너스번호가 있는지를 체크한다. 



3. 사용자가 입력한 금액에 따라 로또 번호를 랜덤으로 생성하는 클래스 LottoNumberCreator
* 들어온 금액에 따라 로또 티켓을 리스트에 추가하는 showHowManyTickets() 기능을 추가한다.
* generateLottoNumberContainer()를 통해 랜덤으로 6자리의 로또를 하나씩 생성한다. 
* 들어온 로또 번호를 ascnedingSortNumber() 기능을 통해 오름차순 정렬한다.


4. 사용자가 입력한 로또번호와 랜덤으로 생성된 로또번호를 비교해 결과를 보여주는 클래스 Controller
* compareResut()를 통해 일치되는 카운트수와 보너스번호가 포함되는지에 대한 결과값을 담아준다.
* 일치하는 로또 번호의 개수와 총 수익률을 출력하는 showLottoWinningResult()
* findResult()를 통해 일치하는 값의 value값과 key값을 찾는다.
* 총수익률을 구하는 기능 calculateProfitRate()

5. InputView, Controller, Lotto, LottoNumber 클래스를 연결하여 Application 클래스를 구현한다. 


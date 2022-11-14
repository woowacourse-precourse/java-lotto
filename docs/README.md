## Application.java

* **main()**
    * call simulateLotto from simulation.Simulation.java

## simulation.Simulation.java

* **simulateLotto()**
    * simulate whole processes
* **buyLotto()**
    * simulate related to buying lotto
* **getWinNumber()**
    * simulate related to getting win number
* **getBonus()**
    * simulate related to getting bonus number
* **getResult()**
    * simulate related to get results

## function.Function.java

* **generateLotto()**
    * generate array with 6 values using pickUniqueNumbersInRange()
* **getMoney()**
    * get inputs for lottery purchase amount
    * generate Lotto instances for the amount
* **purchaseLotto()**
    * create proper number of Lotto instances
* **isInteger()**
    * check whether inputs are format of integers
* **validPrice()**
    * check inputs are valid
* **getWinningNumber()**
    * get inputs for winning numbers
* **changeTypeofWinningNumber()**
    * change type of WinningNumber from string to list
* **validWinningNumberInput()**
    * check inputs are able to change into integer
* **isInRange()**
    * check whether inputs are in valid range
* **validWinningNumberCount()**
    * check inputs have 6 numbers
* **validWinningNumberRange()**
    * check inputs are valid for winning number
* **getBonus()**
    * get inputs for bonus number
* **validBonus()**
    * check inputs are valid for bonus number
* **countMatching()**
    * count how many numbers are matched between lotto and WinningNumbers
* **winLotto()**
    * get results for all Lotto instances
* **calculateWinning()**
    * calculate winning prices from results
* **calculateYield()**
    * calculate yields from price and winning

## display.Display.java

* **displayResult()**
    * display results
* **displayYield()**
    * display yield
* **displayLotto**
    * display purchased lotto
* **displayStart()**
    * display start condition
* **displayGettingWinNumber()**
    * display situation getting winning number
* **displayGettingBonus()**
    * display situation getting bonus number
* **displayError()**
    * display error message

## function.Lotto.java

* **Lotto class**
    * class for one lotto purchasing
* **getNumbers()**
    * print Lotto instance's value
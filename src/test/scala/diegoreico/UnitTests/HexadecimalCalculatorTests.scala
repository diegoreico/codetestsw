package diegoreico.UnitTests

import diegoreico.HexadecimalCalculator
import org.scalatest.WordSpec

class HexadecimalCalculatorTests extends WordSpec{

  val calculator = new HexadecimalCalculator()

  "HexadecimalCalculator" should {

    "sum all hexadecimal char values in a string" in {
      val string = "6f9c15fa"

      val result = calculator.sumEachCharValue(string)
      val expected = 73

      assert(result == expected)

    }

  }
}

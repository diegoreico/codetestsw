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

    "obtain the biggest value inside a string formed by hexadecimal characters" in {
      val string = "ef51"

      val result = calculator.obtainMaxDecimalValueInsideHexString(string)
      val expected = 15

      assert(result == expected)

    }

    "obtain the sum of values for the max decimal value between 2 characters at the same position inside 2 strings " +
      "containung hexadecimal characters"in {
      val string = "400c"
      val string2 = "a676"

      val result = calculator.obtainSumOfMaxValuesAtEachPosition(string, string2)
      val expected = 35

      assert(result == expected)

    }

  }
}

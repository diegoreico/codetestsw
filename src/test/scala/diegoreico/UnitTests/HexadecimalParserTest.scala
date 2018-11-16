package diegoreico.UnitTests

import diegoreico.Decrypt.HexadecimalParser
import org.scalatest.WordSpec

class HexadecimalParserTest extends  WordSpec{

  "HexadecimalParser" should {
    "Correctly obtain character hexadecimal value for a number" in {
      val char = '3'

      val value = HexadecimalParser.parseChar(char)

      val expected = 3
      assert(value == expected)
    }

    "Correctly obtain character hexadecimal value for a lower case letter" in {
      val char = 'c'

      val value = HexadecimalParser.parseChar(char)

      val expected = 12
      assert(value == expected)
    }

    "Correctly obtain character hexadecimal value for a upper case letter" in {
      val char = 'F'

      val value = HexadecimalParser.parseChar(char)

      val expected = 15
      assert(value == expected)
    }
  }

}

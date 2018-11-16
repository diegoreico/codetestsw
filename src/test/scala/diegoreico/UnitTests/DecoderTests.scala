package diegoreico.UnitTests

import diegoreico.Decrypt.{Decoder, EncryptedCoordinates}
import org.scalatest.WordSpec

class DecoderTests extends WordSpec{

  "Decoder" should {

    "sum all hexadecimal char values in a string" in {
      val string = "6f9c15fa"

      val result = Decoder.sumEachCharValue(string)
      val expected = 73

      assert(result == expected)

    }

    "obtain the biggest value inside a string formed by hexadecimal characters" in {
      val string = "ef51"

      val result = Decoder.obtainMaxDecimalValueInsideHexString(string)
      val expected = 15

      assert(result == expected)

    }

    "obtain the sum of values for the max decimal value between 2 characters at the same position inside 2 strings " +
      "containung hexadecimal characters"in {
      val string = "400c"
      val string2 = "a676"

      val result = Decoder.obtainSumOfMaxValuesAtEachPosition(string, string2)
      val expected = 35

      assert(result == expected)

    }

    "order chars inside string using descending order and remove duplicated chars inside it" in {
      val string = "448dc6e30b08"

      val result = Decoder.orderAndRemoveDuplicated(string)
      val expected = "edcb86430"

      assert(result === expected)
    }

    "Correctly decode encrypted coordinates" in {

      val encryptedCoordinate =
        EncryptedCoordinates("2ab81c9b-1719-400c-a676-bdba976150eb")

      val result = Decoder.decode(encryptedCoordinate)

      val expectedCoordinates = "64-9-35-edba976510"

      assert(result === expectedCoordinates, "An encrypted coordinated wasn't decoded right")

    }


  }
}

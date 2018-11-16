package diegoreico.UnitTests

import org.scalatest._

import diegoreico.{Decoder, EncryptedCoordinates}

class DecoderTests extends WordSpec {

  val decoder = new Decoder()

  "The Decoder" should {

    "Correctly decode encrypted coordinates" in {

      val encryptedCoordinate =
        EncryptedCoordinates("2952410b-0a94-446b-8bcb-448dc6e30b08")

      val result = decoder.decode(encryptedCoordinate)

      val expectedCoordinates = "22-10-42-edcb86430"

      assert(result === expectedCoordinates, "An encrypted coordinated wasn't decoded right")

    }

  }

}

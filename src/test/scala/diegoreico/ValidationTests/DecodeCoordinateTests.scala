package diegoreico.ValidationTests

import diegoreico.{Decoder, EncryptedCoordinates}
import org.scalatest._

class DecodeCoordinateTests extends WordSpec {

  val decoder = new Decoder()

  "The Decoder" should {

    "Correctly decode encrypted coordinates" in {

      val encryptedCoordinates = Array(
        EncryptedCoordinates("2952410b-0a94-446b-8bcb-448dc6e30b08"),
        EncryptedCoordinates("2952410b-0a94-446b-8bcb-448dc6e30b08"),
        EncryptedCoordinates("2952410b-0a94-446b-8bcb-448dc6e30b08"))

      val results = encryptedCoordinates.map(decoder.decode)

      val expectedCoordinates = Array(
        "22-10-42-edcb86430",
        "73-15-46-dc9876321",
        "64-9-35-edba976510")

      assert(results sameElements expectedCoordinates, "An encrypted coordinated wasn't decoded right")

    }

  }

}

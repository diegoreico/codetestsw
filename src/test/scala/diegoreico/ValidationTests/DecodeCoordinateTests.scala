package diegoreico.ValidationTests

import diegoreico.{Decoder, EncryptedCoordinates}
import org.scalatest._

class DecodeCoordinateTests extends WordSpec {


  "The Decoder" should {

    "Correctly decode encrypted coordinates" in {

      val encryptedCoordinates = Array(
        EncryptedCoordinates("6f9c15fa-ef51-4415-afab-36218d76c2d9"),
        EncryptedCoordinates("2ab81c9b-1719-400c-a676-bdba976150eb"))

      val results = encryptedCoordinates.map(Decoder.decode)

      val expectedCoordinates = Array(
        "73-15-46-dc9876321",
        "64-9-35-edba976510")

      assert(results sameElements expectedCoordinates, "An encrypted coordinated wasn't decoded right")

    }

  }

}

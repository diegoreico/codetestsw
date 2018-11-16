package diegoreico.UnitTests

import diegoreico.Decrypt.EncryptedCoordinates
import diegoreico.Exceptions.BadFormatException
import org.scalatest.WordSpec

class EncryptedCoordinatesTests extends WordSpec {

  "The EncryptedCoordinates" should {
    "be correctly created from a string" in {
      val coordinatesString = "2952410b-0a94-446b-8bcb-448dc6e30b08"
      val encryptedCoordinates = EncryptedCoordinates(coordinatesString)

      assert(encryptedCoordinates.galaxy == "2952410b")
      assert(encryptedCoordinates.quadrant == "0a94")
      assert(encryptedCoordinates.starsystem1 == "446b")
      assert(encryptedCoordinates.starsystem2 == "8bcb")
      assert(encryptedCoordinates.planet == "448dc6e30b08")
    }

    "raises an exception if a coordinate string with wrong size is provided" in {
      val coordinatesString = "2952410baaaaaaa-0a94-446b-8bcb"
      assertThrows[BadFormatException]{
        EncryptedCoordinates(coordinatesString)
      }
    }

    "raises an exception if a coordinate string with segments of the wrong size is provided" in {
      val coordinatesString = "2952410baaaaaaaaaaaaaaa-0a94-446b-8bcb-448dc6e30b08"
      assertThrows[BadFormatException]{
        EncryptedCoordinates(coordinatesString)
      }
    }
  }
}

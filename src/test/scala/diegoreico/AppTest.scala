package diegoreico

import collection.mutable.Stack
import org.scalatest._

class AppTest extends FlatSpec with Matchers {

    "A test" should "be able to perform an assert" in {
        assert(1 + 1 == 2,"Something went wrong on the test library")
    }

}


package unit.model

import co.omise.model.Error
import org.junit.Assert.assertEquals
import org.junit.Test

class ErrorTest {
  @Test
  def testToString() {
    val error = new Error(
      `object` = "error",
      location = "location",
      code = "errorCode",
      message = "errorMessage"
    )

    assertEquals("Error(error,location,errorCode,errorMessage)", error.toString)
  }
}

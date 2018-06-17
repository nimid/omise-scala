package unit.exception

import co.omise.exception.OmiseException
import co.omise.model.Error
import org.junit.Assert.assertEquals
import org.junit.Test

class OmiseExceptionTest {
  @Test
  def testToString() {
    val error = Error(
      `object` = "error",
      location = "location",
      code = "errorCode",
      message = "errorMessage"
    )
    val omiseException = new OmiseException(error)

    assertEquals(
      "OmiseException(error=Error(error,location,errorCode,errorMessage))",
      omiseException.toString
    )
  }
}

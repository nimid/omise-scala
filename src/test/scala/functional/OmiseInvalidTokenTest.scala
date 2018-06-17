package functional

import java.util

import co.omise.exception.OmiseException
import co.omise.OmiseToken
import org.junit.Assert.{assertEquals, fail}
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.junit.Test

@RunWith(classOf[Parameterized])
class OmiseInvalidTokenTest(publicKey: String) {
  @Test
  def testOmiseToken_publicKeyIsInvalid_errorAuthenticationFailure(): Unit = {
    OmiseToken.publicKey = ""

    try {
      OmiseToken.create(SampleRequest.token)
      fail("Expected the error, if public key is invalid")
    } catch {
      case exception: OmiseException =>
        assertEquals(SampleResponse.Error.AuthenticationFailure.toString, exception.toString)
    }
  }
}

object OmiseInvalidTokenTest {
  @Parameters
  def parameters: util.ArrayList[String] = {
    val publicKeys = new util.ArrayList[String]

    publicKeys.add("0")
    publicKeys.add("invalid_key")
    publicKeys.add("")
    publicKeys.add(" ")
    publicKeys.add(null)

    publicKeys
  }
}
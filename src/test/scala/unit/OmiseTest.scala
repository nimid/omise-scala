package unit

import co.omise.Omise
import org.junit.Assert.assertEquals
import org.junit.Test

class OmiseTest {
  @Test
  def testOmise_defaultValue_emptyString() {
    val omise = new Omise

    assertEquals("", omise.publicKey)
    assertEquals("", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithOneParameter_onlyPublicKeyHasBeenDefined() {
    val omise = new Omise("pkey")

    assertEquals("pkey", omise.publicKey)
    assertEquals("", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithTwoParameters_publicKeyAndSecretKeyHaveBeenDefined() {
    val omise = new Omise("pkey", "skey")

    assertEquals("pkey", omise.publicKey)
    assertEquals("skey", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithNamedParameterSecretKey_onlySecretKeyHasBeenDefined() {
    val omise = new Omise(_secretKey = "skey")

    assertEquals("", omise.publicKey)
    assertEquals("skey", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithNamedParameterPublicKey_onlyPublicKeyHasBeenDefined() {
    val omise = new Omise(_publicKey = "pkey")

    assertEquals("pkey", omise.publicKey)
    assertEquals("", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithNamedParameterPublicKeyAndSecretKey_publicKeyAndSecretKeyHaveBeenDefined() {
    val omise = new Omise(_publicKey = "pkey", _secretKey = "skey")

    assertEquals("pkey", omise.publicKey)
    assertEquals("skey", omise.secretKey)
  }

  @Test
  def testOmise_createInstanceWithNamedParameterSecretKeyAndPublicKey_publicKeyAndSecretKeyHaveBeenDefined() {
    val omise = new Omise(_secretKey = "skey", _publicKey = "pkey")

    assertEquals("pkey", omise.publicKey)
    assertEquals("skey", omise.secretKey)
  }

  @Test
  def testOmise_definePublicKeyAndSecretKeyAfterCreatedInstance_publicKeyAndSecretKeyCanBeDefined() {
    val omise = new Omise

    omise.publicKey = "pkey"
    omise.secretKey = "skey"

    assertEquals("pkey", omise.publicKey)
    assertEquals("skey", omise.secretKey)
  }
}

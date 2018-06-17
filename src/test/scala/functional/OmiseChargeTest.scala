package functional

import java.util

import co.omise.exception.OmiseException
import co.omise.{Omise, OmiseCharge, OmiseToken}
import org.junit.Assert.{assertEquals, assertFalse, assertNotNull, assertNull, assertTrue, fail}
import org.junit.{Before, Test}
import integration.Assert.assertCharge

class OmiseChargeTest {
  private var omise: Omise = _

  @Before
  def setUp() {
    omise = new Omise(Config.PublicKey, Config.SecretKey)
  }

  @Test
  def testOmiseCharge_createCharge_success() {
    val token = omise.token.create(SampleRequest.token)

    val charge = omise.charge.create(SampleRequest.charge(token.id))

    assertCharge(charge)
  }

  @Test
  def testOmiseCharge_cardTokenIsInvalid_errorOfTokenNotFound() {
    val chargeRequest = SampleRequest.charge(omise.token.create(SampleRequest.token).id)
    chargeRequest.card = "invalidToken"

    try {
      omise.charge.create(chargeRequest)
      fail("Expected that charge is failed, if card token is invalid")
    } catch {
      case exception: OmiseException =>
        assertEquals(SampleResponse.Error.TokenNotFound("invalidToken").toString, exception.toString)
    }
  }

  @Test
  def testOmiseCharge_securityCodeIsEmpty() {
    val token = omise.token.create(
      cardName = "Saroj",
      cardNumber = "4242424242424242",
      cardExpirationMonth = 12,
      cardExpirationYear = 2020,
      cardSecurityCode = null
    )

    val charge = omise.charge.create(
      amount = 10000,
      currency = "thb",
      card = Some(token.id)
    )

    assertEquals("successful", charge.status)
    assertTrue(charge.authorized)
    assertFalse(charge.reversed)
    assertFalse(charge.reversible)
    assertTrue(charge.paid)
    assertNotNull(charge.transaction)
    assertNull(charge.failureCode)
    assertNull(charge.failureMessage)
  }

  @Test
  def testOmiseCharge_createChargeWithHashMap() {
    val token = omise.token.create(SampleRequest.token)
    val chargeParameters = new util.HashMap[String, Any]

    chargeParameters.put("amount", 10000)
    chargeParameters.put("currency", "thb")
    chargeParameters.put("card", token.id)

    omise.charge.create(chargeParameters)
  }

  @Test
  def testOmiseCharge_retrieveAChargeByChargeId_chargeObject() {
    val token = omise.token.create(SampleRequest.token)
    val charge = omise.charge.create(SampleRequest.charge(token.id))

    val retrievedCharge = omise.charge.retrieve(charge.id)

    assertEquals(retrievedCharge.id, charge.id)
  }

  @Test
  def testOmiseChargeStatic_createCharge_success() {
    OmiseToken.publicKey = Config.PublicKey
    OmiseCharge.secretKey = Config.SecretKey

    val token = OmiseToken.create(
      cardExpirationMonth = 10,
      cardNumber = "4242424242424242",
      cardExpirationYear = 2018,
      cardName = "Somchai Prasert",
      cardSecurityCode = "123"
    )

    val charge = OmiseCharge.create(
      amount = 100000,
      currency = "thb",
      card = Some(token.id)
    )

    assertCharge(charge)
  }
}

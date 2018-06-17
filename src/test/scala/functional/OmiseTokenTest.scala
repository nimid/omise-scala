package functional

import java.util

import co.omise.{Omise, OmiseToken}
import integration.Assert.assertToken
import org.junit.Assert.assertEquals
import org.junit.{Before, Test}

class OmiseTokenTest {
  private var omise: Omise = _

  @Before
  def setUp() {
    omise = new Omise(Config.PublicKey)
  }

  @Test
  def testOmiseToken_createToken_validToken() {
    val omise = new Omise(Config.PublicKey)

    val token = omise.token.create(SampleRequest.token)

    assertToken(token)
  }

  @Test
  def testOmiseTokenStatic_createToken_validToken() {
    OmiseToken.publicKey = Config.PublicKey

    val token = OmiseToken.create(SampleRequest.token)

    assertToken(token)
  }

  @Test
  def testOmiseTokenStatic_namedParameter_validToken() {
    OmiseToken.publicKey = Config.PublicKey

    val token = OmiseToken.create(
      cardExpirationMonth = 10,
      cardNumber = "4242424242424242",
      cardExpirationYear = 2018,
      cardName = "Somchai Prasert",
      cardSecurityCode = "123"
    )

    assertToken(token)
  }

  @Test
  def testOmiseToken_createTokenWithHashMap_validToken() {
    val card = new util.HashMap[String, Any]
    card.put("name", "Somchai Prasert")
    card.put("number", "4242424242424242")
    card.put("expirationMonth", 10)
    card.put("expirationYear", 2018)
    card.put("securityCode", "123")
    card.put("city", "Bangkok")
    card.put("postalCode", "10230")

    val token = omise.token.create(card)

    assertToken(token)
    assertEquals("Somchai Prasert", token.card.name)
    assertEquals("4242", token.card.lastDigits)
    assertEquals(10, token.card.expirationMonth)
    assertEquals(2018, token.card.expirationYear)
    assertEquals("Bangkok", token.card.city)
    assertEquals("10230", token.card.postalCode)
  }

  @Test
  def testOmiseTokenStatic_createTokenWithHashMap_validToken() {
    OmiseToken.publicKey = Config.PublicKey
    val card = new util.HashMap[String, Any]
    card.put("name", "Somchai Prasert")
    card.put("number", "4242424242424242")
    card.put("expirationMonth", 10)
    card.put("expirationYear", 2018)
    card.put("securityCode", "123")
    card.put("city", "Bangkok")
    card.put("postalCode", "10230")

    val token = OmiseToken.create(card)

    assertToken(token)
    assertEquals("Somchai Prasert", token.card.name)
    assertEquals("4242", token.card.lastDigits)
    assertEquals(10, token.card.expirationMonth)
    assertEquals(2018, token.card.expirationYear)
    assertEquals("Bangkok", token.card.city)
    assertEquals("10230", token.card.postalCode)
  }

  @Test
  def testOmiseToken_retrieveToken_validToken() {
    val token = omise.token.create(SampleRequest.token)

    val retrivedToken = omise.token.retrieve(token.id)

    assertEquals(retrivedToken, token)
  }
}

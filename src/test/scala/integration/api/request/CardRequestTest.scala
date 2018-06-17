package integration.api.request

import co.omise.api.request.CardRequest
import co.omise.json.Json
import org.junit.Assert.assertEquals
import org.junit.{Before, Test}

class CardRequestTest {
  private var cardRequest: CardRequest = _
  private val json: Json = new Json

  @Before
  def setUp() {
    cardRequest = new CardRequest
  }

  @Test
  def testGenerateJson() {
    cardRequest.city = "Bangkok"
    cardRequest.expirationMonth = 12
    cardRequest.expirationYear = 2023
    cardRequest.name = "Saroj"
    cardRequest.number = "4242424242424242"
    cardRequest.postalCode = "10230"
    cardRequest.securityCode = "123"

    val jsonString = json.generate(cardRequest)

    assertEquals(
      """
        {
          "city":"Bangkok",
          "expiration_month":12,
          "expiration_year":2023,
          "name":"Saroj",
          "number":"4242424242424242",
          "postal_code":"10230",
          "security_code":"123"
        }
      """.replaceAll("\\s", ""),
      jsonString
    )
  }

  @Test
  def testGenerateJson_defaultValue() {
    val jsonString = json.generate(cardRequest)

    assertEquals(
      """
        {
          "expiration_month":0,
          "expiration_year":0
        }
      """.replaceAll("\\s", ""),
      jsonString
    )
  }

  @Test
  def testGenerateJson_defineCardSecurityAsNull_cardSecurityIsNotPresented() {
    cardRequest.securityCode = null

    val jsonString = json.generate(cardRequest)

    assertEquals(
      """
        {
          "expiration_month":0,
          "expiration_year":0
        }
      """.replaceAll("\\s", ""),
      jsonString
    )
  }
}

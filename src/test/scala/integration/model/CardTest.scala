package integration.model

import co.omise.json.Json
import co.omise.model.Card
import integration.SampleJson
import org.junit.Assert.{assertEquals, assertFalse, assertNull, assertTrue}
import org.junit.Test

class CardTest {
  @Test
  def testParseJson() {
    val json = new Json

    val card = json.parse(SampleJson.card, classOf[Card])

    assertEquals("card", card.`object`)
    assertEquals("card_test_5c06y8lx3noy38id3h0", card.id)
    assertFalse(card.livemode)
    assertEquals("/customers/cust_test_5086xleuh9ft4bn0ac2/cards/card_test_5c06y8lx3noy38id3h0", card.location)
    assertEquals("us", card.country)
    assertNull(card.city)
    assertNull(card.postalCode)
    assertEquals("", card.financing)
    assertEquals("", card.bank)
    assertEquals("4242", card.lastDigits)
    assertEquals("Visa", card.brand)
    assertEquals(1, card.expirationMonth)
    assertEquals(2019, card.expirationYear)
    assertEquals("SPa4dOqeZ6dF580CG1siHGHKCs1JiQGYIgqO6hfZjU8=", card.fingerprint)
    assertEquals("Saroj", card.name)
    assertTrue(card.securityCodeCheck)
    assertEquals("2018-05-21T06:30:38Z", card.created)
  }
}

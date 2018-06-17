package integration

import co.omise.model.{Card, Charge, Token}
import org.junit.Assert.{assertEquals, assertNotNull, assertTrue}

object Assert {
  def assertCard(card: Card) {
    assertEquals("card", card.`object`)
    assertNotNull(card.id)
  }

  def assertCharge(charge: Charge) {
    assertEquals("charge", charge.`object`)
    assertChargeIdPrefix(charge.id)
    assertEquals("/charges/" + charge.id, charge.location)
  }

  def assertChargeIdPrefix(chargeId: String) {
    assertTrue(chargeId.substring(0, 5).equals("chrg_"))
  }

  def assertToken(token: Token) {
    assertEquals("token", token.`object`)
    assertTokenIdPrefix(token.id)
    assertCard(token.card)
  }

  def assertTokenIdPrefix(tokenId: String) {
    assertTrue(tokenId.substring(0, 5).equals("tokn_"))
  }
}

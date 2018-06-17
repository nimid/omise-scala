package co.omise.model

case class Card(
  `object`: String,
  id: String,
  livemode: Boolean,
  location: String,
  country: String,
  city: String,
  bank: String,
  postalCode: String,
  financing: String,
  lastDigits: String,
  brand: String,
  expirationMonth: Int,
  expirationYear: Int,
  fingerprint: String,
  name: String,
  securityCodeCheck: Boolean,
  created: String,
)

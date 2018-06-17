package co.omise.model

case class Token(
  `object`: String,
  id: String,
  livemode: Boolean,
  location: String,
  used: Boolean,
  card: Card,
  created: String,
)

package co.omise.model

case class Dispute (
  `object`: String,
  id: String,
  livemode: Boolean,
  location: String,
  amount: Int,
  currency: String,
  status: String,
  message: String,
  charge: String,
  created: String
)

package co.omise.model

case class Refund (
  `object`: String,
  id: String,
  location: String,
  amount: Int,
  currency: String,
  voided: Boolean,
  charge: String,
  transaction: String,
  created: String
)

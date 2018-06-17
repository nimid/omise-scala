package co.omise.model

case class Error(
  `object`: String,
  location: String,
  code: String,
  message: String
)

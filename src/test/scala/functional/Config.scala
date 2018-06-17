package functional

object Config {
  val PublicKey = sys.env("OMISE_PUBLIC_KEY")
  val SecretKey = sys.env("OMISE_SECRET_KEY")
}

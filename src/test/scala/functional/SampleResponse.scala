package functional

import co.omise.exception.OmiseException
import co.omise.model.Error

object SampleResponse {
  object Error {
    def AuthenticationFailure: OmiseException = {
      new OmiseException(
        new Error(
          `object` = "error",
          location = "https://www.omise.co/api-errors#authentication-failure",
          code = "authentication_failure",
          message = "authentication failed"
        )
      )
    }

    def TokenNotFound(token: String = ""): OmiseException = {
      new OmiseException(
        new Error(
          `object` = "error",
          location = "https://www.omise.co/api-errors#not-found",
          code = "not_found",
          message = s"token $token was not found"
        )
      )
    }
  }
}

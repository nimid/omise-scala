package co.omise.exception

import co.omise.model.Error

class OmiseException(val error: Error) extends Exception {
  override def toString = s"OmiseException(error=$error)"
}

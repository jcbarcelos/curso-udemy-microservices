import { BAD_REQUEST } from '../config/constants/index.js'
import { messageErrorNotFound, messageNotInformed } from '../helps/index.js'
import { ExceptionValidation } from './index.js'

class Validation {
  validationValueData(params) {
    if (!params) {
      throw new ExceptionValidation(
        BAD_REQUEST,
        `${params} ${messageNotInformed}`,
      )
    }
  }
  async validationNotFoundAuth(params) {
    if (!params) {
      throw new ExceptionValidation(
        BAD_REQUEST,
        `${params} ${messageErrorNotFound}`,
      )
    }
  }
  async validationNotFound(params) {
    if (!params) {
      throw new ExceptionValidation(
        BAD_REQUEST,
        `${params} ${messageErrorNotFound}`,
      )
    }
  }
}

export default new Validation()

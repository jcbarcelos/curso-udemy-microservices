import { response } from 'express'
import { BAD_REQUEST, FORBINDDEN } from '../config/constants/index.js'
import { ReturnErrorJson, messageErrorNotFound, messageNotInformed } from '../helps/index.js'
import { messageErrorAuthenticatedUser } from '../helps/messages.js'
import returnJsonError from '../helps/returnJsonError.js'
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
  async validationNotFound(user) {
    if (!user) {
      throw new ExceptionValidation(
        BAD_REQUEST,
        `${user} ${messageErrorNotFound}`,
      )
    }
  }
  async validationAuthenticatedUser(user, authUser) {
    console.log('validationAuthenticatedUser', {user: user.dataValues.id, authUser: authUser})
    if (user.dataValues.id !== authUser.id) {
      throw new ExceptionValidation(
        FORBINDDEN,
        `${messageErrorAuthenticatedUser}`,
      )
    }
  }
}

export default new Validation()

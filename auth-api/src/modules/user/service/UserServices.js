import {
  SUCCESS,
  UNAUTHORIZED,
  BAD_REQUEST,
} from '../../../config/constants/index.js'
import Validation from '../../../exceptions/Valitation.js'
import {
  messageAcessTokenNotUnauthorized,
  messagePasswordNotMatch,
  ReturnErrorJson,
} from '../../../helps/index.js'
import UserRepository from '../repository/UserRepository.js'
import bcrypt from 'bcrypt'
import jwt from 'jsonwebtoken'

class UserService {
  async findByEmail(request) {
    try {
      const { email } = request.params
      Validation.validationValueData(email)
      let user = await UserRepository.findByEmail(email)
      Validation.validationNotFound(email)
      return {
        status: SUCCESS,
        user: {
          id: user.id,
          name: user.name,
          email: user.email,
        },
      }
    } catch (error) {
      return ReturnErrorJson.ErroJson(error)
    }
  }

  async getAccessToken(request, response) {
    try {
      const { email, password } = request.body
      this.validationAccessToken(email, password)
      let user = await UserRepository.findByEmail(email)
      Validation.validationNotFound(user)
      await this.validationPassword(password, user.password)
      let authUser = {
        id: user.id,
        name: user.name,
        email: user.email,
      }
      // const accessToken = jwt.sign({authUser}, ,{exirenIn: 'id'})
    } catch (error) {
      ReturnErrorJson.ErroJson(error)
    }
  }

  validationAccessToken(email, password) {
    if (!email || !password) {
      throw new ExceptionValidation(
        UNAUTHORIZED,
        `${messageAcessTokenNotUnauthorized}`,
      )
    }
  }
  async validationPassword(password, hasPassword) {
    if (!(await bcrypt.compare(password, hasPassword))) {
      throw new ExceptionValidation(UNAUTHORIZED, `${messagePasswordNotMatch}`)
    }
  }
}

export default new UserService()

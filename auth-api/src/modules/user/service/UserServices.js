import { API_SECRET } from '../../../config/auth/api_secrets.js'
import {
  FORBINDDEN,
  SUCCESS,
  UNAUTHORIZED,
} from '../../../config/constants/index.js'
import { ExceptionValidation, Validation } from '../../../exceptions/index.js'
import {
  messageAcessTokenNotUnauthorized,
  messagePasswordNotMatch,
  ReturnErrorJson,
} from '../../../helps/index.js'
import UserRepository from '../repository/UserRepository.js'
import bcrypt from 'bcrypt'
import jwt from 'jsonwebtoken'
import { messageErrorAuthenticatedUser } from '../../../helps/messages.js'



class UserService {
  async findByEmail(request) {
    try {
      const { email } = request.params
      const { authUser } = request
      Validation.validationValueData(email)
      let user = await UserRepository.findByEmail(email)
      await this.validationAuthenticatedUser(user, authUser)
    
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
  async validationAuthenticatedUser(user, authUser) {
    
    if (user.dataValues.id !== authUser?.id) {
      throw new ExceptionValidation(
        FORBINDDEN,
        `${messageErrorAuthenticatedUser}`,
      )
    }
  }
  async getAccessToken(request, response) {
    try {
      const { email, password } = request.body
 
      await this.validationAccessToken(email, password)
      let user = await UserRepository.findByEmail(email)
      await Validation.validationNotFoundAuth(user.email)
      await this.validationPassword(password, user.password)
     
      const accessToken = jwt.sign({ authUser }, API_SECRET, {
        expiresIn: '1d',
      })

      return {
        status: SUCCESS,
        accessToken: accessToken,
      }
    } catch (error) {
      return ReturnErrorJson.ErroJson(error)
    }
  }

  async validationAccessToken(email, password) {
    if (!email || !password || email === undefined) {
      throw new ExceptionValidation(
        UNAUTHORIZED,
        `email or password ${messageAcessTokenNotUnauthorized}`,
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

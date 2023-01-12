import jwt from 'jsonwebtoken'
import { promisify } from 'util'
import { API_SECRET } from './api_secrets.js'
import { AuthValidation, Validation } from '../../exceptions/index.js'
import { ReturnErrorJson } from '../../helps/index.js'
import { BEARER } from '../constants/HttpStatus.js'

export default async (request, response, next) => {
  try {
    const { authorization } = request.headers
    console.log('authorization: ', authorization);
    if (!authorization) {
      throw new AuthValidation(UNAUTHORIZED, `${messageErrorAuthAuthorization}`)
    }
    let accessToken = await authorization
    ;(await accessToken.toLowerCase().includes(BEARER))
      ? (accessToken = accessToken.replace(BEARER, ''))
      : 'null'
    const decodedAccessToken = await promisify(jwt.verify)(
      accessToken,
      API_SECRET,
    )
    request.authUser = decodedAccessToken.authUser
    return next()
  } catch (error) {
    return ReturnErrorJson.ErroJson(error)
  }
}

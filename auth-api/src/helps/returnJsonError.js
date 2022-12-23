import { response } from 'express'
import { INTERNAL_SERVER_ERROR } from '../config/constants/index.js'

class ReturnJsonError {
  async ErroJson(error) {
    console.log(error)
    return {
      status: error?.status ? error?.status : INTERNAL_SERVER_ERROR,
      message: error?.message,
    }
  }
}
export default new ReturnJsonError()

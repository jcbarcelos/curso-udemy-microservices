import { response } from "express"
import { INTERNAL_SERVER_ERROR } from "../config/constants/index.js"

class ReturnJsonError {
  async ErroJson(error) {
    return  response.status(error.status).json({
      status: error.status ? error.status : INTERNAL_SERVER_ERROR,
      message: error.message,
    })
  }
}
export default new ReturnJsonError()
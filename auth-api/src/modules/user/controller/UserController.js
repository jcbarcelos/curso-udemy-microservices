import UserServices from '../service/UserServices.js'

class UserController {
  async getAccessToken(request, response) {
    let accessToken = await UserServices.getAccessToken(request, response)

    return response.status(accessToken?.status).json(accessToken)
  }

  async findByEmail(request, response) {
    let user = await UserServices.findByEmail(request)
    return response.status(user?.status).json(user)
  }
}

export default new UserController()

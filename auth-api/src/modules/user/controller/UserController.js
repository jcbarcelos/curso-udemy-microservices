import UserServices from '../service/UserServices.js'

class UserController {
  async getAccessToken(request, response) {}

  async findByEmail(request, response) {
    let user = await UserServices.findByEmail(request)
    return response.status(user?.status).json(user)
  }
}

export default new UserController()

import { messageErrorNotFound } from '../../../helps/messages.js'
import User from '../model/UserModel.js'

class UserRepository {
  async findById(id) {
    try {
      return await User.findById({ where: { id } })
    } catch (error) {
      return {
        message: `${id} ${messageErrorNotFound}`,
      }
    }
  }
  async findByEmail(email) {
    try {
      return await User.findOne({ where: { email } })
    } catch (error) {
      return {
        message: `${email} ${messageErrorNotFound}`,
      }
    }
  }
}
export default new UserRepository()

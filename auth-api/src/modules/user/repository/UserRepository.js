import { messageErrorNotFound } from '../../../helps/messages.js'
import User from '../model/UserModel.js'
import express from 'express';

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
      const user = await User.findOne({ where: { email } })
      const authUser = {
        id: user.id,
        name: user.name,
        email: user.email,
      }

      let request = express.request;
      request.authUser = authUser
      return user
    } catch (error) {
      return {
        message: `${email} ${messageErrorNotFound}`,
      }
    }
  }
}
export default new UserRepository()

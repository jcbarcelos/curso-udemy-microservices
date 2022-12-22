import User from '../../modules/user/model/UserModel.js'
import bcrypt from 'bcrypt'

export async function createInitalData() {
  try {
    User.sync({ force: true })
    let password = await bcrypt.hash('123456', 10)
    await User.create({
      name: 'user_test',
      email: 'test@example.com',
      password: password,
    })
  } catch (error) {
    console.error(error)
  }
}

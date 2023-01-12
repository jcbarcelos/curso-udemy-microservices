import { Router } from 'express'
import UserController from '../controller/UserController.js'
import { CheckToken } from '../../../config/auth/index.js'
const userRoutes = new Router()
userRoutes.get(CheckToken);
userRoutes.get('/api/user/email/:email', (req, res) => {
  return UserController.findByEmail(req, res)
})

export default userRoutes

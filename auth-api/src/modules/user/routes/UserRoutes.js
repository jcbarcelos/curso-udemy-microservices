import { Router } from 'express'
import UserController from '../controller/UserController.js'
const userRoutes = new Router()
userRoutes.get('/api/user/email/:email', (req, res) => {
  return UserController.findByEmail(req, res)
})

export default userRoutes

import { Router } from 'express'
import UserController from '../controller/UserController.js'

const authRoutes = new Router()

authRoutes.post('/api/user/auth', (req, res) => {
  return UserController.getAccessToken(req, res)
})
export default authRoutes

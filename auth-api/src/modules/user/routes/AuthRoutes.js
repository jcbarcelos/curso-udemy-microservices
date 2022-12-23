import { Router } from 'express'
import UserController from '../controller/UserController.js'

const router = new Router()

router.post('/api/user/auth', (req, res) => {
  return UserController.getAccessToken(req, res)
})
export default router

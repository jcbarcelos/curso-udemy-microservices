import { Router } from 'express'
import UserController from '../controller/UserController.js'

const router = new Router()

router.get('/api/user/email/:email', (req, res) => {
  return UserController.findByEmail(req, res)
})
router.get('/api/user/auth', (req, res) => {
  return UserController.getAccessToken(req, res)
})
export default router

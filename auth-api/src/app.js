import express from 'express'
import * as db from './config/db/initialData.js'
import UserRoutes from './modules/user/routes/UserRoutes.js'
import AuthRoutes from './modules/user/routes/AuthRoutes.js'
import { CheckToken } from './config/auth/index.js'

const app = express()
const env = process.env
const PORT = env.PORT || 8080

//db.createInitalData()

app.use(express.json())
app.use(AuthRoutes)
app.use(CheckToken)
app.use(UserRoutes)

app.listen(PORT, () => {
  console.log(`Server started auth successfully at port ${PORT}`)
})

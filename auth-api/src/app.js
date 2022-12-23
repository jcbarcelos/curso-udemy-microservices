import express from 'express'
import * as db from './config/db/initialData.js'
import { userRoutes, authRoutes } from './modules/user/routes/index.js'
import { CheckToken } from './config/auth/index.js'

const app = express()
const env = process.env
const PORT = env.PORT || 8080

//db.createInitalData()

app.use(express.json())
app.use(authRoutes)
app.use(CheckToken)
app.use(userRoutes)

app.listen(PORT, () => {
  console.log(`Server started auth successfully at port ${PORT}`)
})

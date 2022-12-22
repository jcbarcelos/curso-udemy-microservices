import express from 'express'
import * as db from './config/db/initialData.js'
import router from './modules/user/routes/UserRoutes.js'

const app = express()
const env = process.env
const PORT = env.PORT || 8080

//db.createInitalData()

app.use(express.json())
app.use(router)

app.listen(PORT, () => {
  console.log(`Server started auth successfully at port ${PORT}`)
})

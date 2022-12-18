import express from 'express'

const app = express()
const env = process.env
const port = env.PORT || 8082

app.get('/api/status', (req, res) => {
  return res.status(200).json({
    service: 'Sales-API',
    status: "up",
    httpStatus: 200
  })
})

app.listen(port, () => {
  console.log(`Server started  sales successfully at port ${port}`)
})
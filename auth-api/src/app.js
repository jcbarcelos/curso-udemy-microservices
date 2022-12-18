import express from 'express'

const app = express()
const env = process.env
const port = env.PORT || 8080

app.get('/api/status', (req, res) => {
  return res.status(200).json({
    service: 'Auth-API',
    status: "up",
    httpStatus: 200
  })
})
app.get('/api', (req, res) => {
  return res.status(200).json({
    service: 'Auth-API',
    status: "up",
    httpStatus: 200
  })
})

app.listen(port, () => {
  console.log(`Server started auth successfully at port ${port}`)
})
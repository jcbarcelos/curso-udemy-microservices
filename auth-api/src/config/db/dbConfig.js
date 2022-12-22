import { Sequelize } from 'sequelize'
const sequelize = new Sequelize('auth_db', 'auth_db', 'auth_db', {
  host: 'auth_db',
  dialect: 'postgres',
})

try {
  sequelize
    .authenticate()
    .then(() => {
      console.info('Connection has been stablished!')
    })
    .catch((err) => {
      console.error('Unable to connect to the database.')
      console.error(err.message)
    })
} catch (error) {
  console.error(error.message)
}

export default sequelize

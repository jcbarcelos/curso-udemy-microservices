class ExceptionValidation extends Error {
  constructor(status, message, errors) {
    super(message)
    this.status = status
    this.message = message
    this.name = this.constructor.name
    Error.captureStackTrace(this, this.constructor)
  }
}

export default ExceptionValidation
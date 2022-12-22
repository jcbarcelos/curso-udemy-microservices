import { BAD_REQUEST } from '../config/constants/index.js'
import { messageErrorNotFound, messageNotInformed } from '../helps/index.js';
import ExceptionValidation from './ExceptionValidation.js'

class Validation {
  validationValueData(params) {
    
    if (!params) {
      throw new ExceptionValidation(BAD_REQUEST, `${params} ${messageNotInformed}`)
    }
  }
  validationNotFound(params) {
    console.log(`validationNotFound ${params}`);
    if (params) {
      throw new ExceptionValidation(BAD_REQUEST, `${params} ${messageErrorNotFound}`)
    }
  }
 
}

export default new Validation()

package io.pivotal.services.dataTx.geode.rest.exception


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @author Gregory Green
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
open class DataServiceSystemException : RuntimeException
{
    constructor();

    constructor(messge: String?) : super(messge)


    constructor(message : String?, cause : Throwable?,  enableSuppression : Boolean,
                writableStackTrace : Boolean):
            super(message, cause, enableSuppression, writableStackTrace);

    constructor (message : String?, cause : Throwable? )
            :super(message, cause);


}
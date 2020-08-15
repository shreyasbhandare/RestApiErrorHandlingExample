package com.springrestdemo.exception

class StudentErrorResponse(var status : Int? = null,
                           var message : String? = null,
                           var timeStamp : Long? = null) {

}
package helloworld.grpc.services

import javax.inject.Singleton

@Singleton
class GreetingService {

    fun sayHello(value: String): String {
        return "Hello Mr $value"
    }
}
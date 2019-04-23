package helloworld.grpc.services

import helloworld.grpc.HelloRequest
import helloworld.grpc.HelloResponse
import helloworld.grpc.HelloServiceGrpc.HelloServiceImplBase
import io.grpc.Status
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class HelloServiceImpl(val greetingService: GreetingService): HelloServiceImplBase() {

    override fun hello(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        val message = greetingService.sayHello(request.firstName)
        if(message.contains("b".toUpperCase())) {
            val reply = HelloResponse.newBuilder().setGreeting(message).build()
            responseObserver.onNext(reply)
            responseObserver.onCompleted()
        }
        else {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT.withDescription("Name does not start with b")
                            .augmentDescription("another line").asException()
            )
        }



    }
}
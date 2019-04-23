package helloworld.grpc

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("helloworld.grpc")
                .mainClass(Application.javaClass)
                .start()
    }
}
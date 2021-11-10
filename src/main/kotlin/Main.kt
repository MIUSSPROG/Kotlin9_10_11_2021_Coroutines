import kotlinx.coroutines.*

suspend fun doSomeWork() {
    for (i in 0..5) {
        delay(400)
        println(i)
    }
}

suspend fun doSomeOtherWork() {
    for (i in 5 downTo 0 step 1) {
        delay(200)
        println("*** $i")
    }
}

suspend fun main(){

//    coroutineScope {
//        launch {doSomeWork()}
//        launch {doSomeOtherWork()}
//        println("Hello Coroutines")
//    }

    coroutineScope {
        val job = launch(start = CoroutineStart.LAZY) {
            for(i in 1..5){
                println(i)
                delay(400L)
            }
        }

        println("Start")
        job.start()
        println("End")
    }

}

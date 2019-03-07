package co.touchlab.shared

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DogAPI {
    private val client: HttpClient = HttpClient()

    fun getRandomDog(callback: (String) -> Unit) {
        GlobalScope.launch(MainDispatcher) {
            val result: String = client.get("https://dog.ceo/api/breeds/image/random")
            callback(result)
        }
    }
}

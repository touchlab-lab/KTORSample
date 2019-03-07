package co.touchlab.shared

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class DogAPI {
    private val client: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json.nonstrict).apply {
                setMapper(ImageResult::class, ImageResult.serializer())
            }
        }
    }

    fun getRandomDog(callback: (String) -> Unit) {
        GlobalScope.launch(MainDispatcher) {
            val result: ImageResult = client.get("https://dog.ceo/api/breeds/image/random")
            if (result.status == "success")
                callback(result.message)
        }
    }
}

package co.touchlab.shared

class DogAPI {
    fun getRandomDog(callback: (String) -> Unit) {
        callback("Beagle")
    }
}

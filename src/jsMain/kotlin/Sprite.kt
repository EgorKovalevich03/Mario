data class Sprite(var src: String, val si: Int, val sj: Int, val w:Int=1, val h:Int =1)

const val TILES_IMAGE = "sprites/tiles.png"

val cloudSprite = Sprite(TILES_IMAGE, si = 0, sj = 20, w = 3, h = 2)
val floorSprite = Sprite(TILES_IMAGE, si = 0, sj = 0, w = 16, h = 1)
val hillSprites = listOf(
    Sprite(TILES_IMAGE, si = 8, sj = 10),
    Sprite(TILES_IMAGE, si = 9, sj = 10),
    Sprite(TILES_IMAGE, si = 10, sj = 10),
    Sprite(TILES_IMAGE, si = 8, sj = 11),
    Sprite(TILES_IMAGE, si = 9, sj = 11),
    Sprite(TILES_IMAGE, si = 10, sj = 11),
)
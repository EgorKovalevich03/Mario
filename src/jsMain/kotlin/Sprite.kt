data class Sprite(var src: String, val si: Int, val sj: Int, val w:Int=1, val h:Int =1)

const val TILES_IMAGE = "sprites/tiles.png"

val cloudSprite = Sprite(TILES_IMAGE, si = 0, sj = 20, w = 3, h = 2)
val floorSprite = Sprite(TILES_IMAGE, si = 0, sj = 0, w = 16, h = 1)

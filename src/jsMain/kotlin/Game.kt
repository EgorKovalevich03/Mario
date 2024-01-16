import csstype.AutoLength
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.Image

val sourceImage = Image()


lateinit var context: CanvasRenderingContext2D

fun main() {
    window.onload = {
        val canvas: HTMLCanvasElement = document.getElementById("canvas") as HTMLCanvasElement
        context = canvas.getContext("2d") as CanvasRenderingContext2D
        context.scale(3.0, 3.0)
        context.fillStyle = "#7974FF"
        context.fillRect(0.0, 0.0, 762.0, 720.0)

        sourceImage.src = TILES_IMAGE
        sourceImage.onload = {
            render()
        }
        Unit
    }
}

fun render() {
    drawCloud(7, 5)
    drawFloor()
    drawBush(12,14)
    //drawHill(0,0,3)
    //drawHill(1,1,1)
    drawHill(0,3)
}

const val CELL_SIZE = 16.0
fun drawSprite(sprite: Sprite, x: Double, y: Double) {
    context.drawImage(
        sourceImage,
        sx = sprite.si * CELL_SIZE + 1/3.0,
        sy = sprite.sj * CELL_SIZE + 1/3.0,
        sw = sprite.w * CELL_SIZE - 2/3.0,
        sh = sprite.h * CELL_SIZE - 2/3.0,
        dw = sprite.w * CELL_SIZE,
        dh = sprite.h * CELL_SIZE,
        dx = x * CELL_SIZE,
        dy = (13 - y - sprite.h) * CELL_SIZE,
    )
}


fun drawFloor(){
    for(j in -2..-1){
        for(i in 0 .. 15){
            drawSprite(floorSprite, i, j)
        }
    }
}
fun drawSprite(sprite: Sprite, i:Int, j:Int){
    drawSprite(sprite, i.toDouble(), j.toDouble())
}

fun drawCloud(i: Int, j: Int) {
    drawSprite(cloudSprite, i, j)
}


val bushSprites = listOf(
    Sprite(TILES_IMAGE, si = 11, sj = 9),
    Sprite(TILES_IMAGE, si = 12, sj = 9),
    Sprite(TILES_IMAGE, si = 13, sj = 9)
)
fun drawBush(i:Int, length: Int){
    drawSprite(bushSprites[0], i=11, j = 0 )
    for(n in i..length){
        drawSprite(bushSprites[1], i=n, j = 0)
    }
    drawSprite(bushSprites[2],i=length+1,j=0)
}

val hillSprites = listOf(
    Sprite(TILES_IMAGE, si = 8, sj = 10),
    Sprite(TILES_IMAGE, si = 9, sj = 10),
    Sprite(TILES_IMAGE, si = 10, sj = 10),
    Sprite(TILES_IMAGE, si = 8, sj = 11),
    Sprite(TILES_IMAGE, si = 9, sj = 11),
    Sprite(TILES_IMAGE, si = 10, sj = 11),
)

fun drawHill(i: Int, height: Int) {

    for(w in 0..height-1){
        drawSprite(hillSprites[0], i = i, j = w)
        //drawSprite(hillSprites[2], )
    }

    /*
    for(w in 0..size){
        drawSprite(hillSprites[0], i = i, j = w)
        for(xx in 1..size){
            drawSprite(hillSprites[4], i = i + xx, j = w)
        }
        drawSprite(hillSprites[2], i = i + size+1, j = w)
    }

    drawSprite(hillSprites[1], i = i + size-1, j = height+2)
    */
    /*drawSprite(hillSprites[0], i = i, j = height) // left bottom
    for(q in 1..size){
        drawSprite(hillSprites[4], i = i + q, j = height) // middle bottom
    }
    drawSprite(hillSprites[2], i = i + size+1, j = height) // right bottom
        */
    //drawSprite(hillSprites[], i = i + 2, j = height) // right bottom
}


/*val image = Image()
        image.src = "mario.jpg"
        image.onload = {
            context.drawImage(image, 70.0,70.0)
        }*/
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
    drawHill(2,0)
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


fun drawHill(i: Int, height: Int) {
    for(n in 0 until 5) {
        //val size = 2 // calculate section size
        // drawHillSection(i, j, size)
        drawSprite(hillSprites[n], i = i + height, j = height) // top
    }

}


/*val image = Image()
        image.src = "mario.jpg"
        image.onload = {
            context.drawImage(image, 70.0,70.0)
        }*/
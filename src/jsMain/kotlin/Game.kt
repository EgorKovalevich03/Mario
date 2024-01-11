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

fun drawSprite(sprite: Sprite, i:Int, j:Int){
    drawSprite(sprite, i.toDouble(), j.toDouble())
}

fun drawCloud(i: Int, j: Int) {
    drawSprite(cloudSprite, i, j)
}


/*val image = Image()
        image.src = "mario.jpg"
        image.onload = {
            context.drawImage(image, 70.0,70.0)
        }*/
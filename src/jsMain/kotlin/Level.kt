class Level {
    val entities = setOf<Entity>()

    fun render(){
        for(entity in entities){
            drawSprite(entity.sprite,entity.x,entity.y)
        }
    }

    fun addFloor(){
        TODO()
    }
    fun addBush(i:Int,size:Int){
        TODO()
    }
    fun addCloud(i:Int,j:Int,size:Int){
        TODO()
    }
    fun addHill(i:Int,height:Int){
        TODO()
    }

}
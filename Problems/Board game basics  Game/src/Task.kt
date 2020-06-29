object PlayingField {
    object Size {
        var width = 0
        var height = 0

        fun changeSize(width: Int, height: Int) {
            this.height = if (height > 0) height else 0
            this.width = if (width > 0) width else 0
        }
    }
}
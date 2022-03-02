package com.talestra.rhcommon.ds

class IntArray2(val width: Int, val height: Int, val data: IntArray = IntArray(width * height)) {
	private fun index(x: Int, y: Int) = y * width + x

	fun contains(x: Int, y: Int): Boolean = (x >= 0) && (y >= 0) && (x < width) && (y < height)

	operator fun get(x: Int, y: Int): Int = data[index(x, y)]
	operator fun set(x: Int, y: Int, value: Int) = let { data[index(x, y)] = value }

	inline fun forEach(callback: (x: Int, y: Int, v: Int) -> Unit) {
		for (y in 0 until height) {
			for (x in 0 until width) {
				callback(x, y, this[x, y])
			}
		}
	}
}
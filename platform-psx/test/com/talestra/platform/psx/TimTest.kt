package com.talestra.platform.psx

import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.bitmap.Bitmap32
import com.soywiz.korim.format.ImageFormat
import com.soywiz.korim.format.readBitmap
import com.soywiz.korim.format.showImageAndWait
import com.soywiz.korio.async.sync
import com.soywiz.korio.async.syncTest
import com.soywiz.korio.vfs.ResourcesVfs
import com.soywiz.korio.vfs.VfsFile
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class TimTest {
	@Test
	fun name(): Unit = syncTest {
		val image = ResourcesVfs["test.tim"].readBitmap()
		val expectedImage = ResourcesVfs["test.tim.png"].readBitmap()
		//Bitmap32.diff(image, expectedImage)
		//awtShowImage(image)
		//awtShowImage(expectedImage)
		//Thread.sleep(10000L)
		Assert.assertTrue(Bitmap32.matches(image, expectedImage, 1))
		Unit
	}

	@Test
	@Ignore("interactive")
	fun name2(): Unit = syncTest {
		showImageAndWait(ResourcesVfs["test.tim"].readBitmap())
	}
}

suspend fun VfsFile.writeBitmap(bitmap: Bitmap, format: ImageFormat) {
	this.write(format.encode(bitmap))
}
package com.talestra.dividead

import com.soywiz.korio.async.syncTest
import com.soywiz.korio.async.toList
import com.soywiz.korio.vfs.ResourcesVfs
import com.talestra.rhcommon.io.generate
import org.junit.Assert
import org.junit.Test

class SG1Test {
	val resources = ResourcesVfs

	@Test
	fun name() = syncTest {
		val TEST_DL1 = resources["TEST.DL1"].read()
		val files = resources["TEST.DL1"].openAsDL1()
		val generated = DL1.generate(files)
		//LocalVfs("c:/temp/test1.dl1").write(TEST_DL1)
		//LocalVfs("c:/temp/test2.dl1").write(generated)
		Assert.assertArrayEquals(TEST_DL1, generated)

		Assert.assertEquals(
				"[(B.TXT, 5), (HELLO.TXT, 12), (A.TXT, 5)]",
				files.listRecursive().toList().map { Pair(it.basename, it.size()) }.toString()
		)
	}

	//@Test
	//fun testDecompression() = syncTest {
	//	val files = LocalVfs("D:/juegos/dividead/SG.DL1").openAsDL1()
	//	val uncompressedData = LZ.uncompress(files["OMAKE_3.BMP"].read())
	//	LocalVfs("D:/juegos/dividead/OMAKE_3.BMP").write(uncompressedData)
	//}
}
package com.talestra.yume.formats

import com.soywiz.korio.stream.*
import com.talestra.rhcommon.ds.ByteArray2

class TBL(
	val count: Int,
	val mask: String,
	val enableFlags: List<Int>,
	val keyMap: ByteArray2
) {
	companion object {
		fun read(s: SyncStream) = TBL(
			count = s.readS32_le(),
			mask = s.readStringz(9), // MSK file with masks for each button
			enableFlags = s.readIntArray_le(0xFF).toList(), // 01-FF
			keyMap = ByteArray2(0x10, 0x12, s.readBytes(0x10 * 0x12))
		)
	}
}
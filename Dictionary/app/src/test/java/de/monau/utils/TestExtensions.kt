package de.monau.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

fun Any.assertEquals(any: Any) =
    assertEquals(this, any)

fun Any?.assertNull() =
    assertNull(this)
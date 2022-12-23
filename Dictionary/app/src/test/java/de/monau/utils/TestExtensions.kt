package de.monau.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull

fun Any.assertEquals(any: Any) =
    assertEquals(this, any)

fun Any?.assertNull() =
    assertNull(this)

fun <T> Any.assertType(type: Class<T>) =
    assertEquals(this.javaClass, type)
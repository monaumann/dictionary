package de.monau.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import de.monau.models.Verb
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import javax.inject.Inject

private const val PATH = "/dictionary"
private const val FILENAME = "eng-es.txt"

class StorageHelper @Inject constructor(
    private val verbHelper: VerbHelper,
) {

    fun writeLines(context: Context, lines: List<String>) {
        val file = getFile(context)
        file?.writeLines(lines)
    }

    fun readVerb(context: Context): List<Verb> {
        val verbs = mutableListOf<Verb>()
        getFile(context)?.read()?.let { lines ->
            for (line in lines) {
                verbHelper.convert(line)?.let(verbs::add)
            }
        }
        return verbs
    }

    private fun getFile(context: Context): File? {
        var success = true
        val rootFile = context.getAbsoluteFile()
        if (!rootFile.exists()) success = rootFile.mkdir()
        return if (success) File(rootFile, FILENAME)
        else null
    }
}

private fun Context.getAbsoluteFile(relativePath: String = PATH): File =
    if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState())
        File(getExternalFilesDir(null), relativePath)
    else
        File(filesDir, relativePath)

private fun File.writeLines(lines: List<String>) {
    try {
        val bufferedWriter = BufferedWriter(FileWriter(this))
        PrintWriter(bufferedWriter).use {
            for (line in lines) it.appendLine(line)
        }
    } catch (ex: Exception) {
        Log.e("development", "Writing Exception: $ex")
    }
}

private fun File.read(): List<String> {
    return try {
        bufferedReader().readLines()
    } catch (ex: Exception) {
        emptyList<String>().also { Log.e("development", "Reading Exception: $ex") }
    }
}
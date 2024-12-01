package org.example.shared

import java.io.File
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Defuser {
    fun defuseBOM(filePath: String) {
        val file = File(filePath)

        val reader = InputStreamReader(file.inputStream(), Charsets.UTF_8)
        val content = reader.readText()

        val cleanedContent = if (content.startsWith("\uFEFF")) {
            content.substring(1)
        } else {
            content
        }

        val writer = OutputStreamWriter(FileOutputStream(file), Charsets.UTF_8)
        writer.write(cleanedContent)
        writer.close()
    }
}
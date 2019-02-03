static def openFile(String fileName) {
    new FileInputStream(fileName)
}

try {
    openFile("nonexistentFile")
} catch (FileNotFoundException ex) {
    println "Oops: " + ex
}

/**
 * 4.5 使用闭包进行资源清理
 */
new FileWriter('output.txt').withWriter {
    it.write('abc')
}

/**
 * 自定义资源清理
 */
class Resource {
    def open() { print "opened..." }

    def close() { print "close..." }

    def write() { print "write..." }

    def read() { print "read..." }

    def static use(closure) {
        def r = new Resource()
        try {
            r.open()
            closure(r)
        } finally {
            r.close()
        }
    }
}

Resource.use { res ->
    res.read()
    res.write()
}

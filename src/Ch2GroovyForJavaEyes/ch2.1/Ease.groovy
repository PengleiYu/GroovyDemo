static def foo(String str) {
    str?.reverse()
}

println foo("evil")
println foo(null)

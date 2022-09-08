import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer

val SourceSetContainer.main: SourceSet get() = getByName("main")
fun SourceSetContainer.main(block: SourceSet.() -> Unit) = main.apply(block)
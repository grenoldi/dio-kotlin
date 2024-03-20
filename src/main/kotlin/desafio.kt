enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val activities: Int = 1, val level: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if(inscritos.contains(usuario)){
            println("Usuario ja cadastrado na formacao: $nome")
        } else {
            inscritos.add(usuario)
        }
    }

    fun tempoTotal():Int{
        var total = 0
        for(conteudo in conteudos){
            total += conteudo.duracao
        }
        return total
    }
}

fun main() {
    val listaFormacao1: MutableList<ConteudoEducacional> = mutableListOf()
    val lista1: List<ConteudoEducacional> = listaFormacao1

    listaFormacao1.add(ConteudoEducacional("Desmistificando a Linguagem de Programacao Kotlin", 14, 8, Nivel.BASICO))
    listaFormacao1.add(ConteudoEducacional("Fundamentos de Desenvolvimento Mobile Nativo Para Android", 8, 5, Nivel.BASICO))
    listaFormacao1.add(ConteudoEducacional("Nocoes basicas do Android com Kotlin", 15, 7, Nivel.INTERMEDIARIO))
    listaFormacao1.add(ConteudoEducacional("Dominando o Android Jetpack", 26, 11, Nivel.AVANCADO))

    val formacao1 = Formacao("Formacao Android Developer", lista1)

    val nomes = listOf("Alice", "Bob", "Charlie", "David", "Eva", "Fernanda", "Gustavo", "Helena", "Isaac", "Julia")

    val listaUsuarios = nomes.map { Usuario(it) }

    listaUsuarios.forEach { usuario ->
        formacao1.matricular(usuario)
    }

    println("${formacao1.nome} - Duracao de ${formacao1.tempoTotal()} horas\n\nConteudos Educacionais:")
    formacao1.conteudos.forEach{
        println(it.toString())
    }
    println("\nAlunos matriculados:")
    formacao1.inscritos.forEach {
        println(" - " + it.nome)
    }
}
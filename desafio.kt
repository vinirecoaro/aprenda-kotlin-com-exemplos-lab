enum class Nivel {BASICO, INTERMEDIARIO, AVANÇADO}

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    val exibeNivel: String = when(nivel){
        Nivel.BASICO -> "Básico"
        Nivel.INTERMEDIARIO -> "Intermediário"
        Nivel.AVANÇADO -> "Avançado"
    }
    
    fun matricular(vararg usuario: Usuario) {
        for (i in usuario){
            inscritos.add(i)
        }
    }
}

fun main() {
    val user1 = Usuario("Vinicius")
    val user2 = Usuario("Larissa")
    val user3 = Usuario("Tiago")
                                                 
    val conteudo: MutableList<ConteudoEducacional> = mutableListOf(ConteudoEducacional("Funcoes em Kotlin", 90),
                                               		ConteudoEducacional("Classes em Kotlin", 60),
                                               		ConteudoEducacional("MVVM", 120))
    
    val curso1 = Formacao("Formação em Kotlin", conteudo, Nivel.INTERMEDIARIO)
    
    curso1.matricular(user1, user2, user3)
   
}
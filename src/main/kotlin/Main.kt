
class Modulo(maxAlumnos: Int){
    var maxAlumnos = maxAlumnos
    var alumnos = arrayOfNulls<Alumno>(maxAlumnos)
    var evaluaciones = Array(4) { FloatArray(maxAlumnos) }

    /*
    override fun toString(): String {
        return "${alumnos.forEach {if (it != null) {it.nombre}}}"
    }

     */

    //He hecho este método para no introducir las notas de manera manual
    fun generarNotas() {
        for (i in 0..maxAlumnos - 1) {
            evaluaciones[0][i] = (0..10).random().toFloat()
            evaluaciones[1][i] = (0..10).random().toFloat()
            evaluaciones[2][i] = (0..10).random().toFloat()

        }
    }

    fun establecerNota(idAlumno:String, evaluacion:Int, nota:Float): Boolean{
        var x: Int = 0
        var Logrado : Boolean = false

        //Este while recorre el array alumnos hasta encontrar un id = idAlumno y obtener su posición
        while (x != maxAlumnos) {
            if (alumnos[x]?.id == idAlumno) {
                x = maxAlumnos
                Logrado = true
            } else {
                x++
            }
        }

        evaluaciones[evaluacion - 1][x] = nota
        return Logrado
    }

    //Le he añadido un return por si se quisiera imprimir el resultado
    fun calculaEvaluacionFinal(idAlumno: String): Float{
        var x: Int = 0
        var y: Int = 0


        //Este while recorre el array alumnos hasta encontrar un id = idAlumno y obtener su posición
        while (y != maxAlumnos - 1) {
            if (alumnos[y]?.id == idAlumno) {
                y = maxAlumnos - 1
            } else {
                y++
                x++
            }
        }

        var notaFinal = evaluaciones[0][x] + evaluaciones[1][x] + evaluaciones[2][x]
        notaFinal = notaFinal / 3

        return notaFinal
    }

    fun listaNotas(evaluacion:Int): List<Pair<Alumno, Float>>
    {

        val listaNotas: MutableList<Pair<Alumno, Float>> = mutableListOf()

        for (i in 0 until maxAlumnos)
        {
            if (alumnos[i] != null) listaNotas.add(Pair(alumnos[i]!!,evaluaciones[evaluacion - 1][i]))
        }
        return listaNotas
    }

    fun numeroAprobados(evaluacion:Int): Int{
        var numeroAprobados: Int = 0
        for (i in 0 until maxAlumnos) {if (evaluaciones[evaluacion - 1][i] >= 5) {numeroAprobados++} }
        return numeroAprobados
    }

    fun notaMasBaja(evaluacion: Int): Float {
        var notaMasBaja = evaluaciones[evaluacion - 1].minOrNull()!!
        return notaMasBaja
    }

    fun notaMasAlta(evaluacion: Int): Float {
        var notaMasAlta = evaluaciones[evaluacion - 1].maxOrNull()!!
        return notaMasAlta
    }

    fun notaMedia(evaluacion: Int): Float {
        var notaMedia: Float = 0F
        for (x in 0..maxAlumnos - 1) { notaMedia = notaMedia + evaluaciones[evaluacion - 1][x] }
        notaMedia = notaMedia / maxAlumnos
        return notaMedia

    }

    fun hayAlumnosConDiez(evaluacion:Int): Boolean
    {
       return evaluaciones[evaluacion -1].any {it == 10F}
    }

    fun hayAlumnosAprobados(evaluacion:Int): Boolean{
        return evaluaciones[evaluacion - 1].any {it >= 5.0F}
    }

    fun primeraNotaNoAprobada(evaluacion:Int): Float?{
        return evaluaciones[evaluacion -1].find {it < 5.0F}
    }

    fun listaNotasOrdenados(evaluacion:Int):  List<Pair<Alumno, Float>>{
        return listaNotas(evaluacion).sortedBy { it.second }
    }

    //Si returnea un false es porque la lista está llena
    fun matricularAlumno(alumno:Alumno): Boolean{
        //meter alumno en el primer null
        var x: Int = 0
        var Logrado: Boolean = false
        while (x != maxAlumnos) {
            if (alumnos[x] == null) {
                alumnos[x] = alumno
                x = maxAlumnos
                Logrado = true
            } else {
                x++
            }
        }
        return Logrado
    }

    fun bajaAlumno(idAlumno:String): Boolean{
        var Logrado: Boolean = false
        var x: Int = 0

        while (x != maxAlumnos - 1) {
            alumnos[x]
            if (alumnos[x]?.id == idAlumno) {
                alumnos[x] = null
                Logrado = true
                x = maxAlumnos - 1
            } else {
                x++
            }
        }
        return Logrado
    }
}

class Alumno(var id: String, var nombre: String, var ap1: String, var ap2: String){
    init {
        require(id.isNotEmpty())
        require(nombre.isNotEmpty())
        require(ap1.isNotEmpty())
        require(ap2.isNotEmpty())
    }
}


fun main(){

    //1.Ponemos 10 alumnos
    var alumno1 = Alumno("1", "Juan", "Romero", "Gutierrez")
    var alumno2 = Alumno("2", "Jose", "Boquete", "Boqueton")
    var alumno3 = Alumno("3", "Japa", "Montes", "Chorba")
    var alumno4 = Alumno("4", "Impresora", "De", "Ataque")
    var alumno5 = Alumno("5", "Ching", "Cheng", "Chong")
    var alumno6 = Alumno("6", "Allah", "Gonzalez", "Rios")
    var alumno7 = Alumno("7", "Mega", "Jose", "Luis")
    var alumno8 = Alumno("8", "Acabado", "Gonzalez", "Triple")
    var alumno9 = Alumno("9", "Una", "Vez", "Más")
    var alumno10 = Alumno("10", "Cojo", "Una", "Papa")


    //Alumnos extras (Para experimentar con añadir y eliminar alumno)
    var alumno11 = Alumno("11", "Pim", "Pam", "Trucu")
    var alumno12 = Alumno("12", "Pamela", "Busca", "Cuevas")
    var alumno13 = Alumno("13", "Oraldine", "Que", "Bueno")

    var Modulo1 = Modulo(15)

    Modulo1.matricularAlumno(alumno1)
    Modulo1.matricularAlumno(alumno2)
    Modulo1.matricularAlumno(alumno3)
    Modulo1.matricularAlumno(alumno4)
    Modulo1.matricularAlumno(alumno5)
    Modulo1.matricularAlumno(alumno6)
    Modulo1.matricularAlumno(alumno7)
    Modulo1.matricularAlumno(alumno8)
    Modulo1.matricularAlumno(alumno9)
    Modulo1.matricularAlumno(alumno10)

    //1.Rellenamos las notas de las evaluaciones
    Modulo1.generarNotas()

    //2.Calculamos la nota final de los alumnos del modulo
    print("Nota media del alumno 1: ")
    println(Modulo1.calculaEvaluacionFinal(alumno1.id))
    print("Nota media del alumno 2: ")
    println(Modulo1.calculaEvaluacionFinal(alumno2.id))
    print("Nota media del alumno 3: ")
    println(Modulo1.calculaEvaluacionFinal(alumno3.id))
    print("Nota media del alumno 4: ")
    println(Modulo1.calculaEvaluacionFinal(alumno4.id))
    print("Nota media del alumno 5: ")
    println(Modulo1.calculaEvaluacionFinal(alumno5.id))
    print("Nota media del alumno 6: ")
    println(Modulo1.calculaEvaluacionFinal(alumno6.id))
    print("Nota media del alumno 7: ")
    println(Modulo1.calculaEvaluacionFinal(alumno7.id))
    print("Nota media del alumno 8: ")
    println(Modulo1.calculaEvaluacionFinal(alumno8.id))
    print("Nota media del alumno 9: ")
    println(Modulo1.calculaEvaluacionFinal(alumno9.id))
    print("Nota media del alumno 10: ")
    println(Modulo1.calculaEvaluacionFinal(alumno10.id))

    //3.Obtenemos la lista de notas de los alumnos
    println("")
    print("Notas primera, segunda y tercera evaluación respectivamente")
    println("")
    println(Modulo1.listaNotas(1))
    println(Modulo1.listaNotas(2))
    println(Modulo1.listaNotas(3))
    println("")
    println("")

    //4.Calculamos cuantos alumnos han aprobado por evaluación
    println("En la primera evaluación han aprobado " + Modulo1.numeroAprobados(1) + " alumnos")
    println("En la segunda evaluación han aprobado " + Modulo1.numeroAprobados(2) + " alumnos")
    println("En la tercera evaluación han aprobado " + Modulo1.numeroAprobados(3) + " alumnos")
    println("")

    //5.Calculamos la nota más baja del módulo por evaluaciones
    println("En la primera evaluación la nota más baja es " + Modulo1.notaMasBaja(1))
    println("En la segunda evaluación la nota más baja es " + Modulo1.notaMasBaja(2))
    println("En la tercera evaluación la nota más baja es " + Modulo1.notaMasBaja(3))
    println("")

    //6.Calculamos la nota más alta del módulo por evaluaciones
    println("En la primera evaluación la nota más alta es " + Modulo1.notaMasAlta(1))
    println("En la segunda evaluación la nota más alta es " + Modulo1.notaMasAlta(2))
    println("En la tercera evaluación la nota más alta es " + Modulo1.notaMasAlta(3))
    println("")

    //7.Calculamos nota media por evaluación
    println("La nota media de la primera evaluación es de " + Modulo1.notaMedia(1))
    println("La nota media de la segunda evaluación es de " + Modulo1.notaMedia(2))
    println("La nota media de la tercera evaluación es de " + Modulo1.notaMedia(3))
    println("")

    //8.Calculamos si hay algún 10 por evaluación
    println("¿Hay alumnos con 10?")
    println("En la primera evaluación " + Modulo1.hayAlumnosConDiez(1))
    println("En la segunda evaluación " + Modulo1.hayAlumnosConDiez(2))
    println("En la tercera evaluación " + Modulo1.hayAlumnosConDiez(3))
    println("")

    //9.Calculamos si hay algún aproabado por evaluación
    println("¿Hay alumnos aprobados?")
    println("En la primera evaluación " + Modulo1.hayAlumnosAprobados(1))
    println("En la segunda evaluación " + Modulo1.hayAlumnosAprobados(2))
    println("En la tercera evaluación " + Modulo1.hayAlumnosAprobados(3))
    println("")

    //10.Calculamos la primera nota que no ha superado el 5 por evaluación
    println("Las primeras notas suspensas de cada evaluación son")
    println("En la primera evaluación " + Modulo1.primeraNotaNoAprobada(1))
    println("En la segunda evaluación " + Modulo1.primeraNotaNoAprobada(2))
    println("En la tercera evaluación " + Modulo1.primeraNotaNoAprobada(3))
    println("")

    //11.Imprimir ordenado
    println("La lista de notas ordenadas es: ")
    println(Modulo1.listaNotasOrdenados(1))
    println("")

    //12.Matricular alumno - printea un true si se añade y false si no
    println("¿Se han matriculado los alumnos?")
    println(Modulo1.matricularAlumno(alumno11))
    println(Modulo1.matricularAlumno(alumno11))
    println(Modulo1.matricularAlumno(alumno11))
    println(Modulo1.matricularAlumno(alumno11))
    println(Modulo1.matricularAlumno(alumno12))
    println("")

    //13. Dar baja alumnos - printea true si se ha dado de baja y false si no
    println("¿Se ha dado de baja al alumno?")
    println(Modulo1.bajaAlumno("1"))
}
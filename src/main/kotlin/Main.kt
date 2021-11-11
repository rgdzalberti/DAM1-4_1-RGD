var cantidadAlumnos: Int = 3
var alumnos = arrayOfNulls<Alumno>(cantidadAlumnos)
var evaluaciones = Array(4) { DoubleArray(cantidadAlumnos) }


class Modulo
{
    //(filas){columnas} <-- al reves /arrayMin arrayMax chikiar

    fun Modulo(maxAlumnos:Int){
    }

    fun establecerNota(idAlumno:String, evaluacion:Int, nota:Double)
    {
        var x : Int = 0

        //Este while recorre el array alumnos hasta encontrar un id = idAlumno y obtener su posición
        while (x !=cantidadAlumnos)
        {
            if (alumnos[x]?.id == idAlumno)
            {
                x = cantidadAlumnos
            }
            else
            {
                x++
            }
        }

        evaluaciones[evaluacion - 1][x] = nota
    }

    fun calculaEvaluacionFinal(idAlumno:String): Double {
        var x : Int = 0

        //Este while recorre el array alumnos hasta encontrar un id = idAlumno y obtener su posición
        while (x !=cantidadAlumnos)
        {
            if (alumnos[x]?.id == idAlumno)
            {
                x = cantidadAlumnos
            }
            else
            {
                x++
            }
        }

        var notaFinal = evaluaciones[0][x] + evaluaciones[1][x] + evaluaciones[2][x]
        notaFinal = notaFinal/3

        return notaFinal

    }

    fun listaNotas(evaluacion:Int)
    {
       for(x in 0..cantidadAlumnos) {
           println(evaluaciones[evaluacion - 1][x])
       }
    }

    fun numeroAprobados(evaluacion:Int): Int
    {
        var aprobados : Int = 0

        for(x in 0..cantidadAlumnos) {

            evaluaciones[evaluacion - 1][x]

            if (evaluaciones[evaluacion - 1][x] < 5)
            {
                aprobados++
            }

        }

        return aprobados
    }

    fun notaMasBaja(evaluacion:Int): Double? {
        var notaMasBaja = evaluaciones[evaluacion - 1].minOrNull()
        return notaMasBaja
    }

    fun notaMasAlta(evaluacion:Int): Double?
    {

            var notaMasAlta = evaluaciones[evaluacion - 1].maxOrNull()
            return notaMasAlta

    }

    fun notaMedia(evaluacion:Int): Double
    {
        var notaMedia : Double = 0.0

        for(x in 0..cantidadAlumnos) {
            notaMedia = notaMedia + evaluaciones[evaluacion - 1][x]
        }

        notaMedia = notaMedia / cantidadAlumnos
        return notaMedia

    }

    fun hayAlumnosConDiez(evaluacion:Int): Boolean
    {
        for(x in 0..cantidadAlumnos) {
            evaluaciones[evaluacion - 1][x]
            if (evaluaciones[evaluacion - 1][x]==10.0)
            {
                return true
            }
            else
            {
                return false
            }
        }
        return false
    }

    fun hayAlumnosAprobados(evaluacion:Int): Boolean
    {
        for(x in 0..cantidadAlumnos) {
            evaluaciones[evaluacion - 1][x]
            if (evaluaciones[evaluacion - 1][x]==5.0)
            {
                return true
            }
            else
            {
                return false
            }
        }
        return false
    }

    fun primeraNotaNoAprobada(evaluacion:Int): Double
    {
        var primeraNotaSuspensa : Double = 0.0

        for(x in 0..cantidadAlumnos) {
            evaluaciones[evaluacion - 1][x]
            if (evaluaciones[evaluacion - 1][x]<5.0)
            {
                var primeraNotaSuspensa = evaluaciones[evaluacion - 1][x]

            }
        }
        return primeraNotaSuspensa
    }
}

class Alumno (var id: String, var nombre: String, var ap1:String, var ap2:String)
{
    init {
        require(id.isNotEmpty())
        require(nombre.isNotEmpty())
        require(ap1.isNotEmpty())
        require(ap2.isNotEmpty())
    }
}

fun main() {

    //Declaramos el número de alumnos que tendrá el módulo
    cantidadAlumnos = 15

    //Ponemos 10 alumnos
    var alumno1 = Alumno("1","Juan","Romero","Gutierrez")
    var alumno2 = Alumno("2","Jose","Boquete","Boqueton")
    var alumno3 = Alumno("3","Japa","Montes","Chorba")
    var alumno4 = Alumno("4","Japa","Montes","Chorba")
    var alumno5 = Alumno("5","Japa","Montes","Chorba")
    var alumno6 = Alumno("6","Japa","Montes","Chorba")
    var alumno7 = Alumno("7","Japa","Montes","Chorba")
    var alumno8 = Alumno("8","Japa","Montes","Chorba")
    var alumno9 = Alumno("9","Japa","Montes","Chorba")
    var alumno10 = Alumno("10","Japa","Montes","Chorba")


    var Modulo = Modulo()





    /*
    println(alumnos[0])
    println(alumnos[1])
    println(alumnos[2])
    alumnos[0] = alumno1
    println(alumnos[0]?.nombre)
    println(alumnos[0]?.ap1)
    println(alumnos[1])
    println(alumnos[2])

     */




}
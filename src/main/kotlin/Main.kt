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

        evaluaciones[3][evaluacion] = nota
    }

    fun listaNotas(evaluacion:String)
    {

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

    var alumno1 = Alumno("1","Juan","Romero","Gutierrez")
    var alumno2 = Alumno("3","Jose","Boquete","Boqueton")
    var alumno3 = Alumno("5","Japa","Montes","Chorba")

    var Modulo = Modulo()

    println(evaluaciones[3][1])
    Modulo.establecerNota("3",1,6.0)
    println(evaluaciones[3][1])


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
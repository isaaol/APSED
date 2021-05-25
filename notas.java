import java.util.Arrays;
import java.util.Random;

/**
 *   Guarda las notas que han sacado una serie 
 *  de estudiantes en varias asignaturas
 *  
 */
public class Curso
{
    private static final int MAX_ESTUDIANTES = 10;
    private static final int MAX_ASIGNATURAS =  6;
    private int[][] notas;
    private Random generador;

    /**
     * Constructor  
     */
    public Curso()   {
        this.generador = new Random();
        notas = new int[MAX_ESTUDIANTES][MAX_ASIGNATURAS];
        inicializar(notas);
    }

    /**
     *  Inicializa el array con notas aleatorias entre 1 y 10 inclusive
     *  Usaremos un generador
     */
    private void inicializar(int[][] notas)    {
        for (int fila = 0; fila <  notas.length; fila++)    {
            for (int col = 0; col <  notas[fila].length; col++)  {
                notas[fila][col] = generador.nextInt(10) + 1;
            }
        }
    }

    /**
     * Representación textual de las notas
     * Cada nota formateada a 4 posiciones
     * 
     */
    public String toString() {
        String strResul = "Notas del curso\n";
        for (int fila = 0; fila <  notas.length; fila++)    {
            for (int col = 0; col <  notas[fila].length; col++)  {
                strResul += String.format("%4d", notas[fila][col]);
            }
            strResul += "\n";
        }
        return strResul;
    }

    /**
     *  Muestra en pantalla  
     * 
     */
    public void escribir( )
    {
        System.out.println(this.toString());
    }

    /**
     *  
     *  Calcular la nota media por alumno
     *  Recorrido por filas
     * 
     */
    public double[] calcularMediaPorAlumno()
    {
        double[] medias = new double[notas.length];
        for (int fila = 0; fila < notas.length; fila++)    {
            double suma = 0.0;
            for (int col = 0; col < notas[fila].length; col++)  {
                suma += notas[fila][col];
            }
            medias[fila] = suma / MAX_ASIGNATURAS;
        }
        return medias;
    }

    /**
     *  
     *  Calcular la nota media por asignatura
     *  Recorrido por columnas
     * 
     */
    public double[] calcularMediaPorAsignatura()
    {
        double[] medias = new double[MAX_ASIGNATURAS];
        for (int col = 0; col < notas[0].length; col++)  {
            double suma = 0.0;
            for (int fila = 0; fila < notas.length; fila++)    {
                suma += notas[fila][col];
            }
            medias[col] =  suma / MAX_ESTUDIANTES ;
        }
        return medias;
    }

    /**
     *  @param alumno nº de alumno  
     *
     */
    public int suspensosDelAlumno(int alumno)
    {
        if (alumno < 0 || alumno >= notas.length) {
            throw new IllegalArgumentException("Error en nº alumno");
        }
        int suspensos = 0;
        for (int col = 0; col < notas[alumno].length; col++) {
            if (notas[alumno][col] < 5)  {
                suspensos ++;
            }
        }
        return suspensos;

    }

    /**
     *  @param asignatura nº de asignatura  
     *
     */
    public int aprobadosEnAsignatura(int asignatura)
    {
        if (asignatura < 0 || asignatura >= notas[0].length) {
            throw new IllegalArgumentException("Error en nº asignatura");
        }
        int aprobados = 0;
        for (int fila = 0; fila < notas.length; fila++)   {
            if (notas[fila][asignatura] >= 5)  {
                aprobados ++;
            }
        }
        return aprobados;

    }

    /**
     * 
     */
    public static char[][] ejemploRagged() {
        int[] longitudFilas = {4, 2, 5, 6};
        char[][] ragged = new char[4][];
        for (int fila = 0; fila < ragged.length; fila++) {
            ragged[fila] = new char[longitudFilas[fila]];
            for (int col = 0; col < ragged[fila].length; col++)  {
                ragged[fila][col] = 'X';
            }
        }
        return ragged;

    }

    /**
     * Código para probar la clase Curso
     */
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.escribir();
        double[] mediasPorAlumno = curso.calcularMediaPorAlumno();
        System.out.println("Media por alumno");
        System.out.println(Arrays.toString(mediasPorAlumno));
        double[] mediasPorAsignatura = curso.calcularMediaPorAsignatura();
        System.out.println("Media por asignatura");
        System.out.println(Arrays.toString(mediasPorAsignatura));
        int alumno = 7;
        System.out.println("Suspensos del alumno " + alumno +
            " = " + curso.suspensosDelAlumno(alumno));
        int asignatura = 4;
        System.out.println("Aprobados en asignatura " +
            asignatura + " = " + curso.aprobadosEnAsignatura(asignatura));

        System.out.println("Ejemplo array desigual (ragged) ");
        char[][] ragged = Curso.ejemploRagged();
        for (int fila = 0; fila < ragged.length; fila++)   {
            for (int col = 0; col < ragged[fila].length; col++)  {
                System.out.print(ragged[fila][col]);
            }
            System.out.println();
        }
    }

}